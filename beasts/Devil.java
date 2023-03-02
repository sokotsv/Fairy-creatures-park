package main.beasts;

import main.park.Park;
import main.people.Customer;

public class Devil extends EarthBeast{
    public Devil(int age) {
        super("Devil", age, 200);
    }

    @Override
    public void performMainTrick(Customer customer) {
        System.out.println(customer.getName() + ", say your wish");
        String customerWish = customer.wish();
        System.out.println(customerWish);
        if (customerWish.equals("I wish to be young again.")){
            customer.getYoung();
        }
        System.out.println("Let your will be done!");
    }

    @Override
    public void extremeReaction(Park park) {
        System.out.println("***** YOUR SOUL IS MINE NOW! *****");
    }
}
