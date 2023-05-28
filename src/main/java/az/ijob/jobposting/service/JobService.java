package az.ijob.jobposting.service;


import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public JobDto add(String name, int salary, String company, String location, MultipartFile logo) {

        String fileName = StringUtils.cleanPath(logo.getOriginalFilename());

        Job job = new Job();
        job.setName(name);
        job.setSalary(salary);
        job.setCompany(company);

        try {
            job.setLogo(Base64.getEncoder().encodeToString(logo.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        job.setLocation(location);
        job.setCreationTime(LocalDateTime.now());

        jobRepository.save(job);

        return JobDto.builder()
                .id(job.getId())
                .name(job.getName())
                .salary(job.getSalary())
                .company(job.getCompany())
                .location(job.getLocation())
                .creationTime(job.getCreationTime())
                .build();
    }

    public List<Job> findAll(){
        return jobRepository.findAll();
    }

}
