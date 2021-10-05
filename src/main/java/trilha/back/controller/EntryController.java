package trilha.back.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.dto.EntryApplicationServerDto;
import trilha.back.entity.EntryModel;

import trilha.back.service.EntryService;

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

    @GetMapping(value = "/{x}/{y}/calcular")
    public ResponseEntity<Integer> calculaMedia(@PathVariable Integer x, @PathVariable Integer y ){

     try {
         return ResponseEntity.ok(entryService.calculaMedia(x,y));
     }catch (Exception e){
         e.getMessage();
     }
     return calculaMedia(x, y);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntryModel salvar(@RequestBody EntryModel entry) {
        return entryService.salvar(entry);
    }

    //método dentro da controller de lançamentos para retornar a
    //lista criada com tratativa ResponseStatus
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EntryApplicationServerDto> listEntry(Long id) {
        List<EntryModel> entries = entryService.listEntry();
        return EntryApplicationServerDto.convert(entries);
    }

    //tudo isso é um EndPoint
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EntryModel> buscarEntryPorId(@PathVariable("id") Long id) {
        EntryModel entry = entryService.buscarPorId(id);
        return ResponseEntity.ok().body(entry);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEntryId(@PathVariable("id") Long id) {
        entryService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)                  //Receber um Entry
    public void atualizarEntry(@PathVariable("id") Long id, @RequestBody EntryModel entry) {
        entryService.buscarPorId(id);
    }
}
