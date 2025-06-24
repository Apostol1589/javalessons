package lab3.task4;

abstract class MusicalInstrument {
    String name;
    String description;
    String history;

    MusicalInstrument(String Name, String Description, String History) {
        name = Name;
        description = Description;
        history = History;
    }

    abstract void sound();

    void show() {
        System.out.println("Інструмент: " + name);
    }

    void desc() {
        System.out.println("Опис: " + description);
    }

    void history() {
        System.out.println("Історія: " + history);
    }

    void printAll() {
        show();
        desc();
        history();
        sound();
        System.out.println();
    }
}
