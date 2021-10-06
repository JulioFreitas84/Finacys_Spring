package trilha.back.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.dtos.request.CategoryRequest;
import trilha.back.entity.Category;
import trilha.back.repository.CategoryRepository;
import trilha.back.service.CategoryService;

import java.util.List;

//Controlador Rest
@RestController
@RequestMapping("/category")
public class CategoryController {

    //injetar dependencia da interface categoryRepository dentro desse cara
    @Autowired
    private CategoryService categoryService;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> postCategory(Category category) {
        return ResponseEntity.ok(categoryService.salvarCategory(category).getId());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Category>> getCategoryList(){
        return ResponseEntity.ok(categoryService.getCategoryList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Category> getCategoryList(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryList(id).orElseThrow());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> atualizacategory(@PathVariable Long id,@RequestBody Category category){
        return ResponseEntity.ok(categoryService.atualizacategory(id, category);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deletaCategory(@PathVariable Long id) {
        categoryService.deletaCategory(id);
       return ResponseEntity.ok().body(HttpStatus.OK) ;
    }

    @GetMapping("/validarId/{id}")
    public ResponseEntity<Object> getValidatId(@PathVariable Long id){
        if (categoryService.validar()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }

    @Validated
    public ResponseEntity<Boolean> validaCategoryById(@Validated @RequestBody Long id){
        if (id != null){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

