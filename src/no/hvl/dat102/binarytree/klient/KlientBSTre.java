package no.hvl.dat102.binarytree.klient;

import no.hvl.dat102.binarytree.KjedetBSTre;
import java.util.Random;

public class KlientBSTre {

    public static void main(String[] args) {
        int noder = 8192;
        int antallTre = 100;

        Random random = new Random();

        int minHoyde = Integer.MAX_VALUE;
        int maksHoyde = Integer.MIN_VALUE;
        int avgHoyde = 0;

        for (int i = 0; i < antallTre; i++) {
            KjedetBSTre<Integer> tre = new KjedetBSTre<>();

            for (int j = 0; j < noder; j++) {
                tre.leggTil(random.nextInt());
            }

            int hoyde = tre.hoyde();
            minHoyde = Math.min(minHoyde, hoyde);
            maksHoyde = Math.max(maksHoyde, hoyde);
            avgHoyde += hoyde;
        }
        avgHoyde = avgHoyde/antallTre;

        // i
        System.out.println("Antall noder: " + noder);
        // ii
        System.out.println("Teoretisk minimumshøyde: " + KjedetBSTre.teoretiskMinHoyde(noder));
        // iii
        System.out.println("Teoretisk maksimumshøyde: " + KjedetBSTre.teoretiskMaksHoyde(noder));
        // iv
        System.out.println("MIN høyde: " + minHoyde);
        // v
        System.out.println("MAX høyde: " + maksHoyde);
        // vi
        System.out.println("Gjennomsnittshøyde: " + avgHoyde);
    }



}