package az.ijob.jobposting.contoller;

import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/companies")
    public String companies() {
        return "companies";
    }

    @GetMapping("/job-list")
    public String jobList(Model model) {
        List<Job> jobs = jobService.findAll();
        model.addAttribute("jobs", jobs);
        return "job-list";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/add")
    public String addForm() {
        return "add-job";
    }

    @PostMapping("/add-job")
    public String addJob(
            @RequestParam(name = "position",required = false) String position,
            @RequestParam(name = "company",required = false) String company,
            @RequestParam(name = "city",required = false) String city,
            @RequestParam(name = "oHours",required = false) String oHours,
            @RequestParam(name = "salary", required = false) Integer salary,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "education", required = false) String education,
            @RequestParam(name = "deadline", required = false) SimpleDateFormat deadline,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "requirements", required = false) String requirements,
            @RequestParam(name = "companyLogo", required = false) MultipartFile companyLogo
    ) {
        jobService.addJob(position, company, city,oHours, salary, age, education, deadline, email, description, requirements, companyLogo);
        return "redirect:/job-list";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("xeta")
    public String xeta() {
        return "404";
    }


}
