package trilha.back.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.dto.CategoryDto;
import trilha.back.entity.Category;
import trilha.back.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    //injetar
    @Autowired
    private CategoryService categoryService;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category salvar(@RequestBody Category category) {
        return categoryService.salvar(category);
    }

    @Validated
    public ResponseEntity<Boolean> validaCategoryById(@Validated @RequestBody Long id){
      buscarCategoryPorId(id);
      if (id != null){
          return new ResponseEntity<>(HttpStatus.OK);
      }else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> listCategory() {
        List<Category> categories = categoryService.listCategory();
        return CategoryDto.convert(categories);
       // return categoryService.listCategory();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Category buscarCategoryPorId(@PathVariable("id") Long id){
        return categoryService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category naõ encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCategoryId(@PathVariable("id") Long id) {
        categoryService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        categoryService.buscarPorId(id)
                .map(categoryBase -> {
                    modelMapper.map(category, categoryBase);
                    categoryService.salvar(categoryBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category naõ encontrado"));
    }
}

