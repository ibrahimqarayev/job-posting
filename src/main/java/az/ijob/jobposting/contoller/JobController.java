package az.ijob.jobposting.contoller;

import az.ijob.jobposting.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public String home() {
        return "index";
    }

}
