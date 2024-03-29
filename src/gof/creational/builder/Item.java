package gof.creational.builder;

public interface Item {
    public String name();
    public Packing packing();
    public float price();
}
interface Packing {
    public String pack();
}
