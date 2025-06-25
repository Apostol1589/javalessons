package lab4.Task2.Parts;

import lab4.Task2.Interfaces.IPart;

public class Window implements IPart {
    private boolean built = false;

    public String getName() {
        return "Window";
    }

    public void build() {
        built = true;
    }

    public boolean isBuilt() {
        return built;
    }

    public int getPriority() {
        return 3;
    }
}
