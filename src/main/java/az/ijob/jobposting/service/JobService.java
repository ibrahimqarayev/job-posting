package az.ijob.jobposting.service;


import az.ijob.jobposting.converter.JobConverter;
import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.exception.JobNotFoundException;
import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final JobConverter jobConverter;

    public List<JobDto> findAllJob() {
        return jobRepository.findAll()
                .stream().map(jobConverter::entityToDto).collect(Collectors.toList());
    }

    public JobDto addJob(Job job) {
        job.setCreationDate(LocalDateTime.now());
        Job savedJob = jobRepository.save(job);
        return jobConverter.entityToDto(savedJob);
    }

    public JobDto findById(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new JobNotFoundException("Job not found with id" + jobId));
        return jobConverter.entityToDto(job);
    }

    public JobDto updateJob(Long jobId, JobDto updateJob) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            job.setCompany(updateJob.getCompany());
            job.setCategory(updateJob.getCategory());
            job.setPosition(updateJob.getPosition());
            job.setSalary(updateJob.getSalary());
            job.setDescription(updateJob.getDescription());
            job.setRequirements(updateJob.getDescription());
            job.setEmploymentType(updateJob.employmentType);
            job.setCity(updateJob.getCity());
            job.setAge(updateJob.getAge());
            job.setEducation(updateJob.getEducation());
            job.setRelevantPerson(updateJob.getRelevantPerson());
            job.setPhoneNumber(updateJob.getPhoneNumber());
            job.setEmail(updateJob.getEmail());
            job.setCompanyLogo(updateJob.getCompanyLogo());
            return jobConverter.entityToDto(jobRepository.save(job));
        }
        throw new JobNotFoundException("Job not found with id " + jobId);
    }

    public void deleteById(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    public List<JobDto> searchJob(String query) {
        return jobRepository.searchJob(query).stream().map(jobConverter::entityToDto).collect(Collectors.toList());
    }

    public List<JobDto> findByCategory(String category) {
        List<Job> jobs = jobRepository.findByCategory(category);
        return jobs.stream().map(jobConverter::entityToDto).collect(Collectors.toList());
    }


}
