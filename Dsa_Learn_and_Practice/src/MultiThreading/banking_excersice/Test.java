package MultiThreading.banking_excersice;

public class Test {
    public static void main(String[] args) {
        Account a= new Account(1,10000);
        Account a1= new Account(2,10000);
        Account a2= new Account(3,10000);
        Account a3= new Account(4,10000);

       Transfer_1 transfer = new Transfer_1();
        Thread t1 = new Thread(()->transfer.transfer(a,a1,150));
        Thread t2 = new Thread(()->transfer.transfer(a1,a,200));
        Thread t3 = new Thread(()->transfer.transfer(a3,a,709));
        Thread t4 = new Thread(()->transfer.transfer(a2,a3,709));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
