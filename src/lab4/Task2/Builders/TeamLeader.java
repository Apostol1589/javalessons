package lab4.Task2.Builders;

import lab4.Task2.House;
import lab4.Task2.Interfaces.IWorker;

public class TeamLeader implements IWorker {
    private final String name;

    public TeamLeader(String name) {
        this.name = name;
    }

    @Override
    public void work(House house) {
        System.out.println("\n" + name + " reporting progress:");
        house.displayStatus();
    }
}
