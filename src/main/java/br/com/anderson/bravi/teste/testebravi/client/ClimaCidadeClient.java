package br.com.anderson.bravi.teste.testebravi.client;

import br.com.anderson.bravi.teste.testebravi.exceptions.IntegracaoException;
import br.com.anderson.bravi.teste.testebravi.vo.ClimaCidadeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/** Classe responsavel por integrar com a api de Clima
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@Component
public class ClimaCidadeClient {

    private static Logger LOGGER = LoggerFactory.getLogger(ClimaCidadeClient.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openweathermap.appid}")
    private String appid = "b9c33b838f9817535ad9a823e15ee831";

    public ClimaCidadeVO getClimaPorCidade(String cidade){
        try{
            LOGGER.info("Consultando a API de Clima, com os parametros: CIDADE " + cidade);
            ResponseEntity<ClimaCidadeVO> response =
                    restTemplate.getForEntity("https://api.openweathermap.org/data/2.5/weather?q=".concat(cidade).concat("&appid=").concat(appid),
                            ClimaCidadeVO.class);
            ClimaCidadeVO body = response.getBody();
            LOGGER.info("Consulta à API de Clima realizada com sucesso");
            return body;
        }catch (IntegracaoException ex){
            LOGGER.error("Ocorreu um erro de integração com a API de Clima");
            throw new IntegracaoException("Ocorreu um erro de integração com a API de Clima");
        }
    }
}
