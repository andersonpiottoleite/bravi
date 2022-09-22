package br.com.anderson.bravi.teste.testebravi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaUpdateDTO {
    @NotNull
    private Long id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private List<ContatoUpdateDTO> contatos;
}
