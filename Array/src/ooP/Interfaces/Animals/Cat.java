package ooP.Interfaces.Animals;

public class Cat implements Animal {
    @Override
    public void eats() {
        System.out.println("Cat is eating ");
    }

    @Override
    public void sleeps() {
        System.out.println("Cat is sleeping ");

    }
}
