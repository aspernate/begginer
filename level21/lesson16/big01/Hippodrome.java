package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by riabov on 28.07.16.
 */
public class Hippodrome {
    ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse horseOne = new Horse("Mustang", 3, 0);
        Horse horseTwo = new Horse("Spoon", 3, 0);
        Horse horseThree = new Horse("Fakel", 3, 0);
        game.getHorses().add(horseOne);
        game.getHorses().add(horseTwo);
        game.getHorses().add(horseThree);
        game.run();
        game.printWinner();
    }

    public void run(){
        for(int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }

    public void move(){
        for(Horse h: horses) {
            h.move();
        }
    }

    public void print(){
        for(Horse h: horses) {
            h.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        Horse winnerHorse = null;
        for(Horse h: horses) {
            if(winnerHorse == null) {
                winnerHorse = h;
            }
            if(h.getDistance() > winnerHorse.getDistance()) {
                winnerHorse = h;
            }
        }
        return winnerHorse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
