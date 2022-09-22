package br.com.anderson.bravi.teste.testebravi.service;

import br.com.anderson.bravi.teste.testebravi.dto.PessoaSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaUpdateDTO;
import br.com.anderson.bravi.teste.testebravi.exceptions.PessoaNotFoundException;
import br.com.anderson.bravi.teste.testebravi.model.Pessoa;
import br.com.anderson.bravi.teste.testebravi.repository.PessoaRepository;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.anderson.bravi.teste.testebravi.converters.PessoaConverter.convertToPessoa;
import static br.com.anderson.bravi.teste.testebravi.converters.PessoaConverter.convertToPessoaVO;

/** Classe que representa um service de pessoa e contatos
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaVO save(PessoaSaveDTO pessoaSaveDTO){
        Pessoa pessoa = convertToPessoa(pessoaSaveDTO);
        Pessoa pessoaSalva= pessoaRepository.save(pessoa);
        return convertToPessoaVO(pessoaSalva);
    }

    public PessoaVO update(PessoaUpdateDTO pessoaUpdateDTO){
        Pessoa pessoa = convertToPessoa(pessoaUpdateDTO);
        Pessoa pessoaAlterada = pessoaRepository.save(pessoa);
        return convertToPessoaVO(pessoaAlterada);
    }

    public void delete(Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
    }

    public List<PessoaVO> findAll(){
        List<Pessoa> pessoas = pessoaRepository.findAll();

        if (pessoas.isEmpty()){
            throw new PessoaNotFoundException("Nenhuma pessoa cadastrada") ;
        }

        return pessoas.stream().map(p -> {
            return convertToPessoaVO(p);
        }).collect(Collectors.toList());
    }

    public PessoaVO findById(Long idPessoa){
        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada com o id: " + idPessoa));
        return convertToPessoaVO(pessoa);
    }
}
