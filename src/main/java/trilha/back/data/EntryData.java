package trilha.back.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.entity.Entry;

@Repository
public interface EntryData extends JpaRepository<Entry,Long> {
}
