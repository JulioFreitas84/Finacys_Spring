package trilha.back.testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import trilha.back.data.service.EntryService;

@RunWith(SpringRunner.class)
public class TrilhaBackTestes {

    @TestConfiguration
    static class entryServiceConfiguration{
    }

    @Autowired
    EntryService entryService;
    //Arrange -> tradução livre -> Entrada


    @Test
    public void entryTestService(){

    }


    //Act -> tradução livre -> Ação



    //Assert -> tradução livre -> Resultado
    
}
