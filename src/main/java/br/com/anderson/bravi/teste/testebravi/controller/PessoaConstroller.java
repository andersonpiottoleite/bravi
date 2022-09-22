package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.dto.PessoaSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaUpdateDTO;
import br.com.anderson.bravi.teste.testebravi.service.PessoaService;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private PessoaService pessoaService;

    @ApiOperation("Endpoint para salvar uma pessoa e seus contatos")
    @PostMapping
    public ResponseEntity<PessoaVO> save(@Valid  @RequestBody PessoaSaveDTO pessoaSaveDTO){
        try {
            PessoaVO pessoaSalva = pessoaService.save(pessoaSaveDTO);
            addHateoas(pessoaSalva);
            return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para alterar uma pessoa e seus contatos")
    @PutMapping
    public ResponseEntity<PessoaVO> update(@Valid @RequestBody PessoaUpdateDTO pessoaUpdateDTO){
        try {
            PessoaVO pessoaAlterada = pessoaService.update(pessoaUpdateDTO);
            addHateoas(pessoaAlterada);
            return ResponseEntity.status(HttpStatus.OK).body(pessoaAlterada);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para deletar uma pessoa (e seus contatos) por id")
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Long idPessoa){
        try {
            pessoaService.delete(idPessoa);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para listar varias pessoas e seus contatos")
    @GetMapping("/all")
    public ResponseEntity<List<PessoaVO>> findAll(){
        try {
            List<PessoaVO> pessoas = pessoaService.findAll();
            pessoas = pessoas.stream().map(p -> {
                addHateoas(p);
                return p;
            }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(pessoas);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para buscar uma pessoa (e seus contatos) por id")
    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaVO> findById(@PathVariable("idPessoa")Long idPessoa){
        PessoaVO pessoa = pessoaService.findById(idPessoa);
        addHateoas(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    private void addHateoas(PessoaVO pessoaVO) {
        pessoaVO.add(linkTo(methodOn(PessoaConstroller.class).findById(pessoaVO.getId()))
                .withSelfRel());
        pessoaVO.add(linkTo(methodOn(PessoaConstroller.class).findAll()).withRel(IanaLinkRelations.COLLECTION));
    }
}
