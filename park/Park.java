package main.park;

import main.beasts.*;
import main.people.Adult;
import main.people.Child;
import main.people.Customer;
import main.people.Retire;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Park {
    private String name;
    private String address;
    protected Queue<Customer> customersQueue = new LinkedList<>();
    protected int numberOfWatchedAttractions;
    protected double budget = 0;
    private int children;
    private int parkCapacity = 100;
    
    private ArrayList<Attraction> normalAttractions = new ArrayList<>();
    private ArrayList<Attraction> extremeAttractions = new ArrayList<>();
    private int numberOfAshedFromDragons;
    
    public Park(String name, String address){
        if (name != null){
            this.name = name;
        }
        if (address != null){
            this.address = address;
        }
    }
    
    public void generateCustomers(){
        for (int i = 0; i < parkCapacity; i++) {
            Customer customer;
            int randomAge;
            int randomCustomer = new Random().nextInt(3);
            switch (randomCustomer){
                case 0:
                    randomAge = new Random().nextInt(9)+8;
                    customer = new Child(randomAge);
                    children++;
                    break;
                case 1:
                    randomAge = new Random().nextInt(37)+19;
                    customer = new Adult(randomAge);
                    break;
                default:
                    randomAge = new Random().nextInt(36)+56;
                    customer = new Retire(randomAge);
                    break;
            }
            customersQueue.add(customer);
        }
        System.out.println(customersQueue);
    }
    public void generateAttractions(){
        for (int i = 0; i < 3; i++) {
            Beast kraken = new Kraken(130);
            Beast griffin = new Griffin(270);
            Beast dwarf = new Dwarf(280);
            Attraction normal1 = new NormalAttraction(kraken);
            Attraction normal2 = new NormalAttraction(griffin);
            Attraction normal3 = new NormalAttraction(dwarf);
            normalAttractions.add(normal1);
            normalAttractions.add(normal2);
            normalAttractions.add(normal3);
        }
        for (int i = 0; i < 2; i++) {
            Beast mermaid = new Mermaid(80);
            Beast devil = new Devil(1270);
            Beast dragon = new Dragon(380);
            Attraction extreme1 = new ExtremeAttraction(mermaid);
            Attraction extreme2 = new ExtremeAttraction(devil);
            Attraction extreme3 = new ExtremeAttraction(dragon);
            extremeAttractions.add(extreme1);
            extremeAttractions.add(extreme2);
            extremeAttractions.add(extreme3);
        }
    }

    public ArrayList<Attraction> getNormalAttractions() {
        return normalAttractions;
    }

    public ArrayList<Attraction> getExtremeAttractions() {
        return extremeAttractions;
    }

    public void statistic1(){
        System.out.println("Number of children - " + children);
    }
    public void statistic2(){
        System.out.println("Profit: " + budget);
    }
    public void statistic3(){
        System.out.print("The most visited normal attraction is ");
        normalAttractions.stream()
                .sorted((o1, o2) -> o2.getVisits()- o1.getVisits())
                .limit(1)
                .forEach(o -> System.out.println(o));
        System.out.print("The most visited extreme attraction is ");
        extremeAttractions.stream()
                .sorted((o1, o2) -> o2.getVisits()- o1.getVisits())
//                .limit(1)
                .forEach(o -> System.out.println(o));
    }
    public void statistic4(){
        System.out.println("The number of clients who has not survive is " + (parkCapacity - customersQueue.size()) + 
                "\nSurvived clients are " + customersQueue.size());
    }
    public void statistic5(){
        System.out.println("The number of people ashed from the dragons is " + numberOfAshedFromDragons);
    }

    public Queue<Customer> getCustomersQueue() {
        return customersQueue;
    }

    public void increaseNumberOfAshedFromDragons() {
        this.numberOfAshedFromDragons++;
    }
}
