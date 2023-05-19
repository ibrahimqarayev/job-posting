package az.ijob.jobposting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacancyDto {
    private Long id;
    private String name;
    private int salary;
    private String company;
    private String logo;
    private String location;
    private LocalDateTime creationTime;
}
