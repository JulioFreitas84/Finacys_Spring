package trilha.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.entity.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    //O Repository acessa o banco de dados
}
