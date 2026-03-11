package ooP.Humans;
import ooP.Birds;
import ooP.Penguins;

import java.util.*;
public class Test {

    public static void main(String[] args) {
        Birds penguin = new Penguins("Pearl of the Penguin ");
        Penguins penguin2= (Penguins) penguin;
        penguin2.colour();
        System.out.println(penguin2.name);

    }
}
