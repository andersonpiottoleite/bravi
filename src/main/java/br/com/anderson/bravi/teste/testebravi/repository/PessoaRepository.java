package br.com.anderson.bravi.teste.testebravi.repository;

import br.com.anderson.bravi.teste.testebravi.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
