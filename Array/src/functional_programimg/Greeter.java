package functional_programimg;
public class Greeter {
    void greet(Greeting greeting){
        greeting.perform();
    }
    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        HelloWorld helloWorld = new HelloWorld();
       // greeter.greet(helloWorld);
         Greeting lamdaGreeting = ()-> System.out.println("Hello Greeting ");
        // lamdaGreeting.perform();

         Greeting inlinClass = new Greeting() {
             @Override
             public void perform() {
                 System.out.println("Hello Greeting Inline ");
             }
         };
         greeter.greet(inlinClass);
         greeter.greet(lamdaGreeting);
    }

}
