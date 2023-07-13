package az.ijob.jobposting.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private Long id;
    private String company;
    private String category;
    private String position;
    private String salary;
    private String description;
    private String requirements;
    public String employmentType;
    private String city;
    private int age;
    private String education;
    private String relevantPerson;
    private String phoneNumber;
    private String email;
    private String companyLogo;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    private int numberOfViews;
    private int serialNumber;

}
