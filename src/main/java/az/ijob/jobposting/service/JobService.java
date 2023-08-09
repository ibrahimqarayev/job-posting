package az.ijob.jobposting.service;


import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.dto.request.CreateJobRequest;
import az.ijob.jobposting.dto.request.UpdateJobRequest;
import az.ijob.jobposting.exception.ResourceNotFoundException;
import az.ijob.jobposting.model.Company;
import az.ijob.jobposting.model.Job;
import az.ijob.jobposting.repository.JobRepository;
import az.ijob.jobposting.utils.ImageUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final ConverterService converter;
    private final CategoryService categoryService;
    private final CompanyService companyService;
    private final ImageUpload imageUpload;

    public Job addJob(MultipartFile companyLogo, CreateJobRequest createRequest) {

        Company company = companyService.findByName(createRequest.getCompanyName());

        Job job = new Job();
        try {
            if (companyLogo == null) {
                job.setCompanyLogo(null);
                company.setLogo(null);
            } else {
                imageUpload.uploadFile(companyLogo);
                job.setCompanyLogo(Base64.getEncoder().encodeToString(companyLogo.getBytes()));

                company.setLogo(Base64.getEncoder().encodeToString(companyLogo.getBytes()));
            }

            job.setCompany(company);
            job.setCategory(categoryService.finById(createRequest.getCategoryId()));
            job.setPosition(createRequest.getPosition());
            job.setDescription(createRequest.getDescription());
            job.setRequirements(createRequest.getRequirements());
            job.setEmploymentType(createRequest.getEmploymentType());
            job.setCity(createRequest.getCity());
            job.setEducation(createRequest.getEducation());
            job.setRelevantPerson(createRequest.getRelevantPerson());
            job.setPhoneNumber(createRequest.getPhoneNumber());
            job.setEmail(createRequest.getEmail());
            job.setCreationDate(LocalDateTime.now());

            return jobRepository.save(job);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Job> findAllJob() {
        return jobRepository.findAll();
    }

    public List<Job> findTop10NewJobs() {
        return jobRepository.findTop10ByOrderByCreationDateDesc();
    }

    public Job findById(Long jobId) {
        return jobRepository.findById(jobId).orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + jobId));
    }


    public Job updateJob(Long jobId, UpdateJobRequest updateJob) {
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
        return jobRepository.save(job);
    }

    public void deleteById(Long jobId) {
        jobRepository.deleteById(jobId);
    }


    public List<JobDto> searchJob(String query) {
        return jobRepository.searchJob(query).stream().map(converter::toDto).collect(Collectors.toList());
    }


    protected Job getJobById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Job not found with id"));
    }

}
