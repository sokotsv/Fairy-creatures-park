package main.beasts;

import main.items.Pearl;
import main.people.Customer;

import java.util.Random;
import java.util.Stack;

public class Kraken extends WaterBeast{
    private int tentaclesLength;
    private final String[] beastNames = {"Loch Ness", "Hydra", "Leviathan", "Oarfish"};
    private Stack<Pearl> pearls = new Stack<>();
    public Kraken(int age) {
        super("Kraken", age, 160);
        this.tentaclesLength = new Random().nextInt(10)+30-10;
        super.setRandomName(this.beastNames);
        this.maxDeep = 1000;
        this.generatePearls();
    }
    public void generatePearls(){
        for (int i = 0; i < 1000; i++) {
            Pearl pearl = new Pearl();
            pearls.push(pearl);
        }
    }

    @Override
    public void performMainTrick(Customer customer) {
        Pearl pearl = new Pearl();
        customer.addToPocket(pearl);
        System.out.println(customer.getName() + ", here you are a wonderful pearl");
    }
}
