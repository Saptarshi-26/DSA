import java.util.*;
public class Power_x_n {
    public static double myPow(double x, int n) {
        if(n==1)return x;
        double t =1;
        if(n%2!=0)t=x;
        double p=myPow(x,(n/2));
        return t*p*p;
    }
    public static double power(double x , int n){
        if(n==1) return (1/x);
        double t=(n%2!=0)?(1/x):1;
        double p=power(x,(n/2));
        return p*p*t;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number ");
        double x = sc.nextDouble();
        System.out.println("Enter the power ");
        int n= sc.nextInt();
        if(n==0) System.out.println(1);
        if(n>=0) {
            System.out.println(myPow(x, n));
        }
        else System.out.println(power(x,(-1*n)));

    }
}
