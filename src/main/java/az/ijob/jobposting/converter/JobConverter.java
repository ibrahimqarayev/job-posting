package az.ijob.jobposting.converter;

import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.model.Job;
import org.springframework.stereotype.Component;

@Component
public class JobConverter {

    public JobDto entityToDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setCompany(job.getCompany());
        jobDto.setCategory(job.getCategory());
        jobDto.setPosition(job.getPosition());
        jobDto.setSalary(job.getSalary());
        jobDto.setDescription(job.getDescription());
        jobDto.setRequirements(job.getRequirements());
        jobDto.setEmploymentType(job.getEmploymentType());
        jobDto.setCity(job.getCity());
        jobDto.setAge(job.getAge());
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

    public Job dtoToEntity(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setCompany(jobDto.getCompany());
        job.setCategory(jobDto.getCategory());
        job.setPosition(jobDto.getPosition());
        job.setSalary(jobDto.getSalary());
        job.setDescription(jobDto.getDescription());
        job.setRequirements(jobDto.getRequirements());
        job.setEmploymentType(jobDto.getEmploymentType());
        job.setCity(jobDto.getCity());
        job.setAge(jobDto.getAge());
        job.setEducation(jobDto.getEducation());
        job.setRelevantPerson(jobDto.getRelevantPerson());
        job.setPhoneNumber(jobDto.getPhoneNumber());
        job.setEmail(jobDto.getEmail());
        job.setCompanyLogo(jobDto.getCompanyLogo());
        job.setCreationDate(jobDto.getCreationDate());
        job.setExpirationDate(jobDto.getExpirationDate());
        job.setNumberOfViews(jobDto.getNumberOfViews());
        job.setSerialNumber(jobDto.getSerialNumber());
        return job;
    }

}
