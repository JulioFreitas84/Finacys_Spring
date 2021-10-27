package trilha.back.data.service;

import org.springframework.http.ResponseEntity;
import trilha.back.presenter.controller.dtos.request.CriarEntryRequest;
import trilha.back.presenter.controller.dtos.response.CriarEntryResponse;
import trilha.back.domain.entity.Entry;

import java.util.List;
import java.util.Optional;

public interface EntryService {

    CriarEntryResponse salvarEntry(CriarEntryRequest entry);

    List<Entry> listEntry();

    Entry buscarEntryPorId(Long id);

    Object atualizarEntry(Long id, Entry entry);

    Optional<Entry> removerEntryId(Long id);

    Integer calculaMedia(Integer x, Integer y );

    Object listFilter(String lancamento, String amount, boolean paid);

}
