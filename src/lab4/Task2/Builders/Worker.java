package lab4.Task2.Builders;

import lab4.Task2.House;
import lab4.Task2.Interfaces.*;


public class Worker implements IWorker {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void work(House house) {
        IPart[] unbuiltParts = house.getUnbuiltParts();
        if (unbuiltParts.length > 0) {
            IPart part = unbuiltParts[0];
            part.build();
            System.out.println(name + " built: " + part.getName());
        }
    }
}