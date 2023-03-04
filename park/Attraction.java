package main.park;

import main.beasts.Beast;
import main.people.Customer;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public abstract class Attraction {
    protected String name;
    protected double price;
    protected Beast attractionBeast;
    protected int visits;
    protected Queue<Customer> attractionQueue = new LinkedList<>();
    protected static int attractionIndex = 1;
    protected int attractionNumber;
    
    public Attraction(Beast attractionBeast){
        this.attractionBeast = attractionBeast;
        this.name = this.attractionBeast.getName();
        this.price = this.attractionBeast.getBeastPrice();
        this.attractionNumber = attractionIndex++;        
    }
    public void runAttraction(Park park){
        System.out.println("This is the " + attractionBeast.getKind() + " - " + attractionBeast.getName() + " performing the tricks.");
        while (this.attractionQueue.size() > 0) {
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
        return "No " + this.attractionNumber + " " + this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return attractionNumber == that.attractionNumber && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attractionNumber);
    }
}
