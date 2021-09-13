package trilha.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import trilha.back.entity.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry,Long> {
}
