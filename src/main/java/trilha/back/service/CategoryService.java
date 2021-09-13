package trilha.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.Category;
import trilha.back.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category salvar(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> listCategory(){
        return (List<Category>) categoryRepository.findAll();
    }
    public Optional<Category> buscarPorId(Long id){
        return categoryRepository.findById(id);
    }

    public void removerPorId(Long id){
        categoryRepository.deleteAll();
    }
}
