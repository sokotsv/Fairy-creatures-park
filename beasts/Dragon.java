package main.beasts;

import main.items.Gem;
import main.items.Item;
import main.park.Park;
import main.people.Customer;

import java.util.Stack;

public class Dragon extends AirBeast{
    private Stack<Gem> treasure = new Stack<Gem>(); 
    public Dragon(int age) {
        super("Dragon", age, 150);
        this.generateTreasure();
    }
    
    public void generateTreasure(){
        for (int i = 0; i < 1000; i++) {
            Gem gem = new Gem();
            treasure.push(gem);
        }
    }

    @Override
    public void performMainTrick(Customer customer) {
        customer.addToPocket(treasure.pop());
        System.out.println(customer.getName() + ", take this precious gem!");
    }

    @Override
    public void extremeReaction(Park park) {
        System.out.println("***** I WILL TURN YOU TO ASHES, YOU BASTARD! *****");
        
    }
}
