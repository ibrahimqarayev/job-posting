package az.ijob.jobposting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {

    private Long id;
    private String position;
    private String company;
    public String city;
    public String oHours;
    private Integer salary;
    private Integer age;
    private String education;
    private SimpleDateFormat deadline;
    private String email;
    private String description;
    private String requirements;
    private String companyLogo;
}
