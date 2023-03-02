package main.people;

import java.util.Random;

public class Retire extends Customer{

    public Retire(int age) {
        super(age);
        this.paymentPercentage = 0.8;
    }
}
