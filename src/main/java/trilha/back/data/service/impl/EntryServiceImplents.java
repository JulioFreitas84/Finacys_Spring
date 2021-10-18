package trilha.back.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import trilha.back.presenter.controller.dtos.request.CriarEntryRequest;
import trilha.back.presenter.controller.dtos.response.CriarEntryResponse;
import trilha.back.domain.entity.Entry;
import trilha.back.data.service.repository.EntryRepository;
import trilha.back.data.service.EntryService;

import java.util.List;
import java.util.Optional;

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
    public List<Entry> listFilter(String lancamento, String amount, boolean paid){

        if (lancamento == null || amount == null){
            throw new RuntimeException("erro");
        }
        List<Entry> lancamentos = entryRepository.findByDateAndAmountAndPaid(lancamento, amount, paid);
        return lancamentos;
        // return ResponseEntity.ok(entryRepository.findAll());
    }

    @Override
    public Optional<Entry> amountCalculadosNaBase(String lancamento, String amount, boolean paid) {
        Optional<Entry> entryOptional = entryRepository.findByReverveName(lancamento, amount, paid);
        return entryOptional;
    }

}
