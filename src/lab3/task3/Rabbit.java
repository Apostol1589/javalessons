package lab3.task3;

public class Rabbit extends Animal {
    Rabbit(String name) {
        super(name, false, 1.5); // не хижак, 1.5 кг корму/день
    }

    @Override
    String makeSound() {
        return "*Трясеться*";
    }
}
