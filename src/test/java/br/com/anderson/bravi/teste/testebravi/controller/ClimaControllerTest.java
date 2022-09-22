package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.client.ClimaCidadeClient;
import br.com.anderson.bravi.teste.testebravi.vo.ClimaCidadeVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@ActiveProfiles("test")
public class ClimaControllerTest {

    private ClimaCidadeClient climaCidadeClient;
    private ClimaController climaController;
    private RestTemplate restTemplate;

    @Before
    public void antesDeCasaTeste(){
        restTemplate = new RestTemplate();
        climaCidadeClient = new ClimaCidadeClient(restTemplate);
        climaController = new ClimaController(climaCidadeClient);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarBadRequestSeCidadeNaoForInformada(){
        climaController.getClimaPorCidade("");
    }

    @Test
    public void devePreencherCidadeAdequadamenteNoRetornoDaRequisicao(){
        String cidade = "osasco";
        ResponseEntity<ClimaCidadeVO> climaResponse = climaController.getClimaPorCidade(cidade);

        if(HttpStatus.OK.equals(climaResponse.getStatusCode())){
            Assert.assertNotNull(climaResponse.getBody());
            Assert.assertEquals(climaResponse.getBody().getName().toLowerCase(), cidade);
        } else {
            Assert.fail();
        }
    }
}
