package trilha.back.testes;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableWebApplicationContext;
import trilha.back.data.service.impl.EntryServiceImplents;
import trilha.back.data.service.repository.EntryRepository;
import trilha.back.domain.entity.Entry;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class EntryServiceTest {

    @InjectMocks
    EntryServiceImplents service;

    @Mock
    private EntryRepository entryRepository;

    @Test
    public void listEntryTest(){
        //Preparação
        List<Entry> list = new ArrayList<>();
        Entry entry = Mockito.mock(Entry.class);
        list.add(entry);

        //Ação
        Mockito.when(entryRepository.findAll()).thenReturn(list);

        //Verificação
        Assert.assertNotNull(service.listEntry());
    }



}
