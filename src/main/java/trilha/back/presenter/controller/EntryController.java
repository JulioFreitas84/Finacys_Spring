package trilha.back.presenter.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.presenter.controller.dtos.request.CriarEntryRequest;
import trilha.back.domain.entity.Entry;
import trilha.back.data.service.EntryService;

import javax.persistence.EntityNotFoundException;
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
            calculaMedia(x, y);
           // return ResponseEntity.ok(entryService.calculaMedia(x,y)).getBody();
        }catch (EntityNotFoundException e){

            System.out.println("Meu errooooo" + e);
        }
        return ResponseEntity.ok(entryService.calculaMedia(x, y).getBody());

    }

    @GetMapping("/filter")
    public ResponseEntity<Object> getEntryDependents(
            @RequestParam(value = "data_lançamento", required = false) String datalancamento,
            @RequestParam(value = "amount", required = false) String amount,
            @RequestParam(value = "paid", required = false) boolean paid
    ){
       try {
           return  ResponseEntity.ok(entryService.listFilter(datalancamento, amount, paid));
       } catch (Exception e){
           return ResponseEntity.noContent().build();
        }
    }
}
