package test;

import static org.junit.jupiter.api.Assertions.*;

import no.hvl.dat102.binarytree.KjedetBSTre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KjedetBSTreADTTest {

    private KjedetBSTre<Integer> bs;
    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;
    private Integer e4 = 5;
    private Integer e5 = 6;
    private Integer e6 = 7;


    private Integer e7 = 8;


    @BeforeEach
    public final void setup() {
        bs = new KjedetBSTre<>();
    }


    @Test
    public final void erElementIBSTre() {

        bs.leggTil(e0);
        bs.leggTil(e1);
        bs.leggTil(e2);
        bs.leggTil(e3);
        bs.leggTil(e6);

        assertEquals(e0, bs.finn(e0));
        assertEquals(e1, bs.finn(e1));
        assertEquals(e2, bs.finn(e2));
        assertEquals(e3, bs.finn(e3));
        assertEquals(e6, bs.finn(e6));

        assertNull(bs.finn(e7));
    }


    @Test
    public final void erBSTreOrdnet() {
        bs.leggTil(e4);
        bs.leggTil(e2);
        bs.leggTil(e7);
        bs.leggTil(e1);
        bs.leggTil(e5);

        assertEquals(e1, bs.fjernMin());
        assertEquals(e2, bs.fjernMin());
        assertEquals(e4, bs.fjernMin());
        assertEquals(e5, bs.fjernMin());
        assertEquals(e7, bs.fjernMin());
    }


    @Test
    public final void erBSTreOrdnet2() {
        bs.leggTil(e3);
        bs.leggTil(e2);
        bs.leggTil(e4);
        bs.leggTil(e1);
        bs.leggTil(e5);
        bs.leggTil(e0);
        bs.leggTil(e6);

        Integer[] el = { e0, e1, e2, e3, e4, e5, e6 };
        int i = 0;
        for (Integer e : bs) {
            assertEquals(el[i], e);
            i++;
        }

    }

}