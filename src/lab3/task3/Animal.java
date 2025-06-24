package lab3.task3;

abstract class Animal {
    String name;
    boolean isPredator;
    double foodPerDayKg;

    Animal(String Name, boolean IsPredator, double FoodPerDayKg) {
        name = Name;
        isPredator = IsPredator;
        foodPerDayKg = FoodPerDayKg;
    }

    abstract String makeSound();

    void printInfo() {
        System.out.println("Ім'я: " + name);
        System.out.println("Хижак: " + (isPredator ? "Так" : "Ні"));
        System.out.println("Корм/день: " + foodPerDayKg + " кг");
        System.out.println("Звук: " + makeSound());
        System.out.println();
    }
}
