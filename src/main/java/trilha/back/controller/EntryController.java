package trilha.back.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import trilha.back.entity.Category;
import trilha.back.entity.Entry;
import trilha.back.service.EntryService;

import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    //injeção
    @Autowired
    private EntryService entryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry salvar(@RequestBody Entry entry) {
        return entryService.salvar(entry);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> listEntry() {
        return entryService.listEntry();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCategoryId(@PathVariable("id") Long id) {
        entryService.removerPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        entryService.listEntry();
    }
}
