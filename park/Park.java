package main.park;

import main.beasts.*;
import main.people.Adult;
import main.people.Child;
import main.people.Customer;
import main.people.Retire;

import java.util.*;

public class Park {
    private String name;
    private String address;
    protected Queue<Customer> customersQueue = new LinkedList<>();
    protected int numberOfWatchedAttractions;
    protected double budget = 0;
    private int children;
    private int parkCapacity = 100;
    public int goingExtremeAttraction = 0;
    public int goingNormalAttraction = 0;
    private Map<String, Map<String, ArrayList<Beast>>> beastsByProfit = new HashMap<>();
    
    private ArrayList<Attraction> normalAttractions = new ArrayList<>();
    private ArrayList<Attraction> extremeAttractions = new ArrayList<>();
    private Map<Attraction, Double> priceList = new HashMap<>();
    
    
    public Park(String name, String address){
        if (name != null){
            this.name = name;
        }
        if (address != null){
            this.address = address;
        }
        this.generateCustomers();
        this.generateAttractions();
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
        //System.out.println(customersQueue);
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
            priceList.put(normal1, normal1.price);
            normalAttractions.add(normal2);
            priceList.put(normal2, normal2.price);
            normalAttractions.add(normal3);
            priceList.put(normal3, normal3.price);
        }
        for (int i = 0; i < 2; i++) {
            Beast mermaid = new Mermaid(80);
            Beast devil = new Devil(1270);
            Beast dragon = new Dragon(380);
            Attraction extreme1 = new ExtremeAttraction(mermaid);
            Attraction extreme2 = new ExtremeAttraction(devil);
            Attraction extreme3 = new ExtremeAttraction(dragon);
            extremeAttractions.add(extreme1);
            priceList.put(extreme1, extreme1.price);
            extremeAttractions.add(extreme2);
            priceList.put(extreme2, extreme2.price);
            extremeAttractions.add(extreme3);
            priceList.put(extreme3, extreme3.price);
        }
    }
    public void printPriceList(){
        System.out.println("======== PRICE LIST ========");
        priceList.entrySet().forEach(entry -> {
            System.out.println("No " + entry.getKey().attractionNumber + " Attraction name: " + entry.getKey().attractionBeast.getKind() + " - " +  entry.getKey().name + " - Price: " + entry.getValue());
        });
    }
    public void chooseAttraction() {
        while (this.customersQueue.size() > 0) {
            Customer nextCustomer = this.customersQueue.poll();
            boolean chanceToGoExtreme = new Random().nextBoolean();
            if (nextCustomer.getAge() > 18 && chanceToGoExtreme) {
                int randomExtremeAttraction = new Random().nextInt(this.extremeAttractions.size());
                extremeAttractions.get(randomExtremeAttraction).attractionQueue.add(nextCustomer);
                this.goingExtremeAttraction++;
            } else {
                int randomNormalAttraction = new Random().nextInt(this.normalAttractions.size());
                normalAttractions.get(randomNormalAttraction).attractionQueue.add(nextCustomer);
                this.goingNormalAttraction++;
            }
        }
    }public void runAllAttractions(){
        for (int i = 0; i < this.extremeAttractions.size(); i++) {
            this.extremeAttractions.get(i).runAttraction(this);
        }
        for (int i = 0; i < this.normalAttractions.size(); i++) {
            this.normalAttractions.get(i).runAttraction(this);
        }
    }

    public void statistic1(){
        System.out.println("Number of children visited this park: " + children);
    }
    public void statistic2(){
        System.out.println("Total profit of the park: " + budget);
    }
    public void statistic3(){
        System.out.print("The most visited normal attraction is ");
        normalAttractions.stream()
                .sorted((o1, o2) -> o2.getVisits()- o1.getVisits())
                .limit(1)
                .forEach(o -> {
                    System.out.println(o + " visited " + o.visits + " times.");
                });
        System.out.print("The most visited extreme attraction is ");
        extremeAttractions.stream()
                .sorted((o1, o2) -> o2.getVisits()- o1.getVisits())
                .limit(1)
                .forEach(o -> {
                    System.out.println(o + " visited " + o.visits + " times.");
                });
    }
    public void statistic4(){
        System.out.println("The number of clients who does not survive is " + (parkCapacity - customersQueue.size()) + 
                "\nSurvived clients are " + customersQueue.size());
    }
    public void statistic5(){
        System.out.println("The number of the elder women taken from the devils is: " + ExtremeAttraction.elderWomanTakenFromDevils);
    }
    public void statistic6(){
        System.out.println("The names of elder people ashed from the dragons are: ");
        ExtremeAttraction.namesOfElderPeopleAshedFromDragons.forEach(element -> {
            System.out.println(element.getName() + " - " + element.getAge() + " years");
        });
    }
    public void statistic7(){
        int totalAge = 0;
        ArrayList<Customer> drownPeople = ExtremeAttraction.drownFromMermaids;
        for (int i = 0; i < drownPeople.size(); i++) {
            totalAge += drownPeople.get(i).getAge();
        }
        int averageAge = 0;
        if (drownPeople.size() != 0){
            averageAge = totalAge / drownPeople.size();   
        }
        System.out.println("The average age of people drown by the mermaids is: " + averageAge);
    }
    public void statistic8(){
        extremeAttractions.stream()
                .map(o -> o.attractionBeast)
                .filter(beast -> beast instanceof Dragon)
                .map(Dragon.class::cast)
                .sorted((d1, d2) -> d2.getVictims()-d1.getVictims())
                .limit(1)
                .forEach(element -> {
                    System.out.println("The most deadly dragon is: " + element.getName() + " with " + element.getVictims() + " victims.");
                });
    }
    private void fillBeastsByProfit(Park park){
        Beast beast;
        for (int i = 0; i < park.extremeAttractions.size(); i++) {
            beast = park.extremeAttractions.get(i).getAttractionBeast();
            if (!this.beastsByProfit.containsKey(beast.getType())){
                beastsByProfit.put(beast.getType(), new HashMap<>());
            }
            if (!this.beastsByProfit.get(beast.getType()).containsKey(beast.getKind())){
                beastsByProfit.get(beast.getType()).put(beast.getKind(), new ArrayList<Beast>());
            }
            beastsByProfit.get(beast.getType()).get(beast.getKind()).add(beast);
        }
        for (int i = 0; i < park.normalAttractions.size(); i++) {
            beast = park.normalAttractions.get(i).getAttractionBeast();
            if (!this.beastsByProfit.containsKey(beast.getType())){
                beastsByProfit.put(beast.getType(), new HashMap<>());
            }
            if (!this.beastsByProfit.get(beast.getType()).containsKey(beast.getKind())){
                beastsByProfit.get(beast.getType()).put(beast.getKind(), new ArrayList<Beast>());
            }
            beastsByProfit.get(beast.getType()).get(beast.getKind()).add(beast);
        }
    }
    public void statistic9(){
        fillBeastsByProfit(this);
        System.out.println("Park beasts by type, kind and profit:");
        for (Map.Entry<String, Map<String, ArrayList<Beast>>> b:beastsByProfit.entrySet()){
            System.out.println(b.getKey() + ": ");
            Map<String, ArrayList<Beast>> beastsByKind = b.getValue();
            for (Map.Entry<String, ArrayList<Beast>> b1 : beastsByKind.entrySet()){
                double price = 0;
                for (int i = 0; i < b1.getValue().size(); i++) {
                    price += b1.getValue().get(i).getProfit();
                }
                System.out.println("\t * " + b1.getKey() + " - " + price + "$");
            }
        }
    }
    public void statistic10(){
        int totalVisited = 0;
        int totalDead = 0;
        for (int i = 0; i < extremeAttractions.size(); i++) {
            totalVisited += extremeAttractions.get(i).visits;
            totalDead += extremeAttractions.get(i).dead;
        }
        double result = ((double) totalDead / (double) totalVisited) * 100;
        System.out.println("The risk ratio of the extreme attractions is: " + result);
    }
}
