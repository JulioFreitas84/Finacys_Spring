package trilha.back.repository;

import org.springframework.http.ResponseEntity;
import trilha.back.controller.dtos.request.CriarCategoriaRequest;
import trilha.back.controller.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Category;

import java.util.List;

public interface CategoryRepository {

    CriarCategoriaResponse salvarCategory(CriarCategoriaRequest category);

    ResponseEntity<List<Category>> getCategoryList();

    ResponseEntity<Category> getCategoryList(Long id);

    Category atualizacategory(Long id, Category category);

    void deletaCategory(Long id);

    boolean validar();

}
