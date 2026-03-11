package functional_programimg;

public class This_Reference_Example {
    public void do_process(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        do_process(10, (a) -> {
            System.out.println("Value of i is " + a);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {
        This_Reference_Example thisReferenceExample = new This_Reference_Example();
//        thisReferenceExample.do_process(10, new Process() {
//            @Override
//            public void process(int i) {
//                System.out.println("VaLue of i is " + i);
//                System.out.println(this);
//            }
//            public String toString(){
//                return "this is anonymous inner class ";
//            }
//        });

        thisReferenceExample.execute();

    }

    public String toString() {
        return "this is anonymous inner class ";
    }

}
