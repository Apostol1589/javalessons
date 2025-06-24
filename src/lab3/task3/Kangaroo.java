package lab3.task3;

public class Kangaroo extends Animal{
    Kangaroo(String name) {
        super(name, false, 3.0);
    }

    @Override
    String makeSound() {
        return "Обидеть боксёра может каждый, но не каждый может успеть извиниться.";
    }
}
