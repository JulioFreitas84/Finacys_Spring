package trilha.back.service;

import org.springframework.http.ResponseEntity;
import trilha.back.dtos.request.CriarCategoriaRequest;
import trilha.back.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Category;

import java.util.List;

public interface CategoryService {

    CriarCategoriaResponse salvarCategory(CriarCategoriaRequest category);

    ResponseEntity<List<Category>> getCategoryList();

    ResponseEntity<Category> getCategoryList(Long id);

    Category atualizacategory(Long id, Category category);

    void deletaCategory(Long id);

    boolean validar();

}
