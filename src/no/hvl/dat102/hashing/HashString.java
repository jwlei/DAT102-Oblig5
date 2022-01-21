package no.hvl.dat102.hashing;

public class HashString {
    public static void main(String[] args) {
        String bokstav = "ab";
        String tall = "123";

        System.out.println(bokstav + " - HashCode: " + bokstav.hashCode());
        System.out.println(tall + " - HashCode: " + tall.hashCode());
    }
}
