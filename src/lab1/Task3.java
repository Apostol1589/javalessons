package lab1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] menu = {
                "1 Кава - 399 грн",
                "2 Чай - 259 грн",
                "3 Капучіно - 459 грн",
                "4 Тістечко - 499 грн",
                "5 Круасан - 359 грн",
                "6 Печиво - 299 грн"
        };

        int[] price = {399, 259, 459, 499, 359, 299};

        while (true) {
            System.out.println("Введіть кількість людей:");
            int k = sc.nextInt();
            sc.nextLine();

            int total = 0;

            for (int i = 1; i <= k; i++) {
                System.out.println("\nКлієнт #" + i);
                int sum = 0;
                while (true) {
                    System.out.println("Меню:");
                    for (String item : menu) {
                        System.out.println(item);
                    }
                    System.out.println("Введіть номер позиції для замовлення (1-6):");
                    int choice = sc.nextInt();

                    if (choice >= 1 && choice <= 6) {
                        sum += price[choice - 1];
                    } else {
                        System.out.println("Такої позиції немає. Спробуйте ще раз.");
                        continue;
                    }

                    System.out.println("Бажаєте додати ще щось? (так/ні)");
                    sc.nextLine(); // очистка буфера
                    String answer = sc.nextLine();

                    if (!answer.equalsIgnoreCase("так")) {
                        break;
                    }
                }
                System.out.println("Сума замовлення клієнта #" + i + ": " + sum + " грн");
                total += sum;
            }

            System.out.println("\nЗагальна сума замовлення компанії: " + total + " грн");

            System.out.println("\nОбслуговувати ще одну компанію? (так/ні)");
            String next = sc.nextLine();
            if (!next.equalsIgnoreCase("так")) {
                System.out.println("Дякуємо, приходьте ще!");
                break;
            }
        }
    }
}
