package exam_practice;
import java.util.*;
class Exceptionhanling {
    static void age_check(int age ) throws ArithmeticException {
        if(age <18){
            throw new ArithmeticException("under age ");
        }
        else{
            System.out.print("eligible ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        System.out.print("divident ");
        int a = sc.nextInt();
        System.out.print("enter divisor ");
        int b = sc.nextInt();

        try{
            System.out.print(a/b);
        }
        catch(ArithmeticException e ){
            System.out.print("not divisible by zero ");
        }
        finally{
            System.out.print("finaly block executed ");
        }
        age_check(age);

    }
}

