package ooP.Interfaces.Animals;

public interface Animal {
    public static final int Max_age=25;// public static final already predefined
    // as interface can only have static constant
    public  String name="";
    public abstract void eats();
    void sleeps(); // public abstract already inbuilt
    public static void info(){
        System.out.println("This is an Animal interface ");
    }
    default void run(){ // for only objects
        this.eats();
        System.out.println("Animal is running ");
    }
}
