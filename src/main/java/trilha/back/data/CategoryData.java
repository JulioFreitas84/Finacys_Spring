package trilha.back.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.entity.Category;

@Repository
public interface CategoryData extends JpaRepository<Category, Long> {
    //O Repository acessa o banco de dados
}
