package lab3.task3;

public class Wolf extends Animal {
    Wolf(String name) {
        super(name, true, 5.0); // хижак, 5 кг корму/день
    }

    @Override
    String makeSound() {
        return "А сегодня в завтрашний день не все могут смотреть. Вернее, смотреть могут не только лишь все. Мало, кто может это делать";
    }
}
