package main.park;

import main.beasts.Beast;
import main.people.Customer;

import java.util.ArrayList;
import java.util.Random;

public class ExtremeAttraction extends Attraction{
    protected static int elderWomanTakenFromDevils;
    protected static ArrayList<Customer> namesOfElderPeopleAshedFromDragons = new ArrayList<>();
    protected static ArrayList<Customer> drownFromMermaids = new ArrayList<>();
    
    public ExtremeAttraction(Beast attractionBeast) {
        super(attractionBeast);
    }
    public void runAttraction(Park park){
        System.out.println("This is the " + attractionBeast.getKind() + " - " + attractionBeast.getName() + " performing the tricks.");
        while (this.attractionQueue.size() > 0) {
            Customer currentCustomer = this.attractionQueue.poll();
            this.attractionBeast.performMainTrick(currentCustomer);
            if (this.chanceToSurvive()){
                park.customersQueue.add(currentCustomer);
            }
            else {
                if (attractionBeast.getKind().equals("Devil") && currentCustomer.getAge() > 55 && currentCustomer.getGender().equals("Female")){
                    elderWomanTakenFromDevils++;
                }
                if (attractionBeast.getKind().equals("Dragon") && currentCustomer.getAge() > 55){
                    namesOfElderPeopleAshedFromDragons.add(currentCustomer);
                }
                if (attractionBeast.getKind().equals("Mermaid")){
                    drownFromMermaids.add(currentCustomer);
                }
                attractionBeast.extremeReaction(park);
                this.dead++;
                park.numberOfWatchedAttractions++;
            }
            park.budget += this.price;
            attractionBeast.increaseProfit();
            super.visits++;
        }
    }
    public boolean chanceToSurvive(){
        int chance = new Random().nextInt(100);
        if (chance < 10){
            return false;
        }
        return true;
    }
}
