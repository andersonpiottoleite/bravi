package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.service.SuportesBalanceladosService;
import br.com.anderson.bravi.teste.testebravi.vo.PessoaVO;
import br.com.anderson.bravi.teste.testebravi.vo.SuportesBalanceladosVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/suportes-balancelados")
public class SuportesBalanceladosController {

    @Autowired
    private SuportesBalanceladosService suportesBalanceladosService;

    @ApiOperation("Endpoint para validar ordem de colchetes")
    @GetMapping
    public ResponseEntity<SuportesBalanceladosVO> valida(@RequestParam("colchetes")String colchetes){
        boolean colchetesValidados = suportesBalanceladosService.validaColchetes(colchetes);
        return ResponseEntity.status(HttpStatus.OK).body(new SuportesBalanceladosVO(colchetesValidados));
    }
}
