package exam_practice;

import java.util.Scanner;

interface bank{
    final int interest = 9;
    int calInterest(int amount);
}
class acount{
    String savings;
    int amount;
    int input_amnt(){
        Scanner sc = new Scanner(System.in);
        return this.amount=sc.nextInt();
    }
    void inout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter ");
        this.savings=sc.next();
    }
    String getSavings(){
        return this.savings;
    }

}
public class baking extends acount implements bank{


    @Override
    public int calInterest(int amount) {
        return amount*interest*100;
    }

    public static void main(String[] args) {
        baking b = new baking();
        b.calInterest(b.input_amnt());
        b.inout();
        System.out.println(b.getSavings());

    }


}
