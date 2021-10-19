package trilha.back.testes;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import trilha.back.domain.entity.Category;
import trilha.back.domain.entity.Entry;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EntryTestController {

    @Autowired
    MockMvc mockMvc;
    private Category Category;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void entryTestSave()throws Exception{
        Entry entryTestPostSave = new Entry(1L,"Julio","Description"
                ,"type","200","19/10/2021",true,true, Category);
        mockMvc.perform(post("/entry")
                .contentType("Application/Json")
                .content(objectMapper.writeValueAsString(entryTestPostSave)))
                .andExpect(status().isOk());
    }
}
