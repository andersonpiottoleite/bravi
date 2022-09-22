package br.com.anderson.bravi.teste.testebravi.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class PessoaSaveDTO {
    @NotEmpty
    private String nome;
    @NotEmpty
    private List<ContatoSaveDTO> contatos;
}
