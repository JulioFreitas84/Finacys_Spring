package trilha.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.Entry;
import trilha.back.repository.EntryRepository;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public Entry salvar(Entry entry){
        return entryRepository.save(entry);
    }

    public List<Entry> listEntry(){
        return entryRepository.findAll();
    }

    public void removerPorId(Long id){
        entryRepository.deleteById(id);
    }
}
