package az.ijob.jobposting.contoller;

import az.ijob.jobposting.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/companies")
    public String companies(){
        return "companies";
    }

    @GetMapping("/job-list")
    public String jobListie(){
        return "job-list";
    }

}
