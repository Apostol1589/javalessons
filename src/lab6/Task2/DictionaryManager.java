package lab6.Task2;

import java.util.*;
import java.util.stream.Collectors;

public class DictionaryManager {
    private static final Map<String, Dictionary> dictionary = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedInitialData();

        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Переглянути переклади слова");
            System.out.println("2. Додати переклад до слова");
            System.out.println("3. Замінити всі переклади слова");
            System.out.println("4. Видалити переклад слова");
            System.out.println("5. Додати нове слово");
            System.out.println("6. Замінити слово");
            System.out.println("7. Видалити слово");
            System.out.println("8. Топ-10 популярних слів");
            System.out.println("9. Топ-10 непопулярних слів");
            System.out.println("10. Вихід");
            System.out.print("Ваш вибір: ");

            switch (scanner.nextLine()) {
                case "1" -> viewTranslations();
                case "2" -> addTranslation();
                case "3" -> replaceTranslations();
                case "4" -> removeTranslation();
                case "5" -> addWord();
                case "6" -> replaceWord();
                case "7" -> removeWord();
                case "8" -> showTopWords(true);
                case "9" -> showTopWords(false);
                case "10" -> {
                    System.out.println("До побачення!");
                    return;
                }
                default -> System.out.println("Невідома опція.");
            }
        }
    }

    private static void seedInitialData() {
        dictionary.put("apple", new Dictionary(List.of("яблуко")));
        dictionary.put("book", new Dictionary(List.of("книга", "підручник")));
        dictionary.put("car", new Dictionary(List.of("автомобіль", "машина")));
    }

    private static void viewTranslations() {
        System.out.print("Введіть англійське слово: ");
        String word = scanner.nextLine();
        Dictionary entry = dictionary.get(word);
        if (entry != null) {
            System.out.println("Переклади: " + entry.getTranslations());
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private static void addTranslation() {
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();
        Dictionary entry = dictionary.get(word);
        if (entry != null) {
            System.out.print("Введіть новий переклад: ");
            entry.addTranslation(scanner.nextLine());
            System.out.println("Переклад додано.");
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private static void replaceTranslations() {
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();
        if (!dictionary.containsKey(word)) {
            System.out.println("Слово не знайдено.");
            return;
        }
        System.out.print("Введіть нові переклади через кому: ");
        List<String> newTranslations = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim).collect(Collectors.toList());
        dictionary.get(word).replaceTranslations(newTranslations);
        System.out.println("Переклади замінено.");
    }

    private static void removeTranslation() {
        System.out.print("Введіть слово: ");
        String word = scanner.nextLine();
        Dictionary entry = dictionary.get(word);
        if (entry != null) {
            System.out.print("Введіть переклад для видалення: ");
            String translation = scanner.nextLine();
            entry.removeTranslation(translation);
            System.out.println("Переклад видалено.");
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private static void addWord() {
        System.out.print("Введіть нове слово: ");
        String word = scanner.nextLine();
        if (dictionary.containsKey(word)) {
            System.out.println("Слово вже існує.");
            return;
        }
        System.out.print("Введіть переклади через кому: ");
        List<String> translations = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim).collect(Collectors.toList());
        dictionary.put(word, new Dictionary(translations));
        System.out.println("Слово додано.");
    }

    private static void replaceWord() {
        System.out.print("Введіть слово для заміни: ");
        String oldWord = scanner.nextLine();
        if (!dictionary.containsKey(oldWord)) {
            System.out.println("Слово не знайдено.");
            return;
        }
        System.out.print("Введіть нове слово: ");
        String newWord = scanner.nextLine();
        if (dictionary.containsKey(newWord)) {
            System.out.println("Слово вже існує.");
            return;
        }
        dictionary.put(newWord, dictionary.remove(oldWord));
        System.out.println("Слово змінено.");
    }

    private static void removeWord() {
        System.out.print("Введіть слово для видалення: ");
        String word = scanner.nextLine();
        if (dictionary.remove(word) != null) {
            System.out.println("Слово видалено.");
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private static void showTopWords(boolean popular) {
        System.out.println(popular ? "\nТОП-10 популярних слів:" : "\nТОП-10 непопулярних слів:");

        dictionary.entrySet().stream()
                .sorted((e1, e2) -> popular
                        ? Integer.compare(e2.getValue().getUsageCount(), e1.getValue().getUsageCount())
                        : Integer.compare(e1.getValue().getUsageCount(), e2.getValue().getUsageCount()))
                .limit(10)
                .forEach(e -> System.out.printf("Слово: %s — Використань: %d%n", e.getKey(), e.getValue().getUsageCount()));
    }
}
