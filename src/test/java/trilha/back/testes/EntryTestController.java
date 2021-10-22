package trilha.back.testes;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import trilha.back.data.service.EntryService;
import trilha.back.domain.entity.Category;
import trilha.back.domain.entity.Entry;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("EntryTestController")
public class EntryTestController extends TrilhaBackTestes {


    @Autowired
    MockMvc mockMvc;
    private Category Category;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
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
        Entry entrygetTest = new Entry();
        mockMvc.perform(get("/entry")
                .contentType("Application/Json")
                .content(objectMapper.writeValueAsString(entrygetTest)))
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Busca todos lançamentos por Id")
    public void entryTestListId() throws Exception {


    }

    @Test
    @DisplayName("Remove um lancamento")
    public void entryTestRemove() throws Exception {
        mockMvc.perform(delete("/entry/1"))
                .andExpect((ResultMatcher) content().string(containsString("1")))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Filtra lançamento Entry")
    public void FiltrarEntry() throws Exception {
        List<Entry> entryList = new ArrayList<>();
        Mockito.when(entryService.listFilter("data_lançamento", "amount", true)).thenReturn(entryList);
        mockMvc.perform(get("/entry/filter")
                        .param("data_lançamento", "data_lançamento")
                        .param("amount", "amount")
                        .param("paid", "true"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Filtra lançamento Erro Entry")
    public void filtrarEntryError() throws Exception {
        List<Entry> filtraEntryError = new ArrayList<>();
        mockMvc.perform(get("/entry/filter")
                        .param("data_lançamento", "data_lançamento")
                        .param("amount", "amount")
                        .param("paid","paid")
                        .content((byte[]) entryService.listFilter("data_lançamento","amount",true)))
                .andExpect(status().isNotFound());
    }
}



