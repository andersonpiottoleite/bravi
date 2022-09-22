package br.com.anderson.bravi.teste.testebravi.repository;

import br.com.anderson.bravi.teste.testebravi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/** Interface que representa um tipo de pessoa
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
