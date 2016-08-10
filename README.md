# SplurthElementValidator

## SplurthElementValidator.java file

```java

package com.github.brodier.splurth;

import java.util.HashSet;
import java.util.Set;

public class SplurthElementValidator {

    private static final int NOT_FOUND = -1;
    private static final int SYMBOL_LENGTH = 2;

    public boolean validate(String symbolElement, String elementName) {
        // Normalize
        String symbol = symbolElement.toLowerCase();
        String element = elementName.toLowerCase();

        // Test
        if (symbol.length() != SYMBOL_LENGTH) {
            return false;
        }

        int i1 = element.indexOf(symbol.charAt(0));
        if (i1 == NOT_FOUND) {
            return false;
        } else if (element.substring(i1 + 1).indexOf(symbol.charAt(1)) < 1) {
            return false;
        }

        return true;
    }

    public String getFirstOrderedSymbol(String elementName) {
        int firstSymbolLetterIndex = getIndexOfLowerCharacter(
                elementName.toLowerCase().substring(0, elementName.length() - 1));
        int relative2ndSymbLetterIdx = getIndexOfLowerCharacter(
                elementName.toLowerCase().substring(firstSymbolLetterIndex + 1));
        char[] symbolChars = { Character.toUpperCase(elementName.charAt(firstSymbolLetterIndex)),
                Character.toLowerCase(elementName.charAt(relative2ndSymbLetterIdx + firstSymbolLetterIndex + 1)) };
        return new String(symbolChars);
    }

    public int nbValidSymbols(String elementName) {
        return listAllSymbol(elementName).size();
    }

    private int getIndexOfLowerCharacter(String string) {
        Character firstChar = null;
        for (Character c : string.toCharArray()) {
            if (firstChar == null || firstChar > c) {
                firstChar = c;
            }
        }
        return string.indexOf(firstChar);
    }

    private Set<String> listAllSymbol(String elementName) {
        Set<String> validSymbols = new HashSet<String>();
        for (int i = 0; i < elementName.length() - 1; i++) {
            Character fstSymLet = Character.toUpperCase(elementName.charAt(i));
            for (Character sndSymLet : elementName.toLowerCase().substring(i + 1).toCharArray()) {
                validSymbols.add(new String(new char[] { fstSymLet, sndSymLet }));
            }
        }
        return validSymbols;
    }

}
```

# SplurthElementValidator.java JUnit test case for validation

```java
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

```
