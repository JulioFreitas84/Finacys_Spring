package trilha.back.data;

import org.springframework.http.ResponseEntity;
import trilha.back.presenter.dtos.request.CriarEntryRequest;
import trilha.back.presenter.dtos.response.CriarEntryResponse;
import trilha.back.domain.Entry;

import java.util.List;

public interface EntryService {

    CriarEntryResponse salvarEntry(CriarEntryRequest entry);

    ResponseEntity<List<Entry>> listEntry(Long id);

    ResponseEntity<Entry> buscarEntryPorId(Long id);

    Entry atualizarEntry(Long id, Entry entry);

    void removerEntryId(Long id);

    ResponseEntity<Integer> calculaMedia(Integer x, Integer y );


    List<Entry> listFilter(String lancamento, String amount, boolean paid);

}
