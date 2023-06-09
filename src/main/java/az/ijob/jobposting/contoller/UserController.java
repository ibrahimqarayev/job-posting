package az.ijob.jobposting.contoller;

import az.ijob.jobposting.model.User;
import az.ijob.jobposting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "rePassword") String rePassword
    ) {

        if (password == rePassword) {
            userService.register(name, surname, email, password);
        } else {
            throw new RuntimeException("PASSWORD EXCEPTION");
        }
        return "login";

    }

    // T E S T


}
