package main.park;

import main.beasts.Beast;
import main.people.Customer;

public abstract class Attraction {
    private String name;
    protected double price;
    protected Beast attractionBeast;
    protected int visits;
    
    public Attraction(Beast attractionBeast){
        this.attractionBeast = attractionBeast;
        this.name = this.attractionBeast.getName();
        this.price = this.attractionBeast.getBeastPrice();
    }
    public void runAttraction(Park park){
        Customer currentCustomer = park.customersQueue.poll();
        this.attractionBeast.performMainTrick(currentCustomer);
        park.customersQueue.add(currentCustomer);
        park.budget += this.price;
        this.visits++;
    }

    public int getVisits() {
        return visits;
    }
    public String toString(){
        return this.name + ", Price: " + this.price + ", Visits: " + this.visits;
    }
}
