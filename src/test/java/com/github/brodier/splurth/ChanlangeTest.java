package com.github.brodier.splurth;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChanlangeTest {

    public SplurthElementValidator validator = new SplurthElementValidator();

    @Test
    public void testEe() {
        assertTrue(validator.validate("Ee", "Spenglerium"));
    }

    @Test
    public void testZr() {
        assertTrue(validator.validate("Zr", "Zeddemorium"));
    }

    @Test
    public void testKn() {
        assertTrue(validator.validate("Kn", "Venkmine"));
    }

    @Test
    public void testZt() {
        assertFalse(validator.validate("Zt", "Stantzon"));
    }

    @Test
    public void testNn() {
        assertFalse(validator.validate("Nn", "Melintzum"));
    }

    @Test
    public void testTy() {
        assertFalse(validator.validate("Ty", "Tullium"));
    }

    @Test
    public void testMm() {
        assertFalse(validator.validate("Mm", "Ratinum"));
    }

    @Test
    public void testFirstSymbolGozeium() {
        assertEquals("Ei", validator.getFirstOrderedSymbol("Gozeium"));
    }

    @Test
    public void testFirstSymbolSlimyrine() {
        assertEquals("Ie", validator.getFirstOrderedSymbol("Slimyrine"));
    }
    
    @Test
    public void testNbSymbolZuulon() {
        assertEquals(11, validator.nbValidSymbols("Zuulon"));
    }
    
}
