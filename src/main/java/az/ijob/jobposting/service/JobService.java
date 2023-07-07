package az.ijob.jobposting.service;


import az.ijob.jobposting.converter.JobConverter;
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
    private final JobConverter jobConverter;

    public List<JobDto> findAllJob() {
        return jobRepository.findAll()
                .stream().map(jobConverter::entityToDto).collect(Collectors.toList());
    }

    public void addJob(Job job) {
        jobRepository.save(job);
    }

    public JobDto findById(Long jobId) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new JobNotFoundException("Job not found !"));
        return jobConverter.entityToDto(job);
    }

    public void updateJob(JobDto jobDto) {
        Job job = jobConverter.dtoToEntity(jobDto);
        jobRepository.save(job);
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
