package az.ijob.jobposting.service;


import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.exception.JobNotFoundException;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public JobDto addJob(
            String category,
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
        job.setCategory(category);
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
                .category(job.getCategory())
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

    public JobDto findById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Job not found"));
        return JobDto.builder()
                .id(job.getId())
                .category(job.getCategory())
                .position(job.getPosition())
                .company(job.getCompany())
                .city(job.getCity())
                .oHours(job.getOHours())
                .salary(job.getSalary())
                .age(job.getAge())
                .education(job.getEducation())
                .deadline(job.getDeadline())
                .email(job.getEmail())
                .description(job.getEducation())
                .requirements(job.getRequirements())
                .companyLogo(job.getCompanyLogo())
                .build();
    }

//    public Job findBy

    public List<Job> findByCriteria(String position, String category, String city) {
        if (position != null && category != null && city != null) {
            return jobRepository.findByPositionAndCategoryAndCity(position, category, city);
        } else if (position != null && category != null && city == null) {
            return jobRepository.findByPositionAndCategory(position, category);
        } else if (position != null && category == null && city != null) {
            return jobRepository.findByPositionAndCity(position, city);
        } else if (position == null && category != null && city != null) {
            return jobRepository.findByCategoryAndCity(category, city);
        } else if (position == null && category != null && city == null) {
            return jobRepository.findByCategory(category);
        } else if (position == null && category == null && city != null) {
            return jobRepository.findByCity(city);
        } else {
           return jobRepository.findAll();
        }

    }


}
