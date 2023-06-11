package az.ijob.jobposting.dto;


import az.ijob.jobposting.model.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String name;
    private int count = 0;
    private List<Job> jobs;

}
