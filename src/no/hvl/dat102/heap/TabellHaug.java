package no.hvl.dat102.heap;

public class TabellHaug<T extends Comparable<T>> {

    private T[] data;
    private int antall;

    private static final int STDK = 100;


    public TabellHaug() {
        data = (T[]) new Comparable[STDK];
        antall = 0;
    }

    public void leggTilElement(T el) {
        if (antall == data.length)
            utvidTabell();
        data[antall] = el;
        antall++;
        if (antall > 1)
            reparerOpp();
    }


    private void utvidTabell() {

        int lengde = data.length;
        T[] ny = (T[]) new Comparable[2 * lengde];
        if (antall >= 0) System.arraycopy(data, 0, ny, 0, antall);
        data = ny;
    }

    private void reparerOpp() {
        T hjelp;
        int neste = antall-1;

        hjelp = data[neste];
        while( (neste!=0) && (hjelp.compareTo(data[(neste-1)/2]) < 0)) {
            data[neste] = data[(neste-1)/2];
            neste = (neste-1)/2;
        }
        data[neste] = hjelp;
    }

    public T fjernMinste() {
        T svar = null;
        if (antall > 0) {
            svar = data[0];
            data[0] = data[antall - 1];
            reparerNed();
            antall--;
        }
        return svar;
    }

    public T finnMinste(){
        T svar = null;
        if (antall > 0) {
            svar = data[0];
        }
        return svar;
    }


    private void reparerNed() {
        T hjelp;
        boolean ferdig = false;
        int forelder = 0;
        int minbarn;
        int vbarn = forelder * 2 + 1;
        int hbarn = vbarn + 1;
        while ((vbarn < antall) && !ferdig) {
            minbarn = vbarn;

            if ((hbarn < antall) && ((data[hbarn]).compareTo(data[vbarn]) < 0))
                minbarn = hbarn;


            if ((data[forelder]).compareTo(data[minbarn]) <= 0)
                ferdig = true;
            else {
                hjelp = data[minbarn];
                data[minbarn] = data[forelder];
                data[forelder] = hjelp;
                forelder = minbarn;
                vbarn = forelder * 2 + 1;
                hbarn = vbarn + 1;
            }
        }
    }

    public boolean erTom() {
        return antall == 0;
    }

    public void skrivTab() {
        for (int i = 0; i < antall; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }
}
