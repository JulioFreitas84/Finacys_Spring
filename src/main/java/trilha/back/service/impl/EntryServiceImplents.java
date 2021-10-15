package trilha.back.service.impl;

import ch.qos.logback.classic.spi.IThrowableProxy;
import net.bytebuddy.pool.TypePool;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.controller.dtos.request.CriarEntryRequest;
import trilha.back.controller.dtos.response.CriarEntryResponse;
import trilha.back.entity.Entry;
import trilha.back.repository.EntryRepository;
import trilha.back.service.EntryService;

import java.util.List;
import java.util.stream.Collectors;

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
        return entryRepository.save(novoAtualizado(base, entry));

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
        return ResponseEntity.ok(x / y);
    }

    @Override
    public ResponseEntity<List<Entry>> listFilter(String datalacamento, String amount, boolean paid) {
        return ResponseEntity.ok(entryRepository.findAll());
    }
}
