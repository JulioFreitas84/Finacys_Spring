package trilha.back.testes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import trilha.back.data.service.EntryService;

@RunWith(SpringRunner.class)
public class TrilhaBackTestes {
    //Arrange -> tradução livre -> Entrada

    @TestConfiguration
    static class EntryServiceTestConfiguration{
        @Bean
        public EntryService entryService(){
            return entryService();
        }
    }

    @Autowired
    EntryService entryService;

    @Test
    public void entryServiceCalculator(){
        String amount = "Julio";
        String lancamento = "18/10/2021";
        boolean paid = true;
        int name = entryService.amountCalculadosNaBase(lancamento,amount, paid = true);

        Assertions.assertEquals(amount, 200);
    }



    //Act -> tradução livre -> Ação

    //Assert -> tradução livre -> Resultado
    
}
