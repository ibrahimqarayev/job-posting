package az.ijob.jobposting.contoller;

import az.ijob.jobposting.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;


}
