package main;

import java.util.Random;

public class Util {
    
    public String chooseRandomColor(){
        int randomColor = new Random().nextInt(3);
        switch (randomColor){
            case 0:
                return "Blond";
            case 1:
                return "Black";
            default:
                return "Ginger";
        }
    }
}
