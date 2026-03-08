package ooP;

import java.util.SortedMap;

public class Penguins extends Birds{
   public String name;
   public Penguins(){
      // System.out.println("Penguin constructor called ");
   }
   public Penguins(String name ){
       this.name=name;
       //System.out.println(this.name);
   }
    @Override
    public void fly(){
        System.out.println("it cannot fly ");
    }
    public void colour(){
        System.out.println("white and black in colour");
    }
}
