package lab3.task4;

class Trombone extends MusicalInstrument {
    String material;
    boolean hasValve;

    Trombone() {
        super(
                "Тромбон",
                "Духовий мідний інструмент з розсувною кулісою.",
                "Тромбон з'явився в XV столітті в Європі як розвиток сакбуту."
        );
        this.material = "Латунь";
        this.hasValve = false;
    }

    @Override
    void sound() {
        System.out.println("Звук: Гучний, глибокий.");
        System.out.println("Матеріал: " + material + ", Наявність клапана: " + (hasValve ? "Так" : "Ні"));
    }
}
