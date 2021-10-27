package trilha.back.testes;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import trilha.back.service.impl.EntryServiceImplents;
import trilha.back.service.repository.EntryRepository;
import trilha.back.entity.Category;
import trilha.back.entity.Entry;

import java.util.ArrayList;
import java.util.List;

@DisplayName("EntryServiceImplements")
@SpringBootTest
@AutoConfigureMockMvc
public class EntryServiceTest {

    @InjectMocks
    EntryServiceImplents service;

    @Mock
    private EntryRepository entryRepository;
    private Category category;

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
    @Test
    @DisplayName("")
    public  void buscarEntryPorIdTest(){
        //Preparação
        Entry entry = new Entry();
        Entry entryMoc = Mockito.mock(Entry.class);
        entry.setId(entryMoc.getId());

        //Ação
        Mockito.when(entryRepository.findById(1L)).thenReturn(java.util.Optional.of(entry));

        //Verificação
        Assert.assertNotNull(service.buscarEntryPorId(1L));
    }

    @Test
    public  void atualizarEntryTest(){
        //Preparação

        //Ação

        //Verificação
    }

    @Test
    public  void novoAtualizadoTest(){
        //Preparação

        //Ação

        //Verificação
    }

    @Test
    public  void removerEntryIdTest(){
        //Preparação

        //Ação

        //Verificação
    }

    @Test
    public void calculaMediaTest(){
        //Preparação

        //Ação

        //Verificação
    }

    @Test
    public void listFilterTest(){
        //Preparação

        //Ação

        //Verificação
    }

}
