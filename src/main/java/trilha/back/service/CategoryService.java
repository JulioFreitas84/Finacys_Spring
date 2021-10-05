package trilha.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.CategoryModel;
import trilha.back.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryModel salvar(CategoryModel category){
        return categoryRepository.save(category);
    }

    public List<CategoryModel> listCategory(){
        return (List<CategoryModel>) categoryRepository.findAll();
    }

    public Optional<CategoryModel> buscarPorId(Long id){
        return categoryRepository.findById(id);
    }

    public void removerPorId(Long id){
        categoryRepository.deleteById(id);
    }

    public boolean validaCategoryById(Long id){
       return categoryRepository.findById(id).isPresent();
    }
}
