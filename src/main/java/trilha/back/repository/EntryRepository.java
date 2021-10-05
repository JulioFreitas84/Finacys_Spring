package trilha.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.entity.EntryModel;

@Repository
public interface EntryRepository extends JpaRepository<EntryModel,Long> {
}
