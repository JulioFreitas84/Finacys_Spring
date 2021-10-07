package trilha.back.service;

import org.springframework.http.ResponseEntity;
import trilha.back.dtos.request.CriarEntryRequest;
import trilha.back.dtos.response.CriarEntryResponse;
import trilha.back.entity.Entry;

import java.util.List;

public interface EntryService {

    CriarEntryResponse salvarEntry(CriarEntryRequest entry);

    ResponseEntity<List<Entry>> listEntry(Long id);

    ResponseEntity<Entry> buscarEntryPorId(Long id);

    Entry atualizarEntry(Long id, Entry entry);

    void removerEntryId(Long id);

    ResponseEntity<Integer> calculaMedia(Integer x, Integer y );




}
