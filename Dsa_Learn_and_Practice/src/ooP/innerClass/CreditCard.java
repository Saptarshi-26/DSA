package ooP.innerClass;

public class CreditCard implements Payment{
    private String creditCardno;

    public CreditCard(String creditCardno) {
        this.creditCardno = creditCardno;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" using Credit Card");
    }
}
