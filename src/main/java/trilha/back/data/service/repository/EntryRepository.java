package trilha.back.data.service.repository;

import org.hibernate.type.StringNVarcharType;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.data.service.EntryService;
import trilha.back.domain.entity.Entry;

import javax.persistence.metamodel.SingularAttribute;
import javax.swing.text.html.Option;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry,Long> {
    List<Entry> findByDateAndAmountAndPaid(String lancamento, String amount, boolean paid);




}
