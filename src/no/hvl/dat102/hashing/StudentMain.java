package no.hvl.dat102.hashing;

public class StudentMain {
    public static void main (String[] args) {
        Student a = new Student(10,"Ole");
        Student b = new Student(10, "Ole");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }
}
