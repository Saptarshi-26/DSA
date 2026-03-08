package ooP.innerClass;

public class Test {
    public static void main(String[] args) {
//        Car car = new Car("Bugatti");
//        Car.Engine engine = car.new Engine();
//        engine.start();
//        engine.stop();
//        Computer computer = new Computer("HP","poly studio", "rizen 7");
//        computer.getOs().display();// os in the object of the class hence we are able to use the returned
//        // os to call the display function of Operatingsyatem class as os is the object for
//        // the operatingsystem class
//        Computer.USB usb = new Computer.USB("Type C");// no matter how many Computer object
//        // only fixed number of usb

//        ShopingCart shopingCart = new ShopingCart(150);
////        CreditCard creditCard = new CreditCard("3232");
////        shopingCart.processPayment(creditCard);
//
//        shopingCart.processPayment(new Payment() {// in this system a anonymus class object is created
//            @Override                            // just for using the reference of interface
//            public void pay(double amount) {
//                System.out.println("Paid "+amount+" using Credit Card");
//            }
//        });

        Hotel hotel = new Hotel("Taj",10,5);
        hotel.reservedRoom("Boruto ",1);


    }

}
