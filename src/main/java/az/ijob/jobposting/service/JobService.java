package az.ijob.jobposting.service;


import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.dto.request.CreateJobRequest;
import az.ijob.jobposting.dto.request.UpdateJobRequest;
import az.ijob.jobposting.exception.ResourceNotFoundException;
import az.ijob.jobposting.model.Category;
import az.ijob.jobposting.model.Company;
import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final ConverterService converter;
    private final CategoryService categoryService;
    private final CompanyService companyService;

    public JobDto addJob(CreateJobRequest createRequest) {
        Job job = converter.toEntity(createRequest);
        job.setCreationDate(LocalDateTime.now());
        return converter.toDto(jobRepository.save(job));
    }

    public List<JobDto> findAllJob() {
        return jobRepository.findAll()
                .stream().map(converter::toDto).collect(Collectors.toList());
    }

    public JobDto findById(Long jobId) {
        return converter.toDto(jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + jobId)));
    }


    public JobDto updateJob(Long jobId, UpdateJobRequest updateJob) {
        Job job = getJobById(jobId);
        job.setCompany(companyService.findByName(updateJob.getCompanyName()));
        job.setCategory(categoryService.finById(updateJob.getCategoryId()));
        job.setPosition(updateJob.getPosition());
        job.setDescription(updateJob.getDescription());
        job.setRequirements(updateJob.getDescription());
        job.setEmploymentType(updateJob.employmentType);
        job.setCity(updateJob.getCity());
        job.setEducation(updateJob.getEducation());
        job.setRelevantPerson(updateJob.getRelevantPerson());
        job.setPhoneNumber(updateJob.getPhoneNumber());
        job.setEmail(updateJob.getEmail());
        job.setCompanyLogo(updateJob.getCompanyLogo());
        return converter.toDto(jobRepository.save(job));
    }

    public void deleteById(Long jobId) {
        jobRepository.deleteById(jobId);
    }


    public List<JobDto> searchJob(String query) {
        return jobRepository.searchJob(query).stream().map(converter::toDto).collect(Collectors.toList());
    }

//    public List<JobDto> findByCategory(String category) {
//        List<Job> jobs = jobRepository.findByCategory(category);
//        return jobs.stream().map(converter::toDto).collect(Collectors.toList());
//    }

    protected Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found with id"));
    }

}
