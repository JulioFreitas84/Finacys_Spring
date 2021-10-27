package trilha.back.testes;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import trilha.back.service.EntryService;
import trilha.back.entity.Category;
import trilha.back.entity.Entry;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("EntryControllerTest")
@SpringBootTest
@AutoConfigureMockMvc
public class EntryControllerTest {

    @Autowired
    MockMvc mockMvc;

    private Category category;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    EntryService entryService;


    //Teste executado com sucesso
    @Test
    @DisplayName("Deve salvar uma Entry")
    public void entrySaveTest() throws Exception {
        Entry entryTestPostSave = new Entry(1L, "Julio", "Description"
                , "type", "200", "19/10/2021", true, true, category);
        mockMvc.perform(post("/entry")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entryTestPostSave)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deve buscar toda Entry")
    public void entryBuscarTodosTest() throws Exception {
        Mockito.when(entryService.removerEntryId(1L)).thenReturn(null);
        mockMvc.perform(get("/entry/1")
                        .contentType("Application/Json"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deve buscar Entry por id")
    public void entryTestListId() throws Exception {
        Entry entrygetPorId = new Entry();
        Mockito.when(entryService.buscarEntryPorId(1L)).thenReturn(entrygetPorId);
        mockMvc.perform(get("/entry/1")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entrygetPorId)))
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Deve remover Entry  por id")
    public void entryRemoveTest() throws Exception {
        Entry entryRemoveTest = new Entry();
        Mockito.when(entryService.removerEntryId(1L)).thenReturn(null);
        mockMvc.perform(delete("/entry/1")
                        .contentType("Application/Json")
                        .content(objectMapper.writeValueAsString(entryRemoveTest)))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Deve atualizar Entry")
    public void atualizaLancamentoTest() throws Exception {
        Entry atualizaEntryTest = new Entry(1L, "Julio Freitas", "Description"
                , "type", "400", "19/10/2021", false, true, category);
        Mockito.when(entryService.atualizarEntry(1L,atualizaEntryTest)).thenReturn(atualizaEntryTest);
        mockMvc.perform(put("/entry/1")
                .contentType("Application/Json")
                .content(objectMapper.writeValueAsString(atualizaEntryTest)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Metodo Calcular")
    public void calculaMetodoTest() throws Exception {
        //Preparação


        //Ação
        Integer x = null;
        Integer y = null;
        Mockito.when(entryService.calculaMedia( x,  y)).thenReturn(null);

        //Verificação
        Assert.assertNotNull(entryService.calculaMedia(10,5));
    }

    @Test
    @DisplayName("Deve filtrar três atributos da Entry")
    public void filtrarEntry() throws Exception {
        mockMvc.perform(get("/entry/filter")
                        .param("data_lançamento", "data_lançamento")
                        .param("amount", "amount")
                        .param("paid", "true"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deve dar Erro ao filtrar três atributos da Entry ")
    public void filtrarEntryError() throws Exception {
        Mockito.when(entryService.listFilter("null", "null", false)).thenThrow(RuntimeException.class);
        mockMvc.perform(get("/entry/filter")
                        .param("data_lançamento", "null")
                        .param("amount", "null")
                        .param("paid", "false"))
                .andExpect(status().isNoContent());
    }
}



