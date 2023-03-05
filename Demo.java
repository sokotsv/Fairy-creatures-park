package main;

import main.park.Park;

public class Demo {
    public static void main(String[] args) {
        Park krasiPark = new Park("Krasi`s Fantastic Beasts", "Bulgaria blvd.");
        
        krasiPark.printPriceList();
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
        krasiPark.statistic6();
        krasiPark.statistic7();
        krasiPark.statistic8();
        krasiPark.statistic9();
        krasiPark.statistic10();
    }
}
