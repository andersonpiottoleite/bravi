package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.service.SuportesBalanceladosUtil;
import br.com.anderson.bravi.teste.testebravi.vo.SuportesBalanceladosVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Classe que representa um controller para validação de colchetes
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@RestController
@RequestMapping("/suportes-balancelados")
public class SuportesBalanceladosController {

    @Autowired
    private SuportesBalanceladosUtil suportesBalanceladosUtil;

    @ApiOperation("Endpoint para validar ordem de colchetes")
    @GetMapping
    public ResponseEntity<SuportesBalanceladosVO> valida(@RequestParam("colchetes")String colchetes){
        boolean colchetesValidados = suportesBalanceladosUtil.validaColchetes(colchetes);
        return ResponseEntity.status(HttpStatus.OK).body(new SuportesBalanceladosVO(colchetesValidados));
    }
}
