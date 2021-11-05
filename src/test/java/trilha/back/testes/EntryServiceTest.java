package trilha.back.testes;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import trilha.back.controller.dtos.request.CriarEntryRequest;
import trilha.back.controller.dtos.response.CriarEntryResponse;
import trilha.back.service.impl.EntryServiceImplents;
import trilha.back.service.repository.EntryRepository;
import trilha.back.entity.Category;
import trilha.back.entity.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @DisplayName("Salvar Entry Service")
    public void salvarEntryTest(){
        //Preparação;
        Entry entry = new Entry();
        Entry entry1 = Mockito.mock(Entry.class);

        //Ação
        Mockito.when(entryRepository.save(entry1)).thenReturn(entry);

        //Verificação
        Assert.assertNotNull(service.salvarEntry(new CriarEntryRequest(entry1.getId(), entry1.getName(), entry1.getDescription())));
    }

    @Test
    @DisplayName("Listar Entry Service")
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
    @DisplayName("Buscar Entry Service Por Id")
    public  void buscarEntryPorIdTest(){
        //Preparação
        Entry entry = Mockito.mock(Entry.class);

        //Ação
        Mockito.when(entryRepository.findById(1L)).thenReturn(java.util.Optional.of(entry));

        //Verificação
        Assert.assertNotNull(service.buscarEntryPorId(1L));
    }

    @Test
    @DisplayName("Atualizar Entry Service")
    public  void atualizarEntryTest(){
        //Preparação
        Entry entry = Mockito.mock(Entry.class);

        //Ação
        Mockito.when(entryRepository.findById(1L)).thenReturn(java.util.Optional.of(entry));

        //Verificação
        Assert.assertNull(service.atualizarEntry(1L,entry));
    }

    @Test
    @DisplayName("Remover Entry Service")
    public  void removerEntryIdTest(){
        //Preparação
        Entry entry = Mockito.mock(Entry.class);

        //Ação
        Mockito.when(entryRepository.findById(1L)).thenReturn(java.util.Optional.of(entry));

        //Verificação
        Assert.assertNull(service.removerEntryId(1L));
    }

    @Test
    @DisplayName("Calcular Media")
    public void calculaMediaTest(){
        //Preparação
        Entry entry = new Entry();
        Entry entry1 = Mockito.mock(Entry.class);

        //Ação

        //Verificação
        Assert.assertNotNull(service.calculaMedia(10, 5));
    }

    @Test
    @DisplayName("Filtrar Entry Service")
    public void listFilterTest(){
        //Preparação
        List<Entry> list = new ArrayList<>();
        Entry entry = Mockito.mock(Entry.class);
        list.add(entry);

        //Ação
        Mockito.when(entryRepository.findByDateAndAmountAndPaid("lançamento","amount",true)).thenReturn(list);

        //Verificação
        Assert.assertNotNull(service.listFilter("lançamento","amount",true));
    }

    @Test
    @DisplayName("Erro ao Filtrar Entry Service")
    public void listFilterErroTest(){
        //Preparação
        List<Entry> list = new ArrayList<>();
        Entry entry = Mockito.mock(Entry.class);
        list.add(entry);

        //Ação
        Mockito.when(entryRepository.findByDateAndAmountAndPaid("lançamento","amount",true)).thenReturn(list);

        //Verificação
        Assert.assertThrows(RuntimeException.class,
                ()->{
                    service.listFilter(null,null,false);
                });
    }

}
