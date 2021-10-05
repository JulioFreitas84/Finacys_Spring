package trilha.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trilha.back.entity.EntryModel;
import trilha.back.repository.EntryRepository;
import trilha.back.service.exceptions.EntityNotFoundException;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public EntryModel salvar(EntryModel entry){
        return entryRepository.save(entry);
    }

    public List<EntryModel> listEntry(){
        return (List<EntryModel>) entryRepository.findAll();
    }
    public EntryModel buscarPorId(Long id){
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
