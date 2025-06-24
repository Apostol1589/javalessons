package lab2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть рядки тексту (порожній рядок — кінець):");
        String[] lines = new String[100];
        int n = 0;

        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) break;
            lines[n] = input;
            n++;
        }

        String text = String.join(" ", lines);


        String[] banned = {"яблуко", "груша", "ананас"};

        int words = text.split(" ").length;
        int sentences = CountSentences(text);

        System.out.printf("Слів в тексті: %d\n\n", words);
        System.out.printf("Речень в тексті: %d\n\n", sentences);
        System.out.printf("Найдовший рядок: \n%s\n\n", sentences);

        String changed = hideBanned(text, banned);
        System.out.println("Після фільтру:");
        System.out.println(changed);
    }

    static int CountSentences(String t){
        int c = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') c++;
        }
        return c;
    }

    static int IndexOfLongest(String[] lines, int n){
        int maxLen = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (lines[i].length() > maxLen) {
                maxLen = lines[i].length();
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static String hideBanned(String t, String[] banned) {
        String res = "", word = "";
        for (int i = 0; i <= t.length(); i++) {
            char ch = (i < t.length()) ? t.charAt(i) : ' ';
            if (ch != ' ' && ch != '.' && ch != ',' && ch != '!' && ch != '?') {
                word += ch;
            } else {
                boolean bad = false;
                for (int j = 0; j < banned.length; j++) {
                    if (word.equalsIgnoreCase(banned[j])) bad = true;
                }
                if (bad) for (int j = 0; j < word.length(); j++) res += "*";
                else res += word;
                res += ch;
                word = "";
            }
        }
        return res.trim();

    }
}
