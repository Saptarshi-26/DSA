package ooP.innerClass;

public class Hotel {
    private String name;
    private int totalRooms;
    private int  ReservedRooms;

    public Hotel(String name, int totalRooms, int reservedRooms) {
        this.name = name;
        this.totalRooms = totalRooms;
        ReservedRooms = reservedRooms;
    }
    public void reservedRoom(String guestName, int noOfRooms){
        class ReservationValidator{
            boolean validate(){
                if(guestName==null||guestName.isBlank()){
                    System.out.println("Guest name cannot be empty ! ");
                    return false;
                }
                if(noOfRooms<0){
                    System.out.println("Number of rooms should be postive !");
                    return false;
                }
                if(ReservedRooms+noOfRooms>totalRooms){
                    System.out.println("Not enough rooms available");
                    return false;
                }
                return true;
            }
        }// local inner class inside a function
        ReservationValidator validator = new ReservationValidator();
        if(validator.validate()){
            ReservedRooms+=noOfRooms;
            System.out.println("Reservation confirmed "+ guestName+" for "+ noOfRooms);
        }
        else{
            System.out.println("Reservation failed ");
        }

    }
}
