package com.github.brodier.splurth;

import java.util.HashSet;
import java.util.List;
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
