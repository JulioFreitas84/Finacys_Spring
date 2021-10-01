package trilha.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.Category;
import trilha.back.entity.Entry;
import trilha.back.repository.CategoryRepository;
import trilha.back.repository.EntryRepository;

import java.util.List;
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
    public Optional<Entry> buscarPorId(Long id){
        return entryRepository.findById(id);
    }

    public void removerPorId(Long id){
        entryRepository.deleteAll();
    }

    public Integer calculaMedia(Integer x,Integer  y) {
        try {
            return (x / y);

        } catch (Exception error) {
            System.out.println("Divisão somente por numeros inteiros");
        }
      return null;
    }
}
