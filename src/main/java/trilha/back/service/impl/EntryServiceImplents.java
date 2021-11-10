package trilha.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.controller.dtos.request.CriarEntryRequest;
import trilha.back.controller.dtos.response.CriarCategoriaResponse;
import trilha.back.entity.Entry;
import trilha.back.mapper.EntryMapper;
import trilha.back.service.repository.EntryRepository;
import trilha.back.service.EntryService;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImplents implements EntryService {

    @Autowired
    private EntryRepository entryRepository;
    
    @Autowired
    EntryMapper entryMapper;

    @Override
    public CriarCategoriaResponse salvarEntry(CriarEntryRequest entry) {
        Entry model =  new Entry();
        model.setName(entry.getName());
        model.setDescription(entry.getDescription());
        model.setType(entry.getType());
        model.setAmount(entry.getAmount());
        model.setDate(entry.getDate());
        model.setPaid(entry.isPaid());
        model.setPendent(entry.isPendent());
        model.setCategoryId(entry.getCategory());

        return entryMapper.modelToResponse(entryRepository.save(model));
    }


    @Override
    public List<Entry> listEntry() {
        return entryRepository.findAll();
    }

    @Override
    public Entry buscarEntryPorId(Long id) {
        return entryRepository.findById(id).orElseThrow();
    }

    @Override
    public Entry atualizarEntry(Long id, Entry entry) {
        Entry base = entryRepository.findById(id).orElseThrow();
        return entryRepository.save(novoAtualizado(base, entry));

    }

    public Entry novoAtualizado(Entry base, Entry entry) {
        base.setName(entry.getName());
        return base;
    }

    @Override
    public Optional<Entry> removerEntryId(Long id) {
        entryRepository.deleteById(id);
        return null;
    }

    @Override
    public Integer calculaMedia(Integer x, Integer y) {
        return (x / y);
    }

    @Override
    public List<Entry> listFilter(String lancamento, String amount, boolean paid){

        if (lancamento == null || amount == null){
            throw new RuntimeException("erro que eu coloquei");
        }
        List<Entry> lancamentos = entryRepository.findByDateAndAmountAndPaid(lancamento, amount, paid);
        return lancamentos;
    }

}
