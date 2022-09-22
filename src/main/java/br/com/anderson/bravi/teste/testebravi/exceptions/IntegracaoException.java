package br.com.anderson.bravi.teste.testebravi.exceptions;

/** Classe que representa exceptions oriundas de integrações entre APIS
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
public class IntegracaoException extends RuntimeException{
    public IntegracaoException (String msg){
        super(msg);
    }
}
