package br.com.anderson.bravi.teste.testebravi.converters;

import br.com.anderson.bravi.teste.testebravi.dto.ContatoSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.ContatoUpdateDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaUpdateDTO;
import br.com.anderson.bravi.teste.testebravi.model.Contato;
import br.com.anderson.bravi.teste.testebravi.model.Pessoa;
import br.com.anderson.bravi.teste.testebravi.model.TipoContato;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("test")
public class PessoaConverterTest {

    @Test
    public void deveConverterCorretamenteDePessoaSaveDTOParaPessoa(){
        PessoaSaveDTO pessoaSaveDTO = new PessoaSaveDTO();
        pessoaSaveDTO.setNome("Anderson");

        ContatoSaveDTO contatoSaveDTO = new ContatoSaveDTO();
        contatoSaveDTO.setTipoContato(TipoContato.EMAIL);
        contatoSaveDTO.setConteudo("piottok10@gmail.com");
        pessoaSaveDTO.setContatos(List.of(contatoSaveDTO));

        Pessoa pessoa = PessoaConverter.convertToPessoa(pessoaSaveDTO);

        assertNotNull(pessoa);
        assertEquals(pessoaSaveDTO.getNome(), pessoa.getNome());

        for (int i = 0; i < pessoa.getContatos().size(); i++) {
            assertEquals(pessoaSaveDTO.getContatos().get(i).getTipoContato(), pessoa.getContatos().get(i).getTipoContato());
            assertEquals(pessoaSaveDTO.getContatos().get(i).getConteudo(), pessoa.getContatos().get(i).getConteudo());
        }
    }

    @Test
    public void deveConverterCorretamenteDePessoaUpdateDTOParaPessoa(){
        PessoaUpdateDTO pessoaUpdateDTO = new PessoaUpdateDTO();
        pessoaUpdateDTO.setId(1L);
        pessoaUpdateDTO.setNome("Anderson");

        ContatoUpdateDTO contatoUpdateDTO = new ContatoUpdateDTO();
        contatoUpdateDTO.setTipoContato(TipoContato.EMAIL);
        contatoUpdateDTO.setConteudo("piottok10@gmail.com");
        pessoaUpdateDTO.setContatos(List.of(contatoUpdateDTO));

        Pessoa pessoa = PessoaConverter.convertToPessoa(pessoaUpdateDTO);

        assertNotNull(pessoa);
        assertEquals(pessoaUpdateDTO.getId(), pessoa.getId());
        assertEquals(pessoaUpdateDTO.getNome(), pessoa.getNome());

        for (int i = 0; i < pessoa.getContatos().size(); i++) {
            assertEquals(pessoaUpdateDTO.getContatos().get(i).getId(), pessoa.getContatos().get(i).getId());
            assertEquals(pessoaUpdateDTO.getContatos().get(i).getTipoContato(), pessoa.getContatos().get(i).getTipoContato());
            assertEquals(pessoaUpdateDTO.getContatos().get(i).getConteudo(), pessoa.getContatos().get(i).getConteudo());
        }
    }

    @Test
    public void deveConverterCorretamenteDePessoaParaPessoaVO(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Anderson");

        Contato contato = new Contato();
        contato.setTipoContato(TipoContato.EMAIL);
        contato.setConteudo("piottok10@gmail.com");
        pessoa.setContatos(List.of(contato));

        PessoaVO pessoaVO = PessoaConverter.convertToPessoaVO(pessoa);

        assertNotNull(pessoaVO);
        assertEquals(pessoa.getId(), pessoaVO.getId());
        assertEquals(pessoa.getNome(), pessoaVO.getNome());

        for (int i = 0; i < pessoa.getContatos().size(); i++) {
            assertEquals(pessoa.getContatos().get(i).getId(), pessoaVO.getContatos().get(i).getId());
            assertEquals(pessoa.getContatos().get(i).getTipoContato(), pessoaVO.getContatos().get(i).getTipoContato());
            assertEquals(pessoa.getContatos().get(i).getConteudo(), pessoaVO.getContatos().get(i).getConteudo());
        }
    }
}