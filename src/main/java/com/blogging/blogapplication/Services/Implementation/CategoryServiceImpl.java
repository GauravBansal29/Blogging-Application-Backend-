package com.blogging.blogapplication.Services.Implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.blogapplication.Entities.Category;
import com.blogging.blogapplication.Exceptions.ResourceNotFoundException;
import com.blogging.blogapplication.Payloads.CategoryDto;
import com.blogging.blogapplication.Repositories.CategoryRepository;
import com.blogging.blogapplication.Services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createcategory(CategoryDto categorydto) {

        Category category = dtoTocategory(categorydto);
        Category savedCategory = categoryRepo.save(category);
        return categoryTodto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {

        Category category = categoryRepo.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Category", "id", id);
        });

        return categoryTodto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categoryList = (List<Category>) categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categoryList.stream().map((category) -> categoryTodto(category))
                .collect(Collectors.toList());
        return categoryDtoList;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {

        Category findCategory = categoryRepo.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Category", "id", id);
        });
        findCategory.setName(categoryDto.getName());
        findCategory.setDesc(categoryDto.getDesc());
        categoryRepo.save(findCategory);
        return categoryTodto(findCategory);
    }

    @Override
    public void deleteCategory(Long id) {

        Category findCategory = categoryRepo.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Category", "id", id);
        });
        categoryRepo.delete(findCategory);

    }

    // modelmappers for conversion between category and dto
    Category dtoTocategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }

    CategoryDto categoryTodto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

}
