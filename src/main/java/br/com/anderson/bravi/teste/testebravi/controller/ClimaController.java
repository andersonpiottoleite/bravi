package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.client.ClimaCidadeClient;
import br.com.anderson.bravi.teste.testebravi.exceptions.IntegracaoException;
import br.com.anderson.bravi.teste.testebravi.vo.ClimaCidadeVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    public ClimaCidadeClient climaCidadeClient;

    @ApiOperation("Busca clima por cidade")
    @GetMapping("/{cidade}")
    public ResponseEntity<ClimaCidadeVO> getClimaPorCidade(@PathVariable("cidade") String cidade){
        ClimaCidadeVO climaPorCidade = climaCidadeClient.getClimaPorCidade(cidade);
        return ResponseEntity.status(HttpStatus.OK).body(climaPorCidade);
    }
}
