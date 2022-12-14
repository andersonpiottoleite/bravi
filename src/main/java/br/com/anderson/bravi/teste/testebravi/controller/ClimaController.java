package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.client.ClimaCidadeClient;
import br.com.anderson.bravi.teste.testebravi.vo.ClimaCidadeVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Classe que representa um controlador para ver o clima pela cidade
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@RestController
@RequestMapping("/clima")
public class ClimaController {

    private static Logger LOGGER = LoggerFactory.getLogger(ClimaController.class);

    public ClimaCidadeClient climaCidadeClient;

    @Autowired
    public ClimaController(ClimaCidadeClient climaCidadeClient){
        this.climaCidadeClient = climaCidadeClient;
    }

    @ApiOperation("Busca clima por cidade")
    @GetMapping("/{cidade}")
    public ResponseEntity<ClimaCidadeVO> getClimaPorCidade(@PathVariable("cidade") String cidade){
        LOGGER.info("Inicinado consuta do clima...");
        ClimaCidadeVO climaPorCidade = climaCidadeClient.getClimaPorCidade(cidade);
        LOGGER.info("Consulta do clima fnalizada!");
        return ResponseEntity.status(HttpStatus.OK).body(climaPorCidade);
    }
}
