package az.ijob.jobposting.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping({"/index","/home"})
    public String indexPage(){
        return "index";
    }

    @GetMapping("/vacancies")
    public String vacanciesPage(){
        return "vacancies";
    }

    @GetMapping("/contact")
    public String contactPage(){
        return "contact";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }


}
