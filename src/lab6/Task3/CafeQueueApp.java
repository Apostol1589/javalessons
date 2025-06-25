package lab6.Task3;

import java.time.LocalTime;

public class CafeQueueApp {
    public static void main(String[] args) {
        Cafe cafe = new Cafe(3); // 3 вільних столики

        cafe.reserveTable("Alice", LocalTime.of(18, 0));
        cafe.reserveTable("Bob", LocalTime.of(18, 30));

        cafe.arrive("Tom", LocalTime.of(17, 50));
        cafe.arrive("Alice", LocalTime.of(18, 0));
        cafe.arrive("Sara", LocalTime.of(18, 10));
        cafe.arrive("Bob", LocalTime.of(18, 30));
        cafe.arrive("Emma", LocalTime.of(18, 35));

        cafe.releaseTable();
        cafe.releaseTable();
        cafe.releaseTable();
    }
}
