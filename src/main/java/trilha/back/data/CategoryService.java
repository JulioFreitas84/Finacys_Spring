package trilha.back.data;

import org.springframework.http.ResponseEntity;
import trilha.back.presenter.dtos.request.CriarCategoriaRequest;
import trilha.back.presenter.dtos.response.CriarCategoriaResponse;
import trilha.back.domain.Category;

import java.util.List;

public interface CategoryService {

    CriarCategoriaResponse salvarCategory(CriarCategoriaRequest category);

    ResponseEntity<List<Category>> getCategoryList();

    ResponseEntity<Category> getCategoryList(Long id);

    Category atualizacategory(Long id, Category category);

    void deletaCategory(Long id);

    boolean validar();



}
