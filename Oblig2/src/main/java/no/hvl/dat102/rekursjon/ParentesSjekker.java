package no.hvl.dat102.rekursjon;

public class ParentesSjekker {
    public static final String startParenteser = "([{";
    public static final String sluttParenteser = ")]}";

    public static void main(String[] args) {
        String javaprogram = """
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
""";

        System.out.println(sjekkParenteser(javaprogram));
    }

    public static boolean sjekkParenteser(String s) {
        TabellStabel<Character> stabel = new TabellStabel<>();
        char[] charTabell = s.toCharArray();

        for (char c : charTabell) {
            if (erStartParentes(c)) {
                stabel.push(c);
            } else if (erSluttParentes(c)) {
                if (stabel.isEmpty()) {
                    return false;
                }
                if (erParentesPar(stabel.peek(), c)) {
                    stabel.pop();
                }
            }
        }
        return stabel.isEmpty();
    }

    private static boolean erStartParentes(char c) {
        return startParenteser.contains(String.valueOf(c));
    }

    private static boolean erSluttParentes(char c) {
        return sluttParenteser.contains(String.valueOf(c));
    }

    private static boolean erParentesPar(char start, char slutt) {
        int index = finnIndex(start, startParenteser);

        return slutt == sluttParenteser.charAt(index);
    }

    private static int finnIndex(char c, String parenteser) {
        for (int i = 0; i < parenteser.length(); i++) {
            if (c == parenteser.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
