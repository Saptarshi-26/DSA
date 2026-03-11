package ooP.enum_demo;

public enum Day {
    SUNDAY,MONDAY,TUESDAY,WENESDAY,THURSDAY,FRIDAY; // These are instances of Day
    // in compile time Day is a class
    //COMPILE TIME CODE :-
//    public final class Day extends java.lang.Enum<Day> {
//        public static final Day SUNDAY = new Day("SUNDAY", 0);
//        public static final Day MONDAY = new Day("MONDAY", 1);
//        public static final Day TUESDAY = new Day("TUESDAY", 2);
//        public static final Day WEDNESDAY = new Day("WEDNESDAY", 3);
//        public static final Day THURSDAY = new Day("THURSDAY", 4);
//        public static final Day FRIDAY = new Day("FRIDAY", 5);
//        public static final Day SATURDAY = new Day("SATURDAY", 6);
//
//        private static final Day[] VALUES = { SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY };
//
//        private Day(String name, int ordinal) {
//            super(name, ordinal);
//        }
//
//        public static Day[] values() {
//            return VALUES.clone();
//        }
//
//        public static Day valueOf(String name) {
//            for (Day day : VALUES) {
//                if (day.name().equals(name)) {
//                    return day;
//                }
//            }
//            throw new IllegalArgumentException("No enum constant " + name);
//        }
//    }


    //the days are in then form of String according to their indexes

    public void display(){
        System.out.println(this.name());
    }
}
