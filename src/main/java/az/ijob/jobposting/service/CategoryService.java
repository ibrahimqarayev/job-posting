package az.ijob.jobposting.service;

import az.ijob.jobposting.dto.CategoryDto;
import az.ijob.jobposting.exception.CategoryNotFoundException;
import az.ijob.jobposting.model.Category;
import az.ijob.jobposting.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto create(Category category) {
        return CategoryDto.convertToDto(categoryRepository.save(category));
    }

    public CategoryDto findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return CategoryDto.convertToDto(optionalCategory.get());
        }
        throw new CategoryNotFoundException("Category not found with id " + id);
    }
}
