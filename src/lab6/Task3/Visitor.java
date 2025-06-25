package lab6.Task3;

import java.time.LocalTime;

public class Visitor {
    String name;
    LocalTime arrivalTime;
    boolean hasReservation;

    public Visitor(String name, LocalTime arrivalTime, boolean hasReservation) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.hasReservation = hasReservation;
    }
}
