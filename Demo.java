package main;

import main.park.Attraction;
import main.park.ExtremeAttraction;
import main.park.Park;
import main.people.Customer;

import javax.smartcardio.ATR;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Park krasiPark = new Park("Krasi`s Fantastic Beasts", "Bulgaria blvd.");
        
        Queue<Customer> customers = krasiPark.getCustomersQueue();
        System.out.println("********** Let's attractions begin!!! **********");
        for (int i = 0; i < 2; i++) {
            krasiPark.chooseAttraction();
            krasiPark.runAllAttractions();
        }
        
        System.out.println("****** Statistics *******");
        krasiPark.statistic1();
        krasiPark.statistic2();
        krasiPark.statistic3();
        krasiPark.statistic4();
        krasiPark.statistic5();
        System.out.println("The number of the elder women taken from the devils is: " + ExtremeAttraction.ELDER_WOMEN_TAKEN_FROM_DEVILS);
    }
}
