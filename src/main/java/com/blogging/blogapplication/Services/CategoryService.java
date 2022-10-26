package com.blogging.blogapplication.Services;

import com.blogging.blogapplication.Payloads.CategoryDto;
import java.util.List;

public interface CategoryService {

    // create
    CategoryDto createcategory(CategoryDto category);

    // get a category
    CategoryDto getCategoryById(Long id);

    // get all categories
    List<CategoryDto> getAllCategories();

    // update category
    CategoryDto updateCategory(CategoryDto categoryDto, Long id);

    // delete category
    void deleteCategory(Long id);

}
