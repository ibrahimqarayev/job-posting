package az.ijob.jobposting.contoller;

import az.ijob.jobposting.dto.LoginDto;
import az.ijob.jobposting.dto.RegistrationDto;
import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.model.User;
import az.ijob.jobposting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;


    @GetMapping("/login")
    public String loginForm(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("user", loginDto);
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") LoginDto loginDto) {

        boolean check = userService.login(loginDto);
        if (check) {
            return "panel";
        } else {
            return "redirect:/login";
        }


    }


    @GetMapping("/register")
    public String registerForm(Model model) {
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("user", registrationDto);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") RegistrationDto registrationDto) {
        userService.saveUser(registrationDto);
        return "redirect:/login";
    }


}
