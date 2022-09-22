package br.com.anderson.bravi.teste.testebravi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/** Classe responsavel por subir a aplicação
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */

@SpringBootApplication
public class TesteBraviApplication {

    public static void main(String[] args) {
        SpringApplication.run(TesteBraviApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
