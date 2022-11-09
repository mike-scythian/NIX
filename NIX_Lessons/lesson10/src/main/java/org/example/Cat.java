package org.example;


import java.util.Random;

public class Cat extends Predator{

    private String breed;

    protected void toSleep() {

        System.out.println("Murrrrr\nMurrrr\nMurrrrr");

    }

    protected String toHunt() {

        boolean huntResult = new Random().nextBoolean();

        return huntResult ? "Prey" : "Uhrrrr";
    }
    public void tigidykSkill(int number){

        for(int i=0; i < number; i++)
            System.out.println("TIGIDYK\n");
    }
    public void superPower(){


    }
}
