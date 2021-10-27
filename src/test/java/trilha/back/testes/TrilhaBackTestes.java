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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import trilha.back.data.service.EntryService;
import trilha.back.data.service.repository.EntryRepository;
import trilha.back.domain.entity.Entry;
import trilha.back.presenter.controller.dtos.request.CriarEntryRequest;
import trilha.back.presenter.controller.dtos.response.CriarEntryResponse;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TrilhaBackTestes {

    @Autowired
    MockMvc mockMvc;

    private trilha.back.domain.entity.Category Category;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EntryRepository entryRepository;

    @MockBean
    EntryService entryService;


    @Test
    @DisplayName("Salvar entryservice")
    public void salvarEntryTest() throws Exception {
        String BOOK_API = "/entry";

        CriarEntryResponse criarEntryResponse = CriarEntryResponse.builder()
                .id(1L)
                .name("name_response")
                .description("description_response").build();
        Entry savedEntry = Entry.builder()
                .id(1L)
                .name("name_savedEntry")
                .description("description_savedEntry").build();

        BDDMockito.given(entryService.salvarEntry(Mockito.any(CriarEntryRequest.class))).willReturn(criarEntryResponse);
        String json = new ObjectMapper().writeValueAsString(criarEntryResponse);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(BOOK_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(request)
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("id").value(1L))
                .andExpect(jsonPath("name").value(criarEntryResponse.getName()))
                .andExpect(jsonPath("description").value(criarEntryResponse.getDescription()));

    }


}
