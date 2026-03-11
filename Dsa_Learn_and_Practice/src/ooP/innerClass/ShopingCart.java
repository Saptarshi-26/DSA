package ooP.innerClass;

public class ShopingCart {
    private  double totaolamount;

    public ShopingCart(double totaolamount) {
        this.totaolamount = totaolamount;
    }
    public void processPayment(Payment paymentMethod){
     paymentMethod.pay(totaolamount);
    }


}
