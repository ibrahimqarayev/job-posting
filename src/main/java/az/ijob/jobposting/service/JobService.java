package az.ijob.jobposting.service;


import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public JobDto addJob(
            String position,
            String company,
            String city,
            String oHours,
            Integer salary,
            Integer age,
            String education,
            SimpleDateFormat deadline,
            String email,
            String description,
            String requirements,
            MultipartFile companyLogo
    ) {


        Job job = new Job();
        job.setPosition(position);
        job.setCompany(company);
        job.setCity(city);
        job.setOHours(oHours);
        job.setSalary(salary);
        job.setAge(age);
        job.setEducation(education);
        job.setDeadline(deadline);
        job.setEmail(email);
        job.setDescription(description);
        job.setRequirements(requirements);


        if (companyLogo != null && !companyLogo.isEmpty()) {
            String fileName = StringUtils.cleanPath(companyLogo.getOriginalFilename());
            if (fileName.contains("..")) {
                System.out.println("Not a valid file");
            }
            try {
                job.setCompanyLogo(Base64.getEncoder().encodeToString(companyLogo.getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("FAYL XƏTASI");
        }


        Job savedJob = jobRepository.save(job);
        return JobDto.builder()
                .id(savedJob.getId())
                .position(savedJob.getPosition())
                .company(savedJob.getCompany())
                .city(savedJob.getCity())
                .oHours(savedJob.getOHours())
                .salary(savedJob.getSalary())
                .age(savedJob.getAge())
                .education(savedJob.getEducation())
                .deadline(savedJob.getDeadline())
                .email(savedJob.getEmail())
                .description(savedJob.getEducation())
                .requirements(savedJob.getRequirements())
                .companyLogo(savedJob.getCompanyLogo())
                .build();

    }


    public List<Job> findAll() {
        return jobRepository.findAll();
    }

}
