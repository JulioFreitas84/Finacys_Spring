package trilha.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.controller.dtos.request.CriarEntryRequest;
import trilha.back.controller.dtos.response.CriarEntryResponse;
import trilha.back.controller.dtos.response.CriarResponseEntryFilter;
import trilha.back.entity.Entry;
import trilha.back.repository.EntryRepository;
import trilha.back.service.EntryService;

import java.util.List;

@Service
public class EntryServiceImplents implements EntryService {

    @Autowired
    private EntryRepository entryRepository;

    @Override
    public CriarEntryResponse salvarEntry(CriarEntryRequest entry) {
        Entry model = new Entry();
        model.setName(model.getName());
        model.setDescription(model.getDescription());
        return new CriarEntryResponse(model.getName(), model.getDescription());
    }

    @Override
    public ResponseEntity<List<Entry>> listEntry(Long id) {
        return ResponseEntity.ok(entryRepository.findAll());
    }

    @Override
    public ResponseEntity<Entry> buscarEntryPorId(Long id) {
        return ResponseEntity.ok(entryRepository.findById(id).orElseThrow());
    }

    @Override
    public Entry atualizarEntry(Long id, Entry entry) {
        Entry base = entryRepository.findById(id).orElseThrow();
        return entryRepository.save(novoAtualizado(base,entry));

    }

    private Entry novoAtualizado(Entry base, Entry entry) {
        base.setName(base.getName());
        return base;
    }

    @Override
    public void removerEntryId(Long id) {
        entryRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Integer> calculaMedia(Integer x, Integer y) {
        return null;
    }

    @Override
    public CriarResponseEntryFilter getEntryDependents(String datalancamento, String amount, boolean paid) {
        Entry entrygetDependets = new Entry();
        entrygetDependets.setDate(entrygetDependets.getDate());
        entrygetDependets.setAmount(entrygetDependets.getAmount());
        entrygetDependets.setPaid(entrygetDependets.getPaid());
        return new CriarResponseEntryFilter(entrygetDependets.getDate(),
                entrygetDependets.getAmount(),entrygetDependets.getPaid().isEmpty());
    }


}
