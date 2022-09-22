package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.dto.PessoaSaveDTO;
import br.com.anderson.bravi.teste.testebravi.dto.PessoaUpdateDTO;
import br.com.anderson.bravi.teste.testebravi.exceptions.PessoaException;
import br.com.anderson.bravi.teste.testebravi.model.Pessoa;
import br.com.anderson.bravi.teste.testebravi.repository.PessoaRepository;
import br.com.anderson.bravi.teste.testebravi.service.PessoaService;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.beans.BeanUtils.copyProperties;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;


    @ApiOperation("Endpoint para salvar uma pessoa")
    @PostMapping
    public ResponseEntity<PessoaVO> save(@Valid  @RequestBody PessoaSaveDTO pessoaSaveDTO){
        try {
            PessoaVO pessoaSalva = pessoaService.save(pessoaSaveDTO);
            //addHateoas(pessoaSalva);

            return ResponseEntity.created(
                    new URI(createLocale(pessoaSalva).toUriString())).build();

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private UriComponents createLocale(PessoaVO pessoaSalva) {
        return UriComponentsBuilder.newInstance()
                .scheme("http").host("localhost:8080")
                .path("/teste-bravi").path("/pessoa/" + pessoaSalva.getId()).build();
    }

    @ApiOperation("Endpoint para alterar uma pessoa")
    @PutMapping
    public ResponseEntity<PessoaVO> update(@Valid @RequestBody PessoaUpdateDTO pessoaUpdateDTO){
        try {
            PessoaVO pessoaAlterada = pessoaService.update(pessoaUpdateDTO);
            //addHateoas(pessoaAlterada);
            return ResponseEntity.status(HttpStatus.OK).body(pessoaAlterada);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para deletar uma pessoa por id")
    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Long idPessoa){
        try {
            pessoaService.delete(idPessoa);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para listar varias pessoas")
    @GetMapping
    public ResponseEntity<List<PessoaVO>> findAll(){
        try {
            List<PessoaVO> pessoas = pessoaService.findAll();
           // pessoas.stream().peek(p -> addHateoas(p));
            return ResponseEntity.status(HttpStatus.OK).body(pessoas);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation("Endpoint para buscar uma pessoa por id")
    @GetMapping("/{idPessoa}")
    public ResponseEntity<PessoaVO> findById(@PathVariable("idPessoa")Long idPessoa){
        PessoaVO pessoa = pessoaService.findById(idPessoa);
        //addHateoas(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

//    private void addHateoas(PessoaVO pessoaVO) {
//        pessoaVO.add(linkTo(methodOn(PessoaController.class).findById(pessoaVO.getId()))
//                .withSelfRel());
//        pessoaVO.add(linkTo(methodOn(PessoaController.class).findAll()).withRel(IanaLinkRelations.COLLECTION));
//    }
}
