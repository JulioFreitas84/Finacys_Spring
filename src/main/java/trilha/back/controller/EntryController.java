package trilha.back.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.controller.exceptions.StandardError;
import trilha.back.dto.EntryDto;
import trilha.back.entity.Entry;
import trilha.back.service.exceptions.EntityNotFoundException;
import trilha.back.service.EntryService;

import java.time.Instant;
import java.util.List;

//Controlador Rest
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

    //método dentro da controller de lançamentos para retornar a
    //lista criada com tratativa ResponseStatus
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EntryDto> listEntry(Long id) {
        List<Entry> entries = entryService.listEntry();
        return EntryDto.convert(entries);
    }

    //tudo isso é um EndPoint
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Entry> buscarEntryPorId(@PathVariable("id") Long id) {
        Entry entry = entryService.buscarPorId(id);
        return ResponseEntity.ok().body(entry);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEntryId(@PathVariable("id") Long id) {
        entryService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)                  //Receber um Entry
    public void atualizarEntry(@PathVariable("id") Long id, @RequestBody Entry entry) {
        entryService.buscarPorId(id);
    }
}
