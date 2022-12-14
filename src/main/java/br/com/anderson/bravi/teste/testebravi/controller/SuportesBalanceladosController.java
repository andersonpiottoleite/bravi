package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.service.SuportesBalanceladosUtil;
import br.com.anderson.bravi.teste.testebravi.vo.SuportesBalanceladosVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Classe que representa um controller para validação de colchetes
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@RestController
@RequestMapping("/suportes-balancelados")
public class SuportesBalanceladosController {

    private static Logger LOGGER = LoggerFactory.getLogger(SuportesBalanceladosController.class);
    private SuportesBalanceladosUtil suportesBalanceladosUtil;
    @Autowired
    public SuportesBalanceladosController(SuportesBalanceladosUtil suportesBalanceladosUtil) {
        this.suportesBalanceladosUtil = suportesBalanceladosUtil;
    }

    @ApiOperation("Endpoint para validar ordem de colchetes")
    @GetMapping
    public ResponseEntity<SuportesBalanceladosVO> valida(@RequestParam("colchetes")String colchetes){
        LOGGER.info("Iniciando validacao dos colchetes... " + colchetes);
        boolean colchetesValidados = suportesBalanceladosUtil.validaColchetes(colchetes);
        LOGGER.info("Validacao dos colchetes finalizada!");
        return ResponseEntity.status(HttpStatus.OK).body(new SuportesBalanceladosVO(colchetesValidados));
    }
}
