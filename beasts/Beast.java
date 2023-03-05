package main.beasts;

import main.park.Park;
import main.people.Customer;
import java.util.Random;

public abstract class Beast {
    protected String name;
    protected String type;
    protected String kind;
    private int age;
    protected double beastPrice;
    private double profit = 0;
    
    
    public Beast(String type, String kind, int age, double beastPrice){
        this.type = type;
        this.kind = kind;
        this.beastPrice = beastPrice;
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

    public String getType() {
        return type;
    }

    public void setRandomName(String[] namesList){
        int randomName = new Random().nextInt(namesList.length);
        this.name = namesList[randomName];
    }
    public void increaseProfit(){
        this.profit += this.beastPrice;
    }

    public double getProfit() {
        return profit;
    }

}
