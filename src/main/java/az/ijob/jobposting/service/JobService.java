package az.ijob.jobposting.service;


import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.exception.JobNotFoundException;
import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public List<JobDto> findAllJob() {
        return jobRepository.findAll()
                .stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public void addJob(Job job) {
        jobRepository.save(job);
    }

    public JobDto findById(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new JobNotFoundException("Job not found !"));
        return entityToDto(job);
    }

    public void updateJob(JobDto jobDto) {
        Job job = dtoToEntity(jobDto);
        jobRepository.save(job);
    }

    public void deleteById(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    public List<JobDto> searchJob(String query) {
        return jobRepository.searchJob(query).stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<JobDto> findByCategory(String category) {
        return jobRepository.findByCategory(category).stream().map(job -> entityToDto(job)).collect(Collectors.toList());
    }


    //Convert
    public JobDto entityToDto(Job job) {
        return new JobDto(
                job.getId(),
                job.getCategory(),
                job.getPosition(),
                job.getCompany(),
                job.getCity(),
                job.getOHours(),
                job.getSalary(),
                job.getAge(),
                job.getEducation(),
                job.getEmail(),
                job.getDescription(),
                job.getRequirements(),
                job.getCompanyLogo()
        );
    }

    public Job dtoToEntity(JobDto jobDto) {
        return new Job(
                jobDto.getId(),
                jobDto.getCategory(),
                jobDto.getPosition(),
                jobDto.getCompany(),
                jobDto.getCity(),
                jobDto.getOHours(),
                jobDto.getSalary(),
                jobDto.getAge(),
                jobDto.getEducation(),
                jobDto.getEmail(),
                jobDto.getDescription(),
                jobDto.getRequirements(),
                jobDto.getCompanyLogo()
        );
    }

}
