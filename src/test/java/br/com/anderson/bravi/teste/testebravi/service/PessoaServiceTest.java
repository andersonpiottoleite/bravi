package br.com.anderson.bravi.teste.testebravi.service;

import br.com.anderson.bravi.teste.testebravi.dto.ContatoSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaSaveDTO;
import br.com.anderson.bravi.teste.testebravi.exceptions.PessoaNotFoundException;
import br.com.anderson.bravi.teste.testebravi.model.Pessoa;
import br.com.anderson.bravi.teste.testebravi.model.TipoContato;
import br.com.anderson.bravi.teste.testebravi.repository.PessoaRepository;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

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
