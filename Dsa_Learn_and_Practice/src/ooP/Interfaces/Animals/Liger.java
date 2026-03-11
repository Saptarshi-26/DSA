package ooP.Interfaces.Animals;

public class Liger implements Tiger,Lion{


    @Override
    public void colour() {// if both implement same default function which interface
        // function will be called  has to be specified with super keyword
//        Tiger.super.colour();
//        Lion.super.colour();
        System.out.println("white with golden fur ");
    }
}
