package az.ijob.jobposting.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "vacancies")
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String position;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    public String city;
    public String oHours;
    private Integer salary;
    private Integer age;
    private String education;
    private String email;
    private String description;
    private String requirements;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String companyLogo;

}
