package br.com.anderson.bravi.teste.testebravi.controller;

import br.com.anderson.bravi.teste.testebravi.hateoas.RootEntryPointModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/** Classe que representa o recurso raiz
 * sua função é instruir o cliente em como iniciar a utilização da API
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@RestController
@RequestMapping("/")
public class RootEntryPointController {

    private static Logger LOGGER = LoggerFactory.getLogger(RootEntryPointController.class);

    @GetMapping
    public ResponseEntity<RootEntryPointModel> getRoot() {
        LOGGER.info("Obtendo endpoint raiz da API...");
        RootEntryPointModel resp = new RootEntryPointModel();
        resp.add(linkTo(methodOn(PessoaConstroller.class).save(null)).withRel("pessoa") );
        LOGGER.info("Endpoint raiz da API obtido!");
        return ResponseEntity.ok(resp);
    }

}
