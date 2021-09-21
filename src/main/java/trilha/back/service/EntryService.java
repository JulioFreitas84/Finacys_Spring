package trilha.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.Category;
import trilha.back.entity.Entry;
import trilha.back.repository.CategoryRepository;
import trilha.back.repository.EntryRepository;
import trilha.back.service.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntryService {

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
                () -> new EntityNotFoundException("Id not found" + id));
    }

    public void removerPorId(Long id){
        entryRepository.deleteById(id);
    }
}
