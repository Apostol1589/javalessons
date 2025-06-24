package lab3.task3;

public class Tiger  extends  Animal{
    Tiger(String name) {
        super(name, true, 8.0); // хижак, 8 кг корму/день
    }

    @Override
    String makeSound() {
        return "*Мурчить*";
    }
}
