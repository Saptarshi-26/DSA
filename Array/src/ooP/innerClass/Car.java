package ooP.innerClass;

public class Car {
    private String model;
    private boolean isEngineon;
    Car(String model){
        this.model=model;
        isEngineon=false;
    }
    class Engine{
        void start(){
            if(!isEngineon){
                isEngineon=true;
                System.out.println(model+"Engine has started");
            }
            else System.out.println(model+"Engine is already on ");
        }
        void stop(){
            if(isEngineon){
                isEngineon=false;
                System.out.println(model+"Engine has been turned off");
            }
            else System.out.println(model+"Engine is already off");
        }
    }
}
