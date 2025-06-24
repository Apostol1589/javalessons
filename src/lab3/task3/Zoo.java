package lab3.task3;

public class Zoo {
    public static void main(String[] args) {
        Animal[] zoo = {
                new Tiger("Рижик"),
                new Rabbit("Шерхан"),
                new Wolf("Віталій"),
                new Kangaroo("Володимир"),
                new Tiger("Карась"),
                new Rabbit("Катя")
        };

        int predatorsCount = 0;
        double totalFood = 0;
        double predatorFood = 0;
        double herbivoreFood = 0;

        System.out.println("Інформація про тварин у зоопарку:\n");

        for (Animal animal : zoo) {
            animal.printInfo();
            totalFood += animal.foodPerDayKg;

            if (animal.isPredator) {
                predatorsCount++;
                predatorFood += animal.foodPerDayKg;
            } else {
                herbivoreFood += animal.foodPerDayKg;
            }
        }

        System.out.println("===== Звіт по зоопарку =====");
        System.out.println("Кількість хижаків: " + predatorsCount);
        System.out.println("Загальна кількість корму: " + totalFood + " кг/день");
        System.out.println("- для хижаків: " + predatorFood + " кг/день");
        System.out.println("- для травоїдних: " + herbivoreFood + " кг/день");
    }
}
