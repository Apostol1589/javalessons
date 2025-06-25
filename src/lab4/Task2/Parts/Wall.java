package lab4.Task2.Parts;

import lab4.Task2.Interfaces.IPart;

public class Wall implements IPart {
    private boolean built = false;

    public String getName() {
        return "Wall";
    }

    public void build() {
        built = true;
    }

    public boolean isBuilt() {
        return built;
    }

    public int getPriority() {
        return 2;
    }
}
