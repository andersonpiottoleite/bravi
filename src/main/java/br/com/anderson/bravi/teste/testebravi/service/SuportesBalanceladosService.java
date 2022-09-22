package br.com.anderson.bravi.teste.testebravi.service;

import org.springframework.stereotype.Service;

@Service
public class SuportesBalanceladosService {

    public boolean validaColchetes(String colchetes) {
        return validaSeTodosEstaoFechados(colchetes) && validaOrdemAberturaFechamento(colchetes);
    }

    private boolean validaSeTodosEstaoFechados(String colchete) {
        long qtdeChavesAbertas = colchete.chars().filter(c -> (char) c == '{').count();
        long qtdeColhetesAbertos = colchete.chars().filter(c -> (char) c == '[').count();
        long qtdeParentesesAbertos = colchete.chars().filter(c -> (char) c == '(').count();

        long qtdeChavesFechadas = colchete.chars().filter(c -> (char) c == '}').count();
        long qtdeColhetesFechados = colchete.chars().filter(c -> (char) c == ']').count();
        long qtdeParentesesFechados = colchete.chars().filter(c -> (char) c == ')').count();

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
}
