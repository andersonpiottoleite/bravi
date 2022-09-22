package br.com.anderson.bravi.teste.testebravi.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SuportesBalanceladosTest {

    private SuportesBalanceladosUtil suportesBalanceladosUtil;

    @Before
    public void antesDeCadaTeste(){
        suportesBalanceladosUtil = new SuportesBalanceladosUtil();
    }

    @Test
    public void colchetesValidosDevemPassarNoTeste() {
        assertTrue(suportesBalanceladosUtil.validaColchetes("()"));
        assertTrue(suportesBalanceladosUtil.validaColchetes("{}"));
        assertTrue(suportesBalanceladosUtil.validaColchetes("[]"));
        assertTrue(suportesBalanceladosUtil.validaColchetes("(){}[]"));
        assertTrue(suportesBalanceladosUtil.validaColchetes("[{()}](){}"));
    }

    @Test
    public void colchetesInvalidosDevemReprovarNoTeste() {
        assertFalse(suportesBalanceladosUtil.validaColchetes("[]{()"));
        assertFalse(suportesBalanceladosUtil.validaColchetes("[{)]"));
        assertFalse(suportesBalanceladosUtil.validaColchetes("[{}]{"));
        assertFalse(suportesBalanceladosUtil.validaColchetes("[{}]}"));
        assertFalse(suportesBalanceladosUtil.validaColchetes("[{}"));
        assertFalse(suportesBalanceladosUtil.validaColchetes("[{]{"));
        assertFalse(suportesBalanceladosUtil.validaColchetes("[["));
        assertFalse(suportesBalanceladosUtil.validaColchetes("}{"));
        assertFalse(suportesBalanceladosUtil.validaColchetes("]["));
        assertFalse(suportesBalanceladosUtil.validaColchetes(")("));
    }
}
