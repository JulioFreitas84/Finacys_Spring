package trilha.back.testes;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.compiler.ast.InstanceOfExpr;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import trilha.back.data.service.EntryService;
import trilha.back.data.service.repository.EntryRepository;
import trilha.back.domain.entity.Category;
import trilha.back.domain.entity.Entry;
import trilha.back.presenter.controller.EntryController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.ID;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("EntryTestController")
public class EntryTestController extends TrilhaBackTestes {

    @MockBean
    private EntryRepository entryRepository;

    @Autowired
    MockMvc mockMvc;
    private Category Category;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    EntryService entryService;

    //Teste executado com sucesso
    @Test
    @DisplayName("Salva um lançamento")
    public void entryTestSave() throws Exception {
        Entry entryTestPostSave = new Entry(1L, "Julio", "Description"
                , "type", "200", "19/10/2021", true, true, Category);
        mockMvc.perform(post("/entry")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entryTestPostSave)))
                .andExpect(status().isOk());
    }

    //Teste executado com sucesso
    @Test
    @DisplayName("Busca todos lançamentos")
    public void entryTestList() throws Exception {
        List entries = entryRepository.findAll();
        mockMvc.perform(get("/entry")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entries)))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Busca todos lançamentos por Id")
    public void entryTestListId() throws Exception {
        List entries = entryRepository.findAll();
        mockMvc.perform(get("/entry/{id}", 1L)
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entries)))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Remove um lancamento")
    public void entryTestRemove() throws Exception {

    }

    @Test
    @DisplayName("Filtra lançamento Entry")
    public void FiltrarEntry() throws Exception {
        List entriesFilter = entryRepository.findAll();
        mockMvc.perform(get("/filter", "data_lançamento" + "amount", true)
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entriesFilter)))
                .andExpect(status().isOk());

    }
}
