package no.hvl.dat102.sortering;

import static no.hvl.dat102.sortering.Oppgave2.*;

public class Oppgave2b {
    public static void main(String[] args) {
        final int ANTALL_TABELLER = 10;
        final int STORRELSE = 128000;

        Integer[][] testArr = new Integer[ANTALL_TABELLER][STORRELSE];

        for (int i = 0; i < ANTALL_TABELLER; i++) {
            for (int j = 0; j < STORRELSE; j++) {
                testArr[i][j] = 1;
            }
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < ANTALL_TABELLER; i++) {
            kvikksorter(testArr[i]);
        }
        long slutt = System.currentTimeMillis();

        long tidTatt = slutt - start;

        System.out.println("Gjennomsnittelig tid tatt med kvikksortering av lik tabell: " + tidTatt / ANTALL_TABELLER + "ms");
    }
}
