package br.com.anderson.bravi.teste.testebravi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/** Classe que representa um contato
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoContato tipoContato;
    private String conteudo;
}
