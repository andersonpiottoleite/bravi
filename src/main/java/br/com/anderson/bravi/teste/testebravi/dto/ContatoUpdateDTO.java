package br.com.anderson.bravi.teste.testebravi.dto;

import br.com.anderson.bravi.teste.testebravi.model.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoUpdateDTO {
    private Long id;
    private TipoContato tipoContato;
    private String conteudo;
}
