package main.beasts;

import main.items.Gem;
import main.people.Customer;

import java.util.Random;

public class Kraken extends WaterBeast{
    private int tentaclesLength;
    public Kraken(int age) {
        super("Kraken", age, 160);
        this.tentaclesLength = new Random().nextInt(10)+30-10;
    }

    @Override
    public void performMainTrick(Customer customer) {
        Gem gem = new Gem();
        customer.addToPocket(gem);
        System.out.println(customer.getName() + ", here you are a wonderful pearl");
    }
}
