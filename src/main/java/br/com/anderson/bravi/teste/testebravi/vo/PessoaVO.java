package br.com.anderson.bravi.teste.testebravi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.hateoas.RepresentationModel;
//import org.springframework.hateoas.server.core.Relation;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Relation(collectionRelation = "pessoas")
public class PessoaVO /*extends RepresentationModel<PessoaVO>*/{
    private Long id;
    private String nome;
    private List<ContatoVO> contatos;
}
