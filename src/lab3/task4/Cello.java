package lab3.task4;

class Cello extends MusicalInstrument {
    int numberOfStrings;
    double height;
    String bowMaterial;

    Cello() {
        super(
                "Віолончель",
                "Великий струнний смичковий інструмент з глибоким звучанням.",
                "Віолончель розвинулася з басової віоли в XVI столітті в Італії."
        );
        this.numberOfStrings = 4;
        this.height = 120.0;
        this.bowMaterial = "Карбон";
    }

    @Override
    void sound() {
        System.out.println("Звук: Глибокий, емоційний.");
        System.out.println("Висота: " + height + " см, Струни: " + numberOfStrings + ", Смичок: " + bowMaterial);
    }
}