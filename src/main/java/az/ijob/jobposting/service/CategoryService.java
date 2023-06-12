package az.ijob.jobposting.service;

import az.ijob.jobposting.dto.CategoryDto;
import az.ijob.jobposting.model.Category;
import az.ijob.jobposting.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return entityToDto(category);
    }

    public CategoryDto entityToDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getCount(),
                category.getJobs()
        );
    }

    public Category dtoToEntity(CategoryDto categoryDto) {
        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getCount(),
                categoryDto.getJobs()
        );
    }


}
