package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.dto.PessoaSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaUpdateDTO;
import br.com.anderson.bravi.teste.testebravi.service.PessoaService;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/** Classe que representa um controlador de pessoa
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaConstroller {

    private static Logger LOGGER = LoggerFactory.getLogger(PessoaConstroller.class);

    private PessoaService pessoaService;
    @Autowired
    public PessoaConstroller(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @ApiOperation("Endpoint para salvar uma pessoa e seus contatos")
    @PostMapping
    public ResponseEntity<PessoaVO> save(@Valid  @RequestBody PessoaSaveDTO pessoaSaveDTO){
        try {
            LOGGER.info("Salvando a pessoa e seus contatos...");
            PessoaVO pessoaSalva = pessoaService.save(pessoaSaveDTO);
            addHateoas(pessoaSalva);
            LOGGER.info("Pessoa e seus contatos foram salvos com sucesso!");
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
        }catch (Exception ex){
            LOGGER.error("Ocorreu um erro ao salvar a pessoa!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para alterar uma pessoa e seus contatos")
    @PutMapping
    public ResponseEntity<PessoaVO> update(@Valid @RequestBody PessoaUpdateDTO pessoaUpdateDTO){
        try {
            LOGGER.info("Alterando a pessoa e seus contatos...");
            PessoaVO pessoaAlterada = pessoaService.update(pessoaUpdateDTO);
            addHateoas(pessoaAlterada);
            LOGGER.info("Pessoa e seus contatos foram alterados com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(pessoaAlterada);
        }catch (Exception ex){
            LOGGER.error("Ocorreu um erro ao alterar a pessoa!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para deletar uma pessoa (e seus contatos) por id")
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Long idPessoa){
        try {
            LOGGER.info("Deletando a pessoa pelo ID: " + idPessoa);
            pessoaService.delete(idPessoa);
            LOGGER.info("Deleção realizada com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception ex){
            LOGGER.error("Ocorreu um erro ao deletar a pessoa de ID " + idPessoa);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para listar varias pessoas e seus contatos")
    @GetMapping("/all")
    public ResponseEntity<List<PessoaVO>> findAll(){
        LOGGER.info("Buscando todas as pessoas...");
        List<PessoaVO> pessoas = pessoaService.findAll();
        pessoas = pessoas.stream().map(p -> {
            addHateoas(p);
            return p;
        }).collect(Collectors.toList());
        LOGGER.info("Busca realizada com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(pessoas);
    }

    @ApiOperation("Endpoint para buscar uma pessoa (e seus contatos) por id")
    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaVO> findById(@PathVariable("idPessoa")Long idPessoa){
        LOGGER.info("Buscando a pessoa pelo ID: " + idPessoa);
        PessoaVO pessoa = pessoaService.findById(idPessoa);
        addHateoas(pessoa);
        LOGGER.info("Busca realizada com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    private void addHateoas(PessoaVO pessoaVO) {
        pessoaVO.add(linkTo(methodOn(PessoaConstroller.class).findById(pessoaVO.getId()))
                .withSelfRel());
        pessoaVO.add(linkTo(methodOn(PessoaConstroller.class).findAll())
                .withRel(IanaLinkRelations.COLLECTION));
    }
}