package trilha.back.data.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.domain.entity.Entry;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry,Long> {
    List<Entry> findByDateAndAmountAndPaid(String lancamento, String amount, boolean paid);
}
