package az.ijob.jobposting.service;

import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.dto.request.CreateJobRequest;
import az.ijob.jobposting.model.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConverterService {
    private final CategoryService categoryService;
    private final CompanyService companyService;

    public Job toEntity(CreateJobRequest createRequest) {
        Job job = new Job();
        job.setCompany(companyService.findByName(createRequest.getCompanyName()));
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
        job.setCompanyLogo(createRequest.getCompanyLogo());
        return job;
    }

    public JobDto toDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setCompanyName(job.getCompany().getName());
        jobDto.setCategoryName(job.getCategory().getName());
        jobDto.setPosition(job.getPosition());
        jobDto.setDescription(job.getDescription());
        jobDto.setRequirements(job.getRequirements());
        jobDto.setEmploymentType(job.getEmploymentType());
        jobDto.setCity(job.getCity());
        jobDto.setEducation(job.getEducation());
        jobDto.setRelevantPerson(job.getRelevantPerson());
        jobDto.setPhoneNumber(job.getPhoneNumber());
        jobDto.setEmail(job.getEmail());
        jobDto.setCompanyLogo(job.getCompanyLogo());
        jobDto.setCreationDate(job.getCreationDate());
        jobDto.setExpirationDate(job.getExpirationDate());
        jobDto.setNumberOfViews(job.getNumberOfViews());
        jobDto.setSerialNumber(job.getSerialNumber());
        return jobDto;
    }


}
