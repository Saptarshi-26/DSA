package functional_programimg;

public class Method_Reference {
    public static void main(String[] args) {
        Thread t = new Thread(Method_Reference:: print_message);
        t.start();
    }
    public static void print_message(){
        System.out.println("Message printed");
    }
}
