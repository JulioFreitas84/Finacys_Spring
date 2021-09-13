package trilha.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
