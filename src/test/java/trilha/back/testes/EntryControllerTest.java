package trilha.back.testes;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import trilha.back.data.service.EntryService;
import trilha.back.domain.entity.Category;
import trilha.back.domain.entity.Entry;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("EntryTestController")
@SpringBootTest
@AutoConfigureMockMvc
public class EntryControllerTest {

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

    @Test
    @DisplayName("Busca todos lancamento Novo")
    public void entryTestBuscaTodos() throws Exception {
        Mockito.when(entryService.removerEntryId(1L)).thenReturn(null);
        mockMvc.perform(get("/entry/1")
                        .contentType("Application/Json"))
                .andExpect(status().isOk());
    }

    //Teste executado com sucesso
    @Test
    @DisplayName("Busca todos lançamentos")
    public void entryTestList() throws Exception {
        List<Entry> entrygetTest = new ArrayList<>();
        this.mockMvc.perform(get("/entry")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entrygetTest)))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("Busca lançamentos por Id")
    public void entryTestListId() throws Exception {
        Entry entrygetPorId = new Entry();
        Mockito.when(entryService.buscarEntryPorId(1L)).thenReturn(entrygetPorId);
        mockMvc.perform(get("/entry/1")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entrygetPorId)))
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Remove um lancamento")
    public void entryTestRemove() throws Exception {
        Entry entrygetTest = new Entry();
        Mockito.when(entryService.removerEntryId(1L)).thenReturn(null);
        mockMvc.perform(delete("/entry/1")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entrygetTest)))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Atualiza Lançamento")
    public void atualizaLancamentoTest() throws Exception {
        Entry atualizaEntryTest = new Entry(1L, "Julio Freitas", "Description"
                , "type", "400", "19/10/2021", false, true, Category);
        Mockito.when(entryService.atualizarEntry(1L,atualizaEntryTest)).thenReturn(atualizaEntryTest);
        mockMvc.perform(put("/entry/1")
                .contentType("Application/Json")
                .content(objectMapper.writeValueAsString(atualizaEntryTest)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Metodo Calcular")
    public void calculaMetodoEntry() throws Exception {
        Integer y = null;
        Integer x = null;
        Mockito.when(entryService.calculaMedia(x, y)).thenReturn(x, y);
        mockMvc.perform(get("/{x}/{y}/calcular")
                .content("Application/Json"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Filtra Lançamento")
    public void filtrarEntry() throws Exception {
        mockMvc.perform(get("/entry/filter")
                        .param("data_lançamento", "data_lançamento")
                        .param("amount", "amount")
                        .param("paid", "true"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Filtra lançamento Erro ")
    public void filtrarEntryError() throws Exception {
        Mockito.when(entryService.listFilter("null", "null", false)).thenThrow(RuntimeException.class);
        mockMvc.perform(get("/entry/filter")
                        .param("data_lançamento", "null")
                        .param("amount", "null")
                        .param("paid", "false"))
                .andExpect(status().isNoContent());
    }
}



