package lab5;

import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> badWords = loadBadWords("bad_words.txt");
        if (badWords.isEmpty()) {
            System.out.println("Список заборонених слів порожній або не знайдений.");
            return;
        }

        System.out.print("Введіть шлях до папки з текстовими файлами: ");
        String folderPath = sc.nextLine();

        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("Це не папка.");
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("У папці немає текстових файлів.");
            return;
        }

        for (File file : files) {
            Map<String, Integer> wordCount = checkFileForBadWords(file, badWords);

            if (!wordCount.isEmpty()) {
                System.out.println("\nФайл: " + file.getName());
                for (String word : wordCount.keySet()) {
                    System.out.println("  Слово \"" + word + "\" зустрічається " + wordCount.get(word) + " раз(ів)");
                }

                System.out.print("Бажаєте замінити заборонені слова на *? (так/ні): ");
                String answer = sc.nextLine().trim().toLowerCase();

                if (answer.equals("так")) {
                    replaceBadWordsInFile(file, badWords);
                    System.out.println("Файл оновлено.");
                } else {
                    System.out.println("Файл залишено без змін.");
                }
            }
        }

        sc.close();
    }

    public static List<String> loadBadWords(String filename) {
        List<String> words = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу зі словами: " + e.getMessage());
        }
        return words;
    }

    public static Map<String, Integer> checkFileForBadWords(File file, List<String> badWords) {
        Map<String, Integer> wordCount = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : badWords) {
                    int count = countOccurrences(line.toLowerCase(), word.toLowerCase());
                    if (count > 0) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + count);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + file.getName());
        }
        return wordCount;
    }

    public static int countOccurrences(String text, String word) {
        int count = 0;
        int index = text.indexOf(word);
        while (index != -1) {
            count++;
            index = text.indexOf(word, index + word.length());
        }
        return count;
    }

    public static void replaceBadWordsInFile(File file, List<String> badWords) {
        StringBuilder newText = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String modifiedLine = line;
                for (String word : badWords) {
                    String stars = "*".repeat(word.length());
                    modifiedLine = modifiedLine.replaceAll("(?i)" + word, stars);
                }
                newText.append(modifiedLine).append("\n");
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(newText.toString());
            writer.close();

        } catch (IOException e) {
            System.out.println("Помилка при оновленні файлу: " + file.getName());
        }
    }
}
