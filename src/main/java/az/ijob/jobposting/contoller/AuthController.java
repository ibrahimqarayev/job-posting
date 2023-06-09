package az.ijob.jobposting.contoller;

import az.ijob.jobposting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "rePassword") String rePassword
    ) {

        if (Objects.equals(password, rePassword)) {
            userService.register(name, surname, email, password);
        } else {
            throw new RuntimeException("PASSWORD EXCEPTION");
        }
        return "login";

    }


    @PostMapping("/login")
    public String login(String email, String password) {

        if (userService.login(email, password)) {
            return "panel";
        }
        return "login";
    }

}
