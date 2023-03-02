package main.people;

import main.Util;
import main.items.Item;

import java.util.Random;
import java.util.Stack;

public abstract class Customer {
    private final String[] firstNames = {"Charles", "Donald", "Mickey", "Dean", "Sammy", "Rose", "Stephan"};
    private final String[] lastNames = {"Armstrong", "Mohhamad", "Johnson", "Stevenson", "Lennon"};
    private final String[] wishes = {"to get well.", "my beloved to fall in love with me.", "to have luck.", "to be rich.", "to be strong."};
    
    private String name;
    protected int age;
    private String gender;
    protected double paymentPercentage;
    private Stack<Item> pocket = new Stack<Item>();
    
    public Customer(int age){
        int randomFirstName = new Random().nextInt(firstNames.length);
        int randomLastName = new Random().nextInt(lastNames.length);
        this.name = firstNames[randomFirstName] + " " + lastNames[randomLastName];
        this.paymentPercentage = 100;
        int randomGender = new Random().nextInt(2);
        if (randomGender == 0){
            this.gender = "Female";
        }
        else {
            this.gender = "Male";
        }
        if (age > 7 && age < 92){
            this.age = age;
        }
        else {
            this.age = 50;
        }
    }

    @Override
    public String toString() {
        return "\n" + name + ", " + age + " years: " + " " + gender + ", payPercent: " + paymentPercentage;
    }


    public void addToPocket(Item gift){
        pocket.push(gift);
    }
    public String wish(){
        boolean chanceToWishYouth = new Random().nextBoolean();
        if (this.age > 60 && chanceToWishYouth){
            return "I wish to be young again.";
        }
        else {
            int randomWish = new Random().nextInt(wishes.length);
            return "I wish " + wishes[randomWish];
        }
    }
    public void getYoung(){
        this.age = 10;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
}

