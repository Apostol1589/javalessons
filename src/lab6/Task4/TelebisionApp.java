package lab6.Task4;

import java.util.*;
import java.util.stream.Collectors;

public class TelebisionApp {
    public static void main(String[] args) {
        List<Television> tvList = List.of(
                new Television("Samsung Q60", 2023, 1200, 55, "Samsung"),
                new Television("LG NanoCell", 2024, 900, 50, "LG"),
                new Television("Sony Bravia", 2024, 1100, 40, "Sony"),
                new Television("Xiaomi MiTV", 2023, 500, 32, "Xiaomi"),
                new Television("Toshiba X200", 2024, 700, 30, "Toshiba"),
                new Television("Samsung Crystal", 2023, 800, 40, "Samsung"),
                new Television("LG OLED", 2024, 1800, 65, "LG"),
                new Television("Sony Basic", 2022, 450, 28, "Sony"),
                new Television("Panasonic Viera", 2024, 1000, 40, "Panasonic"),
                new Television("Philips Ambilight", 2023, 850, 42, "Philips")
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n== Усі телевізори ==");
        tvList.forEach(System.out::println);

        System.out.print("\nВведіть діагональ для пошуку: ");
        double targetDiagonal = scanner.nextDouble();
        System.out.println("Телевізори з діагоналлю " + targetDiagonal + "\":");
        tvList.stream()
                .filter(tv -> tv.getDiagonal() == targetDiagonal)
                .forEach(System.out::println);

        System.out.print("\nВведіть назву виробника: ");
        scanner.nextLine(); // спожити \n
        String brand = scanner.nextLine();
        System.out.println("Телевізори виробника " + brand + ":");
        tvList.stream()
                .filter(tv -> tv.getManufacturer().equalsIgnoreCase(brand))
                .forEach(System.out::println);

        int currentYear = 2024;
        System.out.print("\nВведіть мінімальну ціну: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Телевізори " + currentYear + " року з діагоналлю <= 30\" і ціною >= " + minPrice + "$:");
        tvList.stream()
                .filter(tv -> tv.getYear() == currentYear)
                .filter(tv -> tv.getDiagonal() <= 30)
                .filter(tv -> tv.getPrice() >= minPrice)
                .forEach(System.out::println);

        System.out.print("\nВведіть ціну: ");
        double priceThreshold = scanner.nextDouble();
        System.out.println("Телевізори дорожчі за " + priceThreshold + "$:");
        tvList.stream()
                .filter(tv -> tv.getPrice() > priceThreshold)
                .forEach(System.out::println);

        System.out.println("\n== Телевізори за зростанням ціни ==");
        tvList.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice))
                .forEach(System.out::println);

        System.out.println("\n== Телевізори за спаданням діагоналі ==");
        tvList.stream()
                .sorted(Comparator.comparingDouble(Television::getDiagonal).reversed())
                .forEach(System.out::println);

        System.out.println("\n== Групування телевізорів за виробником ==");
        Map<String, List<Television>> grouped = tvList.stream()
                .collect(Collectors.groupingBy(Television::getManufacturer));

        grouped.forEach((manuf, list) -> {
            System.out.println("\n" + manuf + ":");
            list.forEach(System.out::println);
        });

        System.out.println("\n== Топ-5 найдорожчих телевізорів ==");
        tvList.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice).reversed())
                .limit(5)
                .forEach(System.out::println);

        System.out.println("\n== Топ-3 телевізори з найменшою діагоналлю ==");
        tvList.stream()
                .sorted(Comparator.comparingDouble(Television::getDiagonal))
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n== Останній найдорожчий телевізор з діагоналлю 40\" ==");
        tvList.stream()
                .filter(tv -> tv.getDiagonal() == 40)
                .sorted(Comparator.comparingDouble(Television::getPrice).reversed())
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Телевізорів з діагоналлю 40\" не знайдено."));
    }
}
