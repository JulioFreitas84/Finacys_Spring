package trilha.back.data.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.domain.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    //O Repository acessa o banco de dados
}
