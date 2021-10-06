package trilha.back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.Entry;
import trilha.back.repository.EntryRepository;
import trilha.back.service.exceptions.EntityNotFoundException;

import java.util.List;

@Service
public class EntryServiceImplents {

    @Autowired
    private EntryRepository entryRepository;

    public Entry salvar(Entry entry){
        return entryRepository.save(entry);
    }

    public List<Entry> listEntry(){
        return (List<Entry>) entryRepository.findAll();
    }
    public Entry buscarPorId(Long id){
        return entryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Minha msg Id não encontrado " + id));
    }

    public void removerPorId(Long id){
        entryRepository.deleteById(id);
    }

    public Integer calculaMedia(Integer x,Integer  y) {
        return (x / y);
    }
}
