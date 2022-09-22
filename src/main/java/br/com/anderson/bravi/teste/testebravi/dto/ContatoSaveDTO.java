package br.com.anderson.bravi.teste.testebravi.dto;

import br.com.anderson.bravi.teste.testebravi.model.TipoContato;
import lombok.Data;;


@Data
public class ContatoSaveDTO {

    private TipoContato tipoContato;
    private String conteudo;
}
