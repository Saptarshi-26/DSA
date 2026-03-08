package functional_programimg;

public interface Greeting {
    void perform();
}
class HelloWorld implements Greeting{

    @Override
    public void perform() {
        System.out.println("Hello World Greeting ");
    }
}