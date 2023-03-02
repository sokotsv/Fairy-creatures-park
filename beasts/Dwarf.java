package main.beasts;

import main.items.Jewellery;
import main.people.Customer;

public class Dwarf extends EarthBeast{
    public Dwarf(int age) {
        super("Dwarf", age, 107);
    }

    @Override
    public void performMainTrick(Customer customer) {
        Jewellery jewellery = new Jewellery();
        customer.addToPocket(jewellery);
        System.out.println(customer.getName() + ", here you are your jewellery.");
    }
}
