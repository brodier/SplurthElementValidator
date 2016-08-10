
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

}
