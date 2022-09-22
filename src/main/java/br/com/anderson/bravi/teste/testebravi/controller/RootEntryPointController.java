//package br.com.anderson.bravi.teste.testebravi.controller;
//
//import br.com.anderson.bravi.teste.testebravi.hateoas.RootEntryPointModel;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
//@RestController
//@RequestMapping("/")
//public class RootEntryPointController {
//
//
//    @GetMapping
//    public ResponseEntity<RootEntryPointModel> getRoot() {
//        RootEntryPointModel resp = new RootEntryPointModel();
//        resp.add(linkTo(methodOn(PessoaController.class).save(null)).withRel("pessoa") );
//        return ResponseEntity.ok(resp);
//    }
//
//}
