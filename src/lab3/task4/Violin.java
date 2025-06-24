package lab3.task4;

public class Violin  extends MusicalInstrument{
    int numberOfStrings;
    String size;

    Violin() {
        super(
                "Скрипка",
                "Струнний смичковий музичний інструмент з чотирма струнами.",
                "Скрипка походить з Італії, остаточну форму набула у XVI столітті."
        );
        this.numberOfStrings = 4;
        this.size = "4/4 (повнорозмірна)";
    }

    @Override
    void sound() {
        System.out.println("Звук: Високий, мелодійний.");
        System.out.println("Кількість струн: " + numberOfStrings + ", Розмір: " + size);
    }
}
