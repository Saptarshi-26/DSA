package exam_practice;

import java.util.Scanner;

interface Gross{
    int calculate_gross(int sal);
}
class Multiple_Inhertiace extends Salary implements Gross{
    String name ;
    long id;
    void input(){
        Scanner sc = new Scanner(System.in);
        this.name=sc.nextLine();
        this.id=sc.nextLong();
    }
    void display(){
        System.out.println(this.name+" "+this.id);
    }

    @Override
    public int calculate_gross(int sal) {
        return sal*19373+87474;
    }

    public static void main(String[] args) {
        Multiple_Inhertiace obj = new Multiple_Inhertiace();
        obj.a();
        int sal= sal();
        System.out.println(obj.calculate_gross(sal));

    }
}
class Salary {
    int a ;
    int a(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the a");
        this.a=sc.nextInt();
        return this.a;
    }
  static int sal(){
       int sal;
       Scanner sc = new Scanner(System.in);
      System.out.println("enter the salary");
      return sc.nextInt();
   }

}

