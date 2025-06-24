package lab2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Введення рядка
        System.out.println("Введіть рядок:");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        String sub1 = sb.substring(0, 5); // перші 5 символів
        System.out.println("Підрядок (0-5): " + sub1);

        char[] chars = new char[5];
        sb.getChars(0, 5, chars, 0);
        System.out.print("Символи (getChars 0-5): ");
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println();

        sb.append(" Кінець");
        System.out.println("Після append: " + sb);

        sb.insert(5, " [вставка] ");
        System.out.println("Після insert: " + sb);

        sb.delete(2, 7);
        System.out.println("Після delete (2-7): " + sb);

        sb.replace(0, 5, "Заміна");
        System.out.println("Після replace (0-5): " + sb);
    }
}
