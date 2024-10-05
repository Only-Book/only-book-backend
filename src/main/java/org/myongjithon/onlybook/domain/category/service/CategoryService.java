package org.myongjithon.onlybook.domain.category.service;

import lombok.AllArgsConstructor;
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

    @Autowired
    private final CategoryRepository categoryRepository;

    public Category createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_CATEGORY));
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}