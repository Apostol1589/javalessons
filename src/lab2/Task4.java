package lab2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть рядок:");
        String input = sc.nextLine();

        String[] words = input.split(" ");

        for (String word : words) {
            if (isMatching(word)) {
                System.out.println("Знайдено відповідне слово: " + word);
            }
        }
    }

    public static boolean isMatching(String word) {
        if (word.length() < 7) {
            return false;
        }

        char last = word.charAt(word.length() - 1);
        if (last != ',' && last != '.' && last != '!' && last != ':' && last != ';') {
            return false;
        }

        String core = word.substring(0, word.length() - 1);

        if (!core.endsWith("tion")) {
            return false;
        }

        char first = core.charAt(0);
        if (first < 'A' || first > 'Z') {
            return false;
        }

        String middle = core.substring(1, core.length() - 4);

        if (middle.length() < 1 || middle.length() > 8) {
            return false;
        }

        for (int i = 0; i < middle.length(); i++) {
            char c = middle.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }

        return true;
    }
}
