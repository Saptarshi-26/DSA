package ooP.innerClass.Puzzles;

public class Outer {
    class Inner {  // Member inner class
        void show() {
            System.out.println("Inside Inner class");
        }
    }

    static void staticMethod() {
        // Instantiate Inner class here (your challenge!)
       Outer outer = new Outer();
       Outer.Inner inner=outer.new Inner();
       inner.show();
    }
}

