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
    private final ConverterService converter;
    private final CategoryService categoryService;

    public List<JobDto> findAllJob() {
        return jobRepository.findAll()
                .stream().map(converter::entityToDto).collect(Collectors.toList());
    }

    //
    public JobDto addJob(JobDto jobDto) {
        return converter.entityToDto(jobRepository.save(converter.dtoToEntity(jobDto)));
    }

    public JobDto findById(Long jobId) {
        return converter.entityToDto(getJobById(jobId));
    }


    public JobDto updateJob(Long jobId, JobDto updateJob) {
        Job job = getJobById(jobId);
        job.setCompany(updateJob.getCompany());
        job.setCategory(categoryService.getCategoryById(updateJob.getCategoryId()));
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
        return converter.entityToDto(jobRepository.save(job));
}

    public void deleteById(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    public List<JobDto> searchJob(String query) {
        return jobRepository.searchJob(query).stream().map(converter::entityToDto).collect(Collectors.toList());
    }

    public List<JobDto> findByCategory(String category) {
        List<Job> jobs = jobRepository.findByCategory(category);
        return jobs.stream().map(converter::entityToDto).collect(Collectors.toList());
    }

    protected Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("Job not found with id"));
    }

}
