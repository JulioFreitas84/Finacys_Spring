package trilha.back.service.impl;

import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.controller.dtos.request.CriarCategoriaRequest;
import trilha.back.controller.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Category;
import trilha.back.mapper.CategoryMapper;
import trilha.back.service.repository.CategoryRepository;
import trilha.back.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplements implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CriarCategoriaResponse salvarCategory(CriarCategoriaRequest category) {
        Category model = categoryMapper.requestToModel(category);
        model.setDescription(category.getDescription());
        return categoryMapper.modelCategoryToResponse(categoryRepository.save(model));
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
        base.setDescription(category.getDescription());
        return base;
    }

    @Override
    public void deletaCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean validar(Long id) {
        Optional<Category> cat = categoryRepository.findById(id);
        return cat.isPresent();
    }
}
