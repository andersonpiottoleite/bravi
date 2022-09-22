package br.com.anderson.bravi.teste.testebravi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PessoaUpdateDTO {
    @NotNull
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private List<ContatoUpdateDTO> contatos;
}
