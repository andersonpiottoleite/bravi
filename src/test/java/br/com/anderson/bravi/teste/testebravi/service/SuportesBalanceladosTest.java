package br.com.anderson.bravi.teste.testebravi.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SuportesBalanceladosTest {

    private SuportesBalanceladosService suportesBalanceladosService;

    @Before
    public void antesDeCadaTeste(){
        suportesBalanceladosService = new SuportesBalanceladosService();
    }

    @Test
    public void colchetesValidosDevemPassarNoTeste() {
        assertTrue(suportesBalanceladosService.validaColchetes("()"));
        assertTrue(suportesBalanceladosService.validaColchetes("{}"));
        assertTrue(suportesBalanceladosService.validaColchetes("[]"));
        assertTrue(suportesBalanceladosService.validaColchetes("(){}[]"));
        assertTrue(suportesBalanceladosService.validaColchetes("[{()}](){}"));
    }

    @Test
    public void colchetesInvalidosDevemReprovarNoTeste() {
        assertFalse(suportesBalanceladosService.validaColchetes("[]{()"));
        assertFalse(suportesBalanceladosService.validaColchetes("[{)]"));
        assertFalse(suportesBalanceladosService.validaColchetes("[{}]{"));
        assertFalse(suportesBalanceladosService.validaColchetes("[{}]}"));
        assertFalse(suportesBalanceladosService.validaColchetes("[{}"));
        assertFalse(suportesBalanceladosService.validaColchetes("[{]{"));
        assertFalse(suportesBalanceladosService.validaColchetes("[["));
        assertFalse(suportesBalanceladosService.validaColchetes("}{"));
        assertFalse(suportesBalanceladosService.validaColchetes("]["));
        assertFalse(suportesBalanceladosService.validaColchetes(")("));
    }
}
