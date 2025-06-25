package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть шлях до першого файлу: ");
        String path1 = sc.nextLine();

        System.out.print("Введіть шлях до другого файлу: ");
        String path2 = sc.nextLine();

        try {
            String[] lines1 = readFile(path1);
            String[] lines2 = readFile(path2);

            int max = Math.max(lines1.length, lines2.length);

            System.out.println("\nРядки, що не збігаються:");

            for (int i = 0; i < max; i++) {
                String line1 = (i < lines1.length) ? lines1[i] : "";
                String line2 = (i < lines2.length) ? lines2[i] : "";

                if (!line1.equals(line2)) {
                    System.out.println("\nРядок " + (i + 1) + ":");
                    System.out.println("  Файл 1: " + line1);
                    System.out.println("  Файл 2: " + line2);
                }
            }

        } catch (IOException e) {
            System.out.println("Помилка при читанні файлів: " + e.getMessage());
        }

        sc.close();
    }

    public static String[] readFile(String path) throws IOException {
        BufferedReader counter = new BufferedReader(new FileReader(path));
        int lineCount = 0;
        while (counter.readLine() != null) {
            lineCount++;
        }
        counter.close();

        String[] lines = new String[lineCount];
        BufferedReader reader = new BufferedReader(new FileReader(path));
        for (int i = 0; i < lineCount; i++) {
            lines[i] = reader.readLine();
        }
        reader.close();

        return lines;
    }
}

