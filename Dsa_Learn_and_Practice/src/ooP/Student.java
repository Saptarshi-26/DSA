package ooP;

public class Student {
    public static int count ; // not depends on or related to any object , its ine copy is
    // shared by everyone
    public Student(){
        count++; // on creating each object this will keep incrementing
    }
    // static block
    static { // one time set up
        count=0;
    }
    private int id;
    private String name;

    public static void getCount() {
        System.out.println("Total student are :"+count);
    }

    public static void setCount(int count) {
        Student.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
