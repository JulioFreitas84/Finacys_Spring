package trilha.back.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import trilha.back.dtos.request.CategoryRequest;
import trilha.back.entity.Category;

import java.util.List;

public interface CategoryService {

    Category salvarCategory(CategoryRequest category);

    ResponseEntity<List<Category>> getCategoryList();

    ResponseEntity<Category> getCategoryList(Long id);

    Category atualizacategory(Long id, Category category);

    void deletaCategory(Long id);

    boolean validar();

}
