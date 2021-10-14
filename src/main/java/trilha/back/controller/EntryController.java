package trilha.back.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.controller.dtos.request.CriarEntryRequest;
import trilha.back.entity.Entry;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> postEntry(@RequestBody CriarEntryRequest request) {
        return ResponseEntity.ok(entryService.salvarEntry(request));
    }

    //método dentro da controller de lançamentos para retornar a
    //lista criada com tratativa ResponseStatus
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Entry>> listEntry(Long id) {
        return ResponseEntity.ok(entryService.listEntry(id).getBody());
    }

    //tudo isso é um EndPoint
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Entry> buscarEntryPorId(@PathVariable Long id) {
        return ResponseEntity.ok(entryService.buscarEntryPorId(id)).getBody();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)                  //Receber um Entry
    public ResponseEntity<Entry> atualizarEntry(@PathVariable Long id, @RequestBody Entry entry) {
        return ResponseEntity.ok(entryService.buscarEntryPorId(id)).getBody();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEntryId(@PathVariable("id") Long id) {
        entryService.removerEntryId(id);
    }


    @GetMapping(value = "/{x}/{y}/calcular")
    public ResponseEntity<Integer> calculaMedia(@PathVariable Integer x, @PathVariable Integer y ){
        try {
            return ResponseEntity.ok(entryService.calculaMedia(x,y)).getBody();
        }catch (Exception e){
            e.getMessage();
        }
        return calculaMedia(x, y);
    }

    @GetMapping("/filter")
    public ResponseEntity<Entry> getEntryDependents(
            @RequestParam(value = "data_lançamento", required = false)String datalancamento,
            @RequestParam(value = "amount",required = false)String amount,
            @RequestParam(value = "paid",required = false)boolean paid
    ){
        return ResponseEntity.ok(entryService.getEntryDependents();
    }
}
