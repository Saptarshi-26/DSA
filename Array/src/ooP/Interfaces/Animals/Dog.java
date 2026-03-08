package ooP.Interfaces.Animals;

public class Dog implements Animal {
    @Override
    public void eats() {
        System.out.println("Dog is eating ");
    }

    @Override
    public void sleeps() {
        System.out.println("Dog is sleeping ");
    }

    public void run() {
        System.out.println("Runs at 30km/ph");
    }
}
