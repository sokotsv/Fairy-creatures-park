package main.beasts;

import main.Util;
import main.park.Park;
import main.people.Customer;

import java.util.Random;

public class Mermaid extends WaterBeast{
    private final String[] beastNames = {"Naia", "Naida", "Nerida", "Nerissa", "Nixie", "Ondine", "Pearl"};
    private String hairColor;

    public Mermaid(int age) {
        super("Mermaid", age, 110);
        this.maxDeep = 100;
        this.hairColor = new Util().chooseRandomColor();
        super.setRandomName(this.beastNames);
        this.maxDeep = 300;
    }

    @Override
    public void performMainTrick(Customer customer) {
        System.out.println(customer.getName() + " I will sing for you:");
        System.out.println("\"Feel the magic under the moon\"\n" +
                "\"Come with me to the mermaid lagoon\"");
    }

    @Override
    public void extremeReaction(Park park) {
        System.out.println("***** NOW GOING TO THE DEEP! *****");
    }
}
