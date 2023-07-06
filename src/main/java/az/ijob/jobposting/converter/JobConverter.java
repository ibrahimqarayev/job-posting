package az.ijob.jobposting.converter;

import az.ijob.jobposting.dto.JobDto;
import az.ijob.jobposting.model.Job;
import org.springframework.stereotype.Component;

@Component
public class JobConverter {

    public  JobDto entityToDto(Job job) {

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

    public  Job dtoToEntity(JobDto jobDto) {
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
