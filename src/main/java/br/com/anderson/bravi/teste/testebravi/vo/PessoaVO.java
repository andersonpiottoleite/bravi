package br.com.anderson.bravi.teste.testebravi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaVO extends RepresentationModel<PessoaVO>{
    private Long id;
    private String nome;
    private List<ContatoVO> contatos;
}
