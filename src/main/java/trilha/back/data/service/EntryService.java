package trilha.back.data.service;

import org.springframework.http.ResponseEntity;
import trilha.back.presenter.controller.dtos.request.CriarEntryRequest;
import trilha.back.presenter.controller.dtos.response.CriarEntryResponse;
import trilha.back.domain.entity.Entry;

import java.util.List;
import java.util.Optional;

public interface EntryService {

    CriarEntryResponse salvarEntry(CriarEntryRequest entry);

    ResponseEntity<List<Entry>> listEntry(Long id);

    ResponseEntity<Entry> buscarEntryPorId(Long id);

    Entry atualizarEntry(Long id, Entry entry);

    void removerEntryId(Long id);

    ResponseEntity<Integer> calculaMedia(Integer x, Integer y );

    List<Entry> listFilter(String lancamento, String amount, boolean paid);

    /*   ######################### Metodo de teste Unitario ###########################   */



    /*   ######################### Metodo de teste Unitario ###########################   */

}
