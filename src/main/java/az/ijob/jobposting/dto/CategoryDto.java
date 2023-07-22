package az.ijob.jobposting.dto;

import az.ijob.jobposting.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;

    public static CategoryDto convertToDto(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }
}
