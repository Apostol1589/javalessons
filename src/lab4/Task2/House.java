package lab4.Task2;

import lab4.Task2.Interfaces.IPart;
import lab4.Task2.Parts.*;

import java.util.Arrays;
import java.util.Comparator;

public class House {
    private IPart[] parts;

    public House(){
        parts = new IPart[11];
        parts[0] = new Basement();

        for (int i = 1; i <= 4; i++) {
            parts[i] = new Wall();
        }

        for (int i = 5; i <= 8; i++) {
            parts[i] = new Window();
        }

        parts[9] = new Door();
        parts[10] = new Roof();
    }

    public IPart[] getUnbuiltParts() {
        IPart[] unbuilt = new IPart[parts.length];
        int count = 0;

        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isBuilt()) {
                unbuilt[count++] = parts[i];
            }
        }

        IPart[] result = new IPart[count];
        for (int i = 0; i < count; i++) {
            result[i] = unbuilt[i];
        }

        Arrays.sort(result, new Comparator<IPart>() {
            public int compare(IPart a, IPart b) {
                return Integer.compare(a.getPriority(), b.getPriority());
            }
        });

        return result;
    }

    public boolean isCompleted() {
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isBuilt()) {
                return false;
            }
        }
        return true;
    }

    public void displayStatus() {
        System.out.println("House construction status:");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("- " + parts[i].getName() + ": " + (parts[i].isBuilt() ? "built" : "not built"));
        }
        System.out.println();
    }
}
