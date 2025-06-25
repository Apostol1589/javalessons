package lab6.Task3;

import java.util.*;
import java.time.LocalTime;

public class Cafe {
    private final int totalTables;
    private int occupiedTables = 0;

    private final Queue<Visitor> waitingQueue = new LinkedList<>();
    private final List<Visitor> seatedVisitors = new ArrayList<>();
    private final Map<String, LocalTime> reservations = new HashMap<>();

    public Cafe(int totalTables) {
        this.totalTables = totalTables;
    }

    public void reserveTable(String name, LocalTime time) {
        reservations.put(name, time);
        System.out.println("Столик зарезервовано для " + name + " на " + time);
    }

    public void arrive(String name, LocalTime arrivalTime) {
        System.out.println(name + " прийшов о " + arrivalTime);

        if (reservations.containsKey(name) && reservations.get(name).equals(arrivalTime)) {
            if (occupiedTables < totalTables) {
                seatVisitor(new Visitor(name, arrivalTime, true));
            } else {
                // Виштовхуємо першого з черги, якщо треба
                Optional<Visitor> removed = Optional.ofNullable(waitingQueue.poll());
                removed.ifPresent(v -> System.out.println("Відвідувача " + v.name + " витіснено через бронювання"));
                seatVisitor(new Visitor(name, arrivalTime, true));
            }
        } else if (occupiedTables < totalTables) {
            seatVisitor(new Visitor(name, arrivalTime, false));
        } else {
            System.out.println("Немає вільних столиків. " + name + " став у чергу.");
            waitingQueue.add(new Visitor(name, arrivalTime, false));
        }
    }

    public void releaseTable() {
        if (occupiedTables == 0) {
            System.out.println("Усі столики і так вільні.");
            return;
        }

        Visitor toLeave = seatedVisitors.remove(0);
        occupiedTables--;
        System.out.println(toLeave.name + " залишив кафе.");

        if (!waitingQueue.isEmpty()) {
            Visitor next = waitingQueue.poll();
            seatVisitor(next);
        }
    }

    private void seatVisitor(Visitor visitor) {
        occupiedTables++;
        seatedVisitors.add(visitor);
        System.out.println(visitor.name + " сів за столик. " +
                (visitor.hasReservation ? "[За бронюванням]" : "[Без бронювання]"));
    }
}
