package az.ijob.jobposting.service;

import az.ijob.jobposting.dto.CategoryDto;
import az.ijob.jobposting.exception.ResourceNotFoundException;
import az.ijob.jobposting.model.Category;
import az.ijob.jobposting.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto create(Category category) {
        return CategoryDto.convertToDto(categoryRepository.save(category));
    }

    public CategoryDto findById(Long id) {
        return CategoryDto.convertToDto(getCategoryById(id));
    }

    protected Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found id " + id));
    }
}
