package main.park;

import main.beasts.Beast;
import main.people.Customer;

import java.util.Random;

public class ExtremeAttraction extends Attraction{
    public static int ELDER_WOMEN_TAKEN_FROM_DEVILS;
    
    public ExtremeAttraction(Beast attractionBeast) {
        super(attractionBeast);
    }
    public void runAttraction(Park park){
        for (int i = 0; i < this.attractionQueue.size(); i++) {
            Customer currentCustomer = this.attractionQueue.poll();
            this.attractionBeast.performMainTrick(currentCustomer);
            if (this.chanceToSurvive()){
                park.customersQueue.add(currentCustomer);
            }
            else {
                if (attractionBeast.getKind().equals("Devil") && currentCustomer.getAge() > 55 && currentCustomer.getGender().equals("Female")){
                    ELDER_WOMEN_TAKEN_FROM_DEVILS++;
                }
                attractionBeast.extremeReaction(park);
                park.numberOfWatchedAttractions++;
            }
            park.budget += this.price;
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
