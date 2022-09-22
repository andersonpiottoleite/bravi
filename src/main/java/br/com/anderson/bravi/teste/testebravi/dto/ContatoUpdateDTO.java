package br.com.anderson.bravi.teste.testebravi.dto;

import br.com.anderson.bravi.teste.testebravi.model.TipoContato;
import lombok.Data;

@Data
public class ContatoUpdateDTO {
    private Long id;
    private TipoContato tipoContato;
    private String conteudo;
}
