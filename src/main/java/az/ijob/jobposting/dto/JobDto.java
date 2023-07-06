package az.ijob.jobposting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {

    private Long id;
    private String category;
    private String position;
    private String company;
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
