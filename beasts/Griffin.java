package main.beasts;

import main.Util;
import main.people.Customer;

import java.util.Random;

public class Griffin extends AirBeast{
    private int wingSize;
    private String maneColor;

    public Griffin(int age) {
        super("Griffin", age, 210);
        this.maneColor = new Util().chooseRandomColor();
        wingSize = new Random().nextInt(15)+25-15;
    }

    @Override
    public void performMainTrick(Customer customer) {
        System.out.println(customer.getName() + ", come ride me in the sky!");
    }
}
