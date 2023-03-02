package main.people;

import java.util.Random;

public class Child extends Customer{

    public Child(int age) {
        super(age);
        this.paymentPercentage = 0.5;
    }
}
