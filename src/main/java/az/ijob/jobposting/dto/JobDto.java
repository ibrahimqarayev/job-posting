package az.ijob.jobposting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private Long id;
    private String name;
    private int salary;
    private String company;
    private String logo;
    private String location;
    private LocalDateTime creationTime;
}
