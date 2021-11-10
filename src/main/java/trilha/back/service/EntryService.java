package trilha.back.service;

import trilha.back.controller.dtos.request.CriarEntryRequest;
import trilha.back.controller.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Entry;

import java.util.List;
import java.util.Optional;

public interface EntryService {

    CriarCategoriaResponse salvarEntry(CriarEntryRequest entry);

    List<Entry> listEntry();

    Entry buscarEntryPorId(Long id);

    Entry atualizarEntry(Long id, Entry entry);

    Optional<Entry> removerEntryId(Long id);

    Integer calculaMedia(Integer x, Integer y );

    Object listFilter(String lancamento, String amount, boolean paid);

}
