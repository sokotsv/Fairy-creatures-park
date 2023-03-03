package main.beasts;

import main.items.Jewellery;
import main.people.Customer;

public class Dwarf extends EarthBeast{
    private final String[] beastNames = {"Pantoran", "Selkath", "Skakoan", "Tholothian", "Zeltron", "Zygerrian"};
    public Dwarf(int age) {
        super("Dwarf", age, 107);
        super.setRandomName(this.beastNames);
    }

    @Override
    public void performMainTrick(Customer customer) {
        Jewellery jewellery = new Jewellery();
        customer.addToPocket(jewellery);
        System.out.println(customer.getName() + ", here you are your jewellery.");
    }
}
