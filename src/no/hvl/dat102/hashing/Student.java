package no.hvl.dat102.hashing;

public class Student {
    private int snr;
    private String name;

    public Student(int snr, String name){
        this.snr = snr;
        this.name = name;
    }

    @Override
    public int hashCode(){
        int result = snr ^ snr >>> 31;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }

        Student second = (Student) object;
        return (snr == second.snr) && (name.equals(second.name));
    }
}
