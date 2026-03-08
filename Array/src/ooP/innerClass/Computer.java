package ooP.innerClass;

public class Computer {
    private String brand;
    private String model;
    private OperatingSystem os;
    public OperatingSystem getOs() {
        return os;
    }
   public static class USB{// static inner class
       private String type;

       public USB(String type) {
           this.type = type;
       }
       void display(){
           System.out.println("USB of type "+type);
       }
   }
    public Computer(String brand, String model, String osName) {
        this.brand = brand;
        this.model = model;
        this.os=new OperatingSystem(osName);
    }
    class OperatingSystem{// member  inner class
        private String osName;

        public OperatingSystem(String osName) {
            this.osName = osName;
        }
        public void display(){
            System.out.println("Computer Model "+model+" OS:"+ osName);
        }
    }
}
