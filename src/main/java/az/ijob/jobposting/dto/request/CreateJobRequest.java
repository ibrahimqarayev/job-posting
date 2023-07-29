package az.ijob.jobposting.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobRequest {
    private Long id;
    private String companyName;
    private Long categoryId;
    private String position;
    private String description;
    private String requirements;
    public String employmentType;
    private String city;
    private String education;
    private String relevantPerson;
    private String phoneNumber;
    private String email;
    private String companyLogo;

}
