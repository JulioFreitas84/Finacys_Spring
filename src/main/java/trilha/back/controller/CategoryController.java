package trilha.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import trilha.back.entity.Category;
import trilha.back.service.CategoryService;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category salvar(@RequestBody Category category) {
        return categoryService.salvar(category);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCategoryId(@PathVariable("id") Long id) {
        categoryService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        categoryService.listCategory();
    }

}

