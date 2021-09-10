package trilha.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
