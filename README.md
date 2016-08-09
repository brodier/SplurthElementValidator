# SplurthElementValidator

## SplurthElementValidator.java file

```java


public class SplurthElementValidator {

    private static final int NOT_FOUND = -1;
    private static final int SYMBOL_LENGTH = 2;

    public boolean validate(String symbolElement, String elementName) {
        // Normalize
        String symbol = symbolElement.toLowerCase();
        String element = elementName.toLowerCase();

        // Test symbol length
        if (symbol.length() != SYMBOL_LENGTH) {
            return false;
        }

        int i1 = element.indexOf(symbol.charAt(0));
        return i1 != NOT_FOUND && element.substring(i1 + 1).indexOf(symbol.charAt(1)) > 0;
    }

}
```

# SplurthElementValidator.java JUnit test case for validation

```java
// ChanlangeTest.java

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

}
```
