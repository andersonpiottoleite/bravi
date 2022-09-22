package br.com.anderson.bravi.teste.testebravi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaSaveDTO {
    @NotEmpty
    private String nome;
    @NotEmpty
    private List<ContatoSaveDTO> contatos;
}
