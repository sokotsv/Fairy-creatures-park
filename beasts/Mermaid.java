package main.beasts;

import main.Util;
import main.park.Park;
import main.people.Customer;

import java.util.Random;

public class Mermaid extends WaterBeast{
    private String hairColor;

    public Mermaid(int age) {
        super("Mermaid", age, 110);
        this.maxDeep = 100;
        this.hairColor = new Util().chooseRandomColor();
    }

    @Override
    public void performMainTrick(Customer customer) {
        System.out.println("\"Feel the magic under the moon\"\n" +
                "\"Come with me to the mermaid lagoon\"");
    }

    @Override
    public void extremeReaction(Park park) {
        System.out.println("***** NOW GOING TO THE DEEP! *****");
    }
}
