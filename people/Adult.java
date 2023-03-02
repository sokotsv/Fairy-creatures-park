package main.people;

import java.util.Random;

public class Adult extends Customer{
    
    public Adult(int age) {
        super(age);
        this.paymentPercentage = 1;
    }
}
