package br.com.anderson.bravi.teste.testebravi.exceptions;

/** Classe que representa exceptions que podem ocorrer em Pessoas e contatos
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
public class PessoaNotFoundException extends RuntimeException{

    public PessoaNotFoundException(String msg){
        super(msg);
    }
}
