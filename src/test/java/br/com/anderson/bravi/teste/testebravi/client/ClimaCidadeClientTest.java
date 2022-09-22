package br.com.anderson.bravi.teste.testebravi.client;

import br.com.anderson.bravi.teste.testebravi.client.ClimaCidadeClient;
import br.com.anderson.bravi.teste.testebravi.vo.ClimaCidadeVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@ActiveProfiles("test")
public class ClimaCidadeClientTest {

    private ClimaCidadeClient climaCidadeClient;
    private RestTemplate restTemplate;

    @Before
    public void antesDeCasaTeste(){
        restTemplate = new RestTemplate();
        climaCidadeClient = new ClimaCidadeClient(restTemplate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExceptionSeCidadeNaoForInformada(){
        climaCidadeClient.getClimaPorCidade("");
    }

    @Test
    public void devePreencherCidadeAdequadamenteNoRetornoDaRequisicao(){
        String cidade = "osasco";
        ClimaCidadeVO clima = climaCidadeClient.getClimaPorCidade(cidade);

        Assert.assertNotNull(clima);
        Assert.assertEquals(clima.getName().toLowerCase(), cidade);

    }
}
