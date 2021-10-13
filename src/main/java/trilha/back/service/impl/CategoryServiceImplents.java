package trilha.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.controller.dtos.request.CriarCategoriaRequest;
import trilha.back.controller.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Category;
import trilha.back.repository.CategoryRepository;
import trilha.back.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImplents implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CriarCategoriaResponse salvarCategory(CriarCategoriaRequest category) {
        Category model = new Category();
        model.setName(category.getName());
        model.setDescription(category.getDescricao());
        categoryRepository.save(model);
        return new CriarCategoriaResponse(model.getId(), model.getName(), model.getDescription()) ;
    }

    @Override
    public ResponseEntity<List<Category>> getCategoryList() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @Override
    public ResponseEntity<Category> getCategoryList(Long id) {
        return ResponseEntity.ok(categoryRepository.findById(id).orElseThrow());
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
