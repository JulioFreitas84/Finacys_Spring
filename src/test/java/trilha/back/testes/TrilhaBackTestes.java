package trilha.back.testes;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import trilha.back.data.service.EntryService;
import trilha.back.data.service.impl.EntryServiceImplents;

@RunWith(SpringRunner.class)
public class TrilhaBackTestes {

    @TestConfiguration
    static class entryServiceConfiguration{
        @Bean
        public EntryService entryService(){
            return new EntryServiceImplents();
        }
    }

    @Autowired
    EntryService entryService;
    //Arrange -> tradução livre -> Entrada


    @Test
    public void entryTestService(){
        String name = "julio";
        int day = entryService.dayCalculatorDataBase(name);

        Assertions.assertEquals(day, 10);
    }


    //Act -> tradução livre -> Ação



    //Assert -> tradução livre -> Resultado
    
}
