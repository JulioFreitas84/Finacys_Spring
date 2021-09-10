package trilha.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.Category;
import trilha.back.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    public Category salvar(Category category){
        return CategoryRepository.save(category);
    }

    public List<Category> listCategory(){
        return CategoryRepository.findAll();
    }

    public void removerPorId(Long id){
        CategoryRepository.deleteById(id);
    }
}
