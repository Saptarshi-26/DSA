package ooP.Humans;

public class Child extends Parent{
    String sex;
    public Child(){
        System.out.println("Child constructor called ");

    }
   public Child(String sex){
       System.out.println("parameterised child constructor called ");
       this.sex=sex;
       System.out.println(sex);


    }
    public void eats_chocolate()
    {
        System.out.println("Eating chocolate");
    }

}
