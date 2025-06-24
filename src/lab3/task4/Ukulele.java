package lab3.task4;

class Ukulele extends MusicalInstrument {
    int numberOfStrings;
    String bodyMaterial;
    String type;

    Ukulele() {
        super(
                "Укулеле",
                "Невелика гітара з чотирма струнами, популярна на Гаваях.",
                "Укулеле виникло в XIX столітті на Гавайських островах, має португальське походження."
        );
        this.numberOfStrings = 4;
        this.bodyMaterial = "Махагоні";
        this.type = "Сопрано";
    }

    @Override
    void sound() {
        System.out.println("Звук: Легкий, веселий.");
        System.out.println("Тип: " + type + ", Струни: " + numberOfStrings + ", Корпус: " + bodyMaterial);
    }
}
