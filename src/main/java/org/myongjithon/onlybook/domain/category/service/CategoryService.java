package org.myongjithon.onlybook.domain.category.service;

import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.domain.category.dto.CategoryResponseDTO;
import org.myongjithon.onlybook.domain.category.dto.CreateCategoryDTO;
import org.myongjithon.onlybook.domain.category.entity.Category;
import org.myongjithon.onlybook.domain.category.repository.CategoryRepository;
import org.myongjithon.onlybook.exception.NotFoundException;
import org.myongjithon.onlybook.exception.errorcode.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createCategory(CreateCategoryDTO createCategoryDTO) {
        Category category = Category.builder()
                .name(createCategoryDTO.getName())
                .build();
        categoryRepository.save(category);
    }

    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = this.categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_CATEGORY));
        return CategoryResponseDTO.builder()
                .name(category.getName())
                .build();
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}