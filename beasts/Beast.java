package main.beasts;

import main.park.Park;
import main.people.Customer;

import java.util.Random;

public abstract class Beast {
    private final String[] beastNames = {"Unufri", "Mandle", "Slayer", "Fire Flyer", "Jonny", "Draculla"};
    private String name;
    protected String type;
    protected String kind;
    private int age;
    protected double beastPrice;
    
    
    public Beast(String type, String kind, int age, double beastPrice){
        this.type = type;
        this.kind = kind;
        this.beastPrice = beastPrice;
        int randomName = new Random().nextInt(beastNames.length);
        this.name = beastNames[randomName];
        if (age > 0){
            this.age = age;
        }
        
    }

    public double getBeastPrice() {
        return beastPrice;
    }
    public String toString(){
        return this.name + " " + this.type + " " + this.kind + " " + this.beastPrice + " " + this.age;
    }

    public String getName() {
        return name;
    }
    public abstract void performMainTrick(Customer customer);
    public void extremeReaction(Park park){}

    public String getKind() {
        return kind;
    }
}
