package main.beasts;

public abstract class AirBeast extends Beast{
    protected int maxSpeed;

    public AirBeast(String kind, int age, double beastPrice) {
        
        super("Air Beast", kind, age, beastPrice);
            }
}
