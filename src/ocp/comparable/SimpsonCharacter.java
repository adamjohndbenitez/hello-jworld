package ocp.comparable;

public class SimpsonCharacter implements Comparable<SimpsonCharacter> {
    private String name;

    public SimpsonCharacter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(SimpsonCharacter simpson) {
        return this.name.compareTo(simpson.name);
    }
}