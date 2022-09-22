package br.com.anderson.bravi.teste.testebravi.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

/** Classe que representa um validador de colchetes
 *
 * @author Anderson Piotto
 * @version 1.0.0
 * @since 22/09/2022
 */
@Component
public class SuportesBalanceladosUtil {

    public boolean validaColchetes(String colchetes) {
        if(Strings.isEmpty(colchetes)){
            return false;
        }

        return naoContemColchetes(colchetes)
                && (validaSeTodosEstaoFechados(colchetes) && validaOrdemAberturaFechamento(colchetes));
    }

    private boolean validaSeTodosEstaoFechados(String colchetes) {
        long qtdeChavesAbertas = colchetes.chars().filter(c -> (char) c == '{').count();
        long qtdeColhetesAbertos = colchetes.chars().filter(c -> (char) c == '[').count();
        long qtdeParentesesAbertos = colchetes.chars().filter(c -> (char) c == '(').count();

        long qtdeChavesFechadas = colchetes.chars().filter(c -> (char) c == '}').count();
        long qtdeColhetesFechados = colchetes.chars().filter(c -> (char) c == ']').count();
        long qtdeParentesesFechados = colchetes.chars().filter(c -> (char) c == ')').count();

        if ((qtdeChavesAbertas != qtdeChavesFechadas) || (qtdeColhetesAbertos != qtdeColhetesFechados) || (qtdeParentesesAbertos != qtdeParentesesFechados)){
            return false;
        }
        return true;
    }

    private boolean validaOrdemAberturaFechamento(String colchete) {
        if(colchete.equals("][")) return false;
        if(colchete.equals(")(")) return false;
        if(colchete.equals("}{")) return false;
        return true;
    }

    private boolean naoContemColchetes(String colchete) {
        if(!colchete.contains("[")
            && !colchete.contains("]")
            && !colchete.contains("{")
            && !colchete.contains("}")
            && !colchete.contains("(")
            && !colchete.contains(")")) {
            return false;
        }
        return true;
    }
}
