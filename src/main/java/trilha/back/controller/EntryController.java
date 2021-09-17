package trilha.back.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import trilha.back.dto.EntryDto;
import trilha.back.entity.Entry;
import trilha.back.service.EntryService;

import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    //injetar
    @Autowired
    private EntryService entryService;

    //Injetar
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry salvar(@RequestBody Entry entry) {
        return entryService.salvar(entry);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EntryDto> listEntry() {
        List<Entry> entries = entryService.listEntry();
        return EntryDto.convert(entries);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Entry buscarEntryPorId(@PathVariable("id") Long id){
        return entryService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entry não encontrado"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEntryId(@PathVariable("id") Long id) {
        entryService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)                  //Receber um Entry
    public void atualizarEntry(@PathVariable("id") Long id, @RequestBody Entry entry) {
        entryService.buscarPorId(id)
                .map(entryBase -> {
                    modelMapper.map(entry, entryBase);
                    entryService.salvar(entryBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category naõ encontrado"));
    }
}
