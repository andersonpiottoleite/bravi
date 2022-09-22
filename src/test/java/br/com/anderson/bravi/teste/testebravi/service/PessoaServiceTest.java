package br.com.anderson.bravi.teste.testebravi.service;

import br.com.anderson.bravi.teste.testebravi.exceptions.PessoaNotFoundException;
import br.com.anderson.bravi.teste.testebravi.repository.PessoaRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class PessoaServiceTest {
    private PessoaService pessoaService;

    @Before
    public void antesDeCadaTeste(){
        PessoaRepository pessoaRepositoryMock = Mockito.mock(PessoaRepository.class);
        pessoaService = new PessoaService(pessoaRepositoryMock);
    }

    @Test(expected = PessoaNotFoundException.class)
    public void deveLancarUmaExcecaoCasoNaoEncontreAPessoaPeloId(){
        pessoaService.findById(1L);
    }


    @Test(expected = PessoaNotFoundException.class)
    public void deveLancarUmaExcecaoCasoNaoEncontrePessoasCadastradas(){
        pessoaService.findAll();
    }
}
