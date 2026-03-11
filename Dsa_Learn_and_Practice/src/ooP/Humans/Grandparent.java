package ooP.Humans;

public class Grandparent {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Grandparent() {
        System.out.println("Grandparent constrcutor called ");
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
