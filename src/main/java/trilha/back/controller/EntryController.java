package trilha.back.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.controller.dtos.request.CriarEntryRequest;
import trilha.back.controller.exceptions.ControllerExceptionHandler;
import trilha.back.entity.Entry;
import trilha.back.service.EntryService;

//Controlador Rest
@RestController
@RequestMapping("/entry")
public class EntryController extends ControllerExceptionHandler {

    @Autowired
    private EntryService entryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Object> postEntry(@RequestBody CriarEntryRequest request) {
        return ResponseEntity.ok(entryService.salvarEntry(request));
    }

    //método dentro da controller de lançamentos para retornar a
    //lista criada com tratativa ResponseStatus
    @GetMapping
    public ResponseEntity<Object> listEntry() {
        return ResponseEntity.ok(entryService.listEntry());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Entry> buscarEntryPorId(@PathVariable Long id) {
        return ResponseEntity.ok(entryService.buscarEntryPorId(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEntry(@PathVariable Long id, @RequestBody Entry entry) {
        return ResponseEntity.ok(entryService.atualizarEntry(id, entry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerEntryId(@PathVariable Long id) {
        entryService.removerEntryId(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "/{x}/{y}/calcular")
    public ResponseEntity<Integer> calculaMedia(@PathVariable Integer x, @PathVariable Integer y ){
        try {
            entryService.calculaMedia(x,y);
           // return ResponseEntity.ok(entryService.calculaMedia(x,y)).getBody();
        }catch (RuntimeException e){

            System.out.println("Meu errooooo" + e);
        }
        return ResponseEntity.ok(entryService.calculaMedia(x, y));

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
