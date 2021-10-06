package trilha.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.dtos.request.CategoryRequest;
import trilha.back.dtos.response.CategoryResponse;
import trilha.back.entity.Category;
import trilha.back.repository.CategoryRepository;
import trilha.back.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplents implements  CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category salvarCategory(CategoryRequest category) {
        return categoryRepository.save(category);
    }

    @Override
    public ResponseEntity<List<Category>> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public ResponseEntity<Category> getCategoryList(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public Category atualizacategory(Long id, Category category) {
        Category base = categoryRepository.findById(id).orElseThrow();
        return categoryRepository.save(novoAtualizado(base, category));
    }

    private Category novoAtualizado(Category base, Category category) {
        base.setName(category.getName());
        return base;
    }

    @Override
    public void deletaCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean validar() {
        return false;
    }
}
