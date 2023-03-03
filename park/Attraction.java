package main.park;

import main.beasts.Beast;
import main.people.Customer;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Attraction {
    private String name;
    protected double price;
    protected Beast attractionBeast;
    protected int visits;
    protected Queue<Customer> attractionQueue = new LinkedList<>();
    
    public Attraction(Beast attractionBeast){
        this.attractionBeast = attractionBeast;
        this.name = this.attractionBeast.getName();
        this.price = this.attractionBeast.getBeastPrice();
    }
    public void runAttraction(Park park){
        System.out.println("This is the " + attractionBeast.getKind() + " - " + attractionBeast.getName() + " performing the tricks.");
        for (int i = 0; i < attractionQueue.size(); i++) {
            Customer currentCustomer = this.attractionQueue.poll();
            this.attractionBeast.performMainTrick(currentCustomer);
            park.customersQueue.add(currentCustomer);
            park.budget += this.price;
            this.visits++;
        }
    }

    public int getVisits() {
        return visits;
    }
    public String toString(){
        return this.name + ", Price: " + this.price + ", Visits: " + this.visits;
    }
}
