package ooP;
import java.util.*;
public class ABC {

    ABC a;


    private  ABC(){}

    private static ABC object ;

    public static  ABC getObject(){

        if(object==null)object = new ABC();

        return object;

    }

}
