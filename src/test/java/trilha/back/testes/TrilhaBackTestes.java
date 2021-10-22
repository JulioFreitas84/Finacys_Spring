package trilha.back.testes;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import trilha.back.data.service.EntryService;
import trilha.back.domain.entity.Entry;
import trilha.back.presenter.controller.EntryController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TrilhaBackTestes {

    //Vai testar a classe
    @InjectMocks
    public EntryController controller;

    //Vai simular uma classe minha
    @Mock
    public EntryService entryService;

    @Test
    public void filtrarEntry() throws Exception {
        List<Entry> entryList = new ArrayList<>();
        Mockito.when(entryService.listFilter("data_lançamento", "amount", true)).thenReturn(entryList);
        ResponseEntity<Object> retorno = controller.getEntryDependents("data_lançamento", "amount", true);
        Assert.assertEquals(retorno.getStatusCodeValue(),200);
    }


}
