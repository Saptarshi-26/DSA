package functional_programimg;

public class Method_Reference_Example1 {
    public static void main(String[] args) {
        Thread t = new Thread(Method_Reference_Example1:: print_message);
        t.start();
    }
    public static void print_message(){
        System.out.println("Message printed");
    }
}
