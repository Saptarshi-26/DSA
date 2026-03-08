package ooP;

import ooP.Humans.Child;
import ooP.Humans.Parent;
import ooP.Humans.Grandparent;

public class Test {
    public static void main(String[] args) {
//        Child child = new Child("Male");
////        child.setName("Naruto");
////        child.setAge(12);
////        Parent parent = new Parent();
////        parent.setAge(30);
////        parent.setName("Minato");
//
//
//        Grandparent Grandchild = new Child();
////Understanding runtime polymorphism
//
//        //Here only Grandchild can access and operate the functions that are already defines in Grandparent
        // class, and it can override if it has same function
        //But it cannot call any function that in only in the child class
        //reason --> although the object will be created of a child class but thje reference will be of Grandparent
        //class

//        Child ch = (Child)Grandchild;
//       ch.eats_chocolate();// only in Child class
//        // Here we are down casting ch with Grandchild

  //Animal animal = new Animal(); this cannot happen
//        Animal dog = new Dog();
//        dog.sayhello();
//
//        ABC.getObject();
//


        Student student= new Student();
        Student student1 = new Student();
        System.out.println(Student.count);
        Student.getCount();

        Test test = new Test();
        test.sayhello();
    }

    public void sayhello(){
        System.out.println("Hello");
    }


}
