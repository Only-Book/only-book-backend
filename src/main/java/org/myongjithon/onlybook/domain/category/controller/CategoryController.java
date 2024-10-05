package org.myongjithon.onlybook.domain.category.controller;

import lombok.AllArgsConstructor;
import org.myongjithon.onlybook.ResponseDto;
import org.myongjithon.onlybook.domain.category.dto.CategoryResponseDTO;
import org.myongjithon.onlybook.domain.category.dto.CreateCategoryDTO;
import org.myongjithon.onlybook.domain.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ResponseDto<Void>> createCategory(@RequestParam CreateCategoryDTO createCategoryDTO) {
        categoryService.createCategory(createCategoryDTO);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.CREATED, "카테고리 생성 성공"), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<CategoryResponseDTO>> getCategoryById(@PathVariable Long id) {
        CategoryResponseDTO categoryResponseDTO = categoryService.getCategoryById(id);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "카테고리 조회 성공", categoryResponseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(ResponseDto.res(HttpStatus.OK, "카테고리 삭제 성공"), HttpStatus.OK);
    }
}