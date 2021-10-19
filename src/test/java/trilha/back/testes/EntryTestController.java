package trilha.back.testes;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import trilha.back.domain.entity.Category;
import trilha.back.domain.entity.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EntryTestController {

    @Mock
    List<String> mockedList;

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
      /*  ###################  @Mock Annotation  ######################  */
    @Test
    public  void entryTestList()throws Exception{
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());

        /*  ###################  @Mock Annotation  ######################  */
    }
      /* #####################  Anotação @InjectMocks  ################## */
    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("Uma Palavra")).thenReturn("Um significado");

        assertEquals("Um significado", dic.getMeaning("Uma Palavra"));


        /* #####################  Anotação @InjectMocks  ################## */
    }
}
