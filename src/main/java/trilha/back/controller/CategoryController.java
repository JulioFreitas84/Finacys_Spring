package trilha.back.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import trilha.back.controller.dtos.request.CriarCategoriaRequest;
import trilha.back.entity.Category;
import trilha.back.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

//Controlador Rest
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    public ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Object> postCategory(@RequestBody CriarCategoriaRequest request) {
        return ResponseEntity.ok(categoryService.salvarCategory(request));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategoryList(){
        return ResponseEntity.ok(categoryService.getCategoryList().getBody());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryList(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryList(id)).getBody();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> atualizaCategory(@PathVariable Long id,@RequestBody Category category){
        return ResponseEntity.ok(categoryService.atualizacategory(id, category));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaCategory(@PathVariable Long id) {
        categoryService.deletaCategory(id);
       return ResponseEntity.ok().body(HttpStatus.OK) ;
    }

    @GetMapping("/validarId/{id}")
    public ResponseEntity<Object> getValidatId(@PathVariable @Valid Long id){
        if (categoryService.validar(id)){
            return ResponseEntity.ok(id);
        }
        return ResponseEntity.notFound().build();
    }
}

