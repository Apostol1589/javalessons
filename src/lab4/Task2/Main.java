package lab4.Task2;

import lab4.Task2.Builders.TeamLeader;
import lab4.Task2.Builders.Worker;

public class Main {
    public static void main(String[] args) {
        House house = new House();

        Worker w1 = new Worker("John");
        Worker w2 = new Worker("Emily");
        Worker w3 = new Worker("Mark");
        TeamLeader leader = new TeamLeader("Mr. Smith");

        Team team = new Team(w1, w2, leader, w3);
        team.buildHouse(house);
    }
}
