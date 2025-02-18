package no.hvl.dat102.sortering;

public class Oppgave1 {
    public static void main(String[] args) {
        final int STORRELSE = 75000;
        final int ANTALL_TABELLER = 10;

        Integer[][] testArr = new Integer[ANTALL_TABELLER][STORRELSE];

        for (int i = 0; i < testArr.length; i++) {
            for (int j = 0; j < testArr[i].length; j++) {
                testArr[i][j] = (int)(Math.random() * 1000);
            }
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < testArr.length; i++) {
            sorterVedInnsetting(testArr[i]);
        }
        long slutt = System.currentTimeMillis();
        long tidTatt = slutt - start;

        System.out.println("Gjennomsnittelig tid tatt med vanlig metode: " + tidTatt / ANTALL_TABELLER + "ms");

        /* ------------------------------------------------------------------------ */

        for (int i = 0; i < testArr.length; i++) {
            for (int j = 0; j < testArr[i].length; j++) {
                testArr[i][j] = (int)(Math.random() * 1000);
            }
        }

        start = System.currentTimeMillis();
        for (int i = 0; i < testArr.length; i++) {
            sorterVedInnsettingFikset(testArr[i]);
        }
        slutt = System.currentTimeMillis();
        tidTatt = slutt - start;
        System.out.println("Gjennomsnittelig tid tatt med modifisert metode: " + tidTatt / ANTALL_TABELLER + "ms");
    }

    public static <T extends Comparable<? super T>> void sorterVedInnsettingFikset(T[] a) {
        // Flytte minste elementet først i tabellen
        T min = a[0];
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
                minIndex = i;
            }
        }

        for (int i = minIndex; i > 0; i--) {
            T temp = a[i - 1];
            a[i - 1] = a[i];
            a[i] = temp;
        }

        for (int i = 1; i <= a.length - 1; i++) {

            T temp = a[i];
            int j = i - 1;

            // finn rett plass
            while (temp.compareTo(a[j]) < 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a) {
        for (int i = 1; i <= a.length - 1; i++) {

            T temp = a[i];
            int j = i - 1;

            // finn rett plass
            while (j >= 0 && temp.compareTo(a[j]) < 0) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = temp;
        }
    }
}
