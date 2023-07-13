package az.ijob.jobposting.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "vacancies")
@NoArgsConstructor
@AllArgsConstructor
public class Job extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "company")
    @NotBlank(message = "Şirkət adı boş buraxıla bilməz")
    private String company;
    @Column(name = "category")
    @NotBlank(message = "Kateqoriya boş buraxıla bilməz")
    private String category;
    @Column(name = "position")
    @NotBlank(message = "Vəzifə boş buraxıla bilməz")
    private String position;
    @Column(name = "salary")
    private String salary;
    @Column(name = "description")
    private String description;
    @Column(name = "requirements")
    private String requirements;
    @Column(name = "employment_type")
    public String employmentType;
    @Column(name = "city")
    private String city;
    @Column(name = "age")
    private int age;
    @Column(name = "education")
    private String education;
    @Column(name = "relevant_person")
    @NotBlank(message = "Əlaqədar şəxs bölməsi boş buraxıla bilməz")
    private String relevantPerson;
    @Column(name = "phone_number")
    @NotBlank(message = "Əlaqə nömrəsi daxil edin")
    private String phoneNumber;
    @Column(name = "email")
    @Email(message = "Daxil etdiyiniz email formatı yalnışdır")
    private String email;
    @Lob
    @Column(name = "company_logo", columnDefinition = "MEDIUMBLOB")
    private String companyLogo;
}
