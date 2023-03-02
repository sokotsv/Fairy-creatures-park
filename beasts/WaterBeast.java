package main.beasts;

public abstract class WaterBeast extends Beast{
    protected int maxDeep;

    public WaterBeast(String kind, int age, double beastPrice) {
        super("Water Beast", kind, age, beastPrice);
    }
}
