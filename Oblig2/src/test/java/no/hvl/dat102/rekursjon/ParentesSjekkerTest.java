package no.hvl.dat102.rekursjon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParentesSjekkerTest {
    public final static String riktigJavaProgram = """
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
""";

    public final static String forMangeStartParenteser = """
class HelloWorld {{
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
""";

    public final static String forMangeSluttParenteser = """
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }}
}
""";

    public final static String garbledMess = """
class HelloWorld {]))(((({{{[[]
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }}](
}
""";

    static final String eks1 = "{ [ ( ) ] }";
    static final String eks2 = " [ ( ) }";
    static final String eks3 = "[ ( ) ] }";
    static final String eks4 = "{ [ ( ] ) }";
    static final String eks5 = "{ ( [ [ { } ] ] ) }";

    @Test
    public void testSjekkParenteser() {
        assertTrue(ParentesSjekker.sjekkParenteser(riktigJavaProgram));
        assertFalse(ParentesSjekker.sjekkParenteser(forMangeStartParenteser));
        assertFalse(ParentesSjekker.sjekkParenteser(forMangeSluttParenteser));
        assertFalse(ParentesSjekker.sjekkParenteser(garbledMess));
        assertTrue(ParentesSjekker.sjekkParenteser(eks1));
        assertFalse(ParentesSjekker.sjekkParenteser(eks2));
        assertFalse(ParentesSjekker.sjekkParenteser(eks3));
        assertFalse(ParentesSjekker.sjekkParenteser(eks4));
        assertTrue(ParentesSjekker.sjekkParenteser(eks5));
    }
}
