package az.ijob.jobposting.contoller;

import az.ijob.jobposting.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
}
