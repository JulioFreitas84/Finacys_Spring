package trilha.back.testes;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import trilha.back.data.service.EntryService;
import trilha.back.data.service.repository.EntryRepository;
import trilha.back.domain.entity.Entry;
import trilha.back.presenter.controller.dtos.request.CriarEntryRequest;
import trilha.back.presenter.controller.dtos.response.CriarEntryResponse;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class TrilhaBackTestes {

    //Arrange -> tradução livre -> Entrada

    @TestConfiguration
    class EntryServiceTestConfiguration{


        @Bean
        public EntryService entryService(){
            return new EntryService() {
                @Override
                public CriarEntryResponse salvarEntry(CriarEntryRequest entry) {
                    Entry model = new Entry();
                    model.setName(model.getName());
                    model.setDescription(model.getDescription());
                    return new CriarEntryResponse(model.getName(), model.getDescription());
                }

                @Override
                public ResponseEntity<List<Entry>> listEntry(Long id) {
                    return ResponseEntity.ok(entryRepository.findAll());
                }

                @Override
                public ResponseEntity<Entry> buscarEntryPorId(Long id) {
                    return ResponseEntity.ok(entryRepository.findById(id).orElseThrow());
                }

                @Override
                public Entry atualizarEntry(Long id, Entry entry) {
                    Entry base = entryRepository.findById(id).orElseThrow();
                    return entryRepository.save(novoAtualizado(base, entry));
                }
                private Entry novoAtualizado(Entry base, Entry entry) {
                    base.setName(base.getName());
                    return base;
                }

                @Override
                public void removerEntryId(Long id) {
                    entryRepository.deleteById(id);
                }

                @Override
                public ResponseEntity<Integer> calculaMedia(Integer x, Integer y) {
                    return ResponseEntity.ok(x / y);
                }

                @Override
                public List<Entry> listFilter(String lancamento, String amount, boolean paid) {
                    if (lancamento == null || amount == null){
                        throw new RuntimeException("erro");
                    }
                    List<Entry> lancamentos = entryRepository.findByDateAndAmountAndPaid(lancamento, amount, paid);
                    return lancamentos;
                }

                @Override
                public Optional<Entry> amountCalculadosNaBase(String lancamento, String amount, boolean paid) {
                    Optional<Entry> entryOptional = entryRepository.findByReverveName(lancamento, amount, paid);
                    return entryOptional;
                }
            };
        }
    }

    @Autowired
    EntryService entryService;

    @MockBean
    EntryRepository entryRepository;

    @Test
    public void entryServiceCalculator(){
        String amount = "Julio";
        String lancamento = "18/10/2021";
        boolean paid = true;
        Optional<Entry> name = entryService.amountCalculadosNaBase(lancamento,amount, paid = true);

        Assertions.assertEquals(amount, 200);
    }

    //Act -> tradução livre -> Ação

    @Before
    public void setup(){
        Entry entryTest = new Entry("1","",true);
        Mockito.when(entryRepository.findByReverveName(entryTest.getDate()
                ,entryTest.getAmount(),entryTest.getPaid()))
                .thenReturn(java.util.Optional.of(entryTest));


    }

    //Assert -> tradução livre -> Resultado
    
}
