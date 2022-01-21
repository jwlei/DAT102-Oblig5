package no.hvl.dat102.heap;

public class KlientHaug {
    public static void main(String[] a) {
        int[] tab = { 300, 10, 30, 2, 100, 33, 1, 200, 18, 54 };
        TabellHaug<Integer> h1 = new TabellHaug<>();
        for (int value : tab) {
            h1.leggTilElement(value);
        }

        System.out.println("Verdier i tabellen er:");
        h1.skrivTab();
        System.out.println("\nHaugen i sortert rekkefølge:");
        while (!h1.erTom()) {
            Integer h = h1.fjernMinste();
            System.out.print(h + "  ");
        }
        System.out.println();
    }
}