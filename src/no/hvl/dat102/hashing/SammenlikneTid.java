package no.hvl.dat102.hashing;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Random;

public class SammenlikneTid {
    public static void main(String[] args) {
        int antElement = 100000;

        Integer[] integers = new Integer[antElement];
        HashSet<Integer> integerHashSet = new HashSet<>();

        int tall = 376;
        for (int i = 0; i < antElement; i++) {
            integerHashSet.add(tall);
            integers[i] = tall;
            tall = (tall+45713) % 1000000;
        }

        int[] search = new int[10000];
        Random random = new Random();
        for(int i = 0; i < search.length; i++) {
            search[i] = random.nextInt(1000000);
        }


        int counter = 0;
        Instant start = Instant.now();
        for (int value : search) {
            if (integerHashSet.contains(value)) {
                counter++;
            }
        }
        Instant finish = Instant.now();
        long elapsedTime = Duration.between(start,finish).toMillis();


        System.out.println("HashSet\nTid: " + elapsedTime + "ms.\nAntall treff: " + counter);


        Arrays.sort(integers);
        counter = 0;
        start = Instant.now();
        for (int value : search) {
            int result = Arrays.binarySearch(integers, value);
            if (result > -1) {
                counter++;
            }
        }
        finish = Instant.now();
        elapsedTime = Duration.between(start, finish).toMillis();


        System.out.println("Integer array\nTid: " + elapsedTime + "ms.\nAntall treff: " + counter);


    }
}
