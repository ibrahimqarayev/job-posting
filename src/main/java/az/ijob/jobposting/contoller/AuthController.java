package az.ijob.jobposting.contoller;

import az.ijob.jobposting.dto.UserDto;
import az.ijob.jobposting.model.User;
import az.ijob.jobposting.request.LoginRequest;
import az.ijob.jobposting.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String addNewUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                             BindingResult result,
                             Model model) {
        try {
            if (result.hasErrors()) {
                model.addAttribute("userDto", userDto);
                model.addAttribute("result", result.getFieldError().getDefaultMessage());
                result.getFieldError().getDefaultMessage().toString();
                result.toString();
                return "register";
            }

            String email = userDto.getEmail();
            boolean check = userService.existsByEmail(email);

            if (check) {
                model.addAttribute("userDto", userDto);
                model.addAttribute("emailError", "You email has been registered !");
                System.out.println("User not null !");
                return "register";
            }
            if (userDto.getPassword().equals(userDto.getRepeatPassword())) {
                userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
                userService.save(userDto);
                System.out.println("User saved !");
                model.addAttribute("userDto", userDto);
                model.addAttribute("success", "Registered successfully !");
            } else {
                model.addAttribute("userDto", userDto);
                model.addAttribute("passwordError", "Password is not same !");
                System.out.println("Password is not same !");
                return "register";
            }
            userService.save(userDto);
            model.addAttribute("userDto", userDto);
            model.addAttribute("success", "Registered successfully !");

        } catch (Exception e) {
            model.addAttribute("errors", "Can not registered because server error !");
        }
        return "register";
    }


    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginRequest") LoginRequest loginRequest,
                        BindingResult result,
                        Model model) {
        try {
            if (result.hasErrors()) {
                model.addAttribute("loginRequest", loginRequest);
                model.addAttribute("result", result.getFieldError().getDefaultMessage());
                result.getFieldError().getDefaultMessage().toString();
                result.toString();
                return "login";
            }

            String email = loginRequest.getEmail();
            boolean check = userService.existsByEmail(email);

            if (!check) {
                model.addAttribute("loginRequest", loginRequest);
                model.addAttribute("emailError", "Email not registered" + email);
                System.out.println("Email not registered");
                return "login";
            }

            User user = userService.findByEmail(email);
            boolean matches = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
            if (matches) {
                return "dashboard";
            } else {
                model.addAttribute("loginError", "Email or password wrong");
            }
        } catch (Exception e) {
            model.addAttribute("errors", e.getCause().toString());
        }
        return "login";
    }

}
