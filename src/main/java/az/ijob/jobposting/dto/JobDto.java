package az.ijob.jobposting.dto;

import az.ijob.jobposting.model.Category;
import az.ijob.jobposting.model.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {

    private Long id;
    private Category category;
    private String position;
    private Company company;
    public String city;
    public String oHours;
    private Integer salary;
    private Integer age;
    private String education;
    private String email;
    private String description;
    private String requirements;
    private String companyLogo;

}
