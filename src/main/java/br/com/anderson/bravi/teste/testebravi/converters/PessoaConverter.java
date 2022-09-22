package br.com.anderson.bravi.teste.testebravi.converters;

import br.com.anderson.bravi.teste.testebravi.dto.PessoaSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaUpdateDTO;
import br.com.anderson.bravi.teste.testebravi.model.Contato;
import br.com.anderson.bravi.teste.testebravi.model.Pessoa;
import br.com.anderson.bravi.teste.testebravi.vo.ContatoVO;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

/** Classe que representa um converter de Pessoa e contatos
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
public class PessoaConverter {

    public static PessoaVO convertToPessoaVO(Pessoa pessoa) {
        PessoaVO pessoaVO = new PessoaVO();
        copyProperties(pessoa, pessoaVO);

        List<ContatoVO> contatosVO = pessoa.getContatos().stream().map(contato -> {
            ContatoVO contatoVO = new ContatoVO();
            copyProperties(contato, contatoVO);
            return contatoVO;
        }).collect(Collectors.toList());

        pessoaVO.setContatos(contatosVO);
        return pessoaVO;
    }

    public static Pessoa convertToPessoa(PessoaSaveDTO pessoaSaveDTO) {
        Pessoa pessoa = new Pessoa();
        copyProperties(pessoaSaveDTO, pessoa);

        List<Contato> contatos = pessoaSaveDTO.getContatos().stream().map(contatoDTO -> {
            Contato contato = new Contato();
            copyProperties(contatoDTO, contato);
            return contato;
        }).collect(Collectors.toList());

        pessoa.setContatos(contatos);

        return pessoa;
    }

    public static Pessoa convertToPessoa(PessoaUpdateDTO pessoaUpdateDTO) {
        Pessoa pessoa = new Pessoa();
        copyProperties(pessoaUpdateDTO, pessoa);

        List<Contato> contatos = pessoaUpdateDTO.getContatos().stream().map(contatoDTO -> {
            Contato contato = new Contato();
            copyProperties(contatoDTO, contato);
            return contato;
        }).collect(Collectors.toList());

        pessoa.setContatos(contatos);

        return pessoa;
    }
}
