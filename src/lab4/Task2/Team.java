package lab4.Task2;

import lab4.Task2.Interfaces.IWorker;

public class Team {
    private final IWorker[] members;

    public Team(IWorker... members) {
        this.members = members;
    }

    public void buildHouse(House house) {
        while (!house.isCompleted()) {
            for (IWorker worker : members) {
                if (!house.isCompleted()) {
                    worker.work(house);
                }
            }
        }
        System.out.println("House is fully built!");
    }
}
