package trilha.back.testes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import trilha.back.service.EntryService;
import trilha.back.service.repository.EntryRepository;


@SpringBootTest
@AutoConfigureMockMvc
public class TrilhaBackTestes {

    @Autowired
    MockMvc mockMvc;

    private trilha.back.entity.Category Category;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EntryRepository entryRepository;

    @MockBean
    EntryService entryService;


    @Test
    @DisplayName("Salvar entryservice")
    public void salvarEntryTest() throws Exception {
    }
}
