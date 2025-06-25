package lab6;

import java.util.*;

public class Task1 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Додати нового користувача");
            System.out.println("2. Видалити існуючого користувача");
            System.out.println("3. Перевірити чи існує користувач");
            System.out.println("4. Змінити логін користувача");
            System.out.println("5. Змінити пароль користувача");
            System.out.println("6. Вихід");
            System.out.print("Оберіть опцію: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addUser();
                    break;
                case "2":
                    removeUser();
                    break;
                case "3":
                    checkUserExists();
                    break;
                case "4":
                    changeLogin();
                    break;
                case "5":
                    changePassword();
                    break;
                case "6":
                    System.out.println("Завершення програми.");
                    return;
                default:
                    System.out.println("Невірна опція.");
            }
        }
    }

    private static void addUser() {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        if (userDatabase.containsKey(login)) {
            System.out.println("Користувач вже існує.");
            return;
        }
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();
        userDatabase.put(login, password);
        System.out.println("Користувача додано.");
    }

    private static void removeUser() {
        System.out.print("Введіть логін користувача для видалення: ");
        String login = scanner.nextLine();
        boolean removed = userDatabase.keySet().stream()
                .filter(user -> user.equals(login))
                .findFirst()
                .map(user -> userDatabase.remove(user) != null)
                .orElse(false);

        System.out.println(removed ? "Користувача видалено." : "Користувача не знайдено.");
    }

    private static void checkUserExists() {
        System.out.print("Введіть логін для перевірки: ");
        String login = scanner.nextLine();
        boolean exists = userDatabase.keySet().stream().anyMatch(user -> user.equals(login));
        System.out.println(exists ? "Користувач існує." : "Користувача не знайдено.");
    }

    private static void changeLogin() {
        System.out.print("Введіть поточний логін: ");
        String oldLogin = scanner.nextLine();
        if (!userDatabase.containsKey(oldLogin)) {
            System.out.println("Користувача не знайдено.");
            return;
        }

        System.out.print("Введіть новий логін: ");
        String newLogin = scanner.nextLine();
        if (userDatabase.containsKey(newLogin)) {
            System.out.println("Новий логін вже зайнятий.");
            return;
        }

        String password = userDatabase.get(oldLogin);
        userDatabase.remove(oldLogin);
        userDatabase.put(newLogin, password);
        System.out.println("Логін змінено.");
    }

    private static void changePassword() {
        System.out.print("Введіть логін: ");
        String login = scanner.nextLine();
        if (!userDatabase.containsKey(login)) {
            System.out.println("Користувача не знайдено.");
            return;
        }
        System.out.print("Введіть новий пароль: ");
        String newPassword = scanner.nextLine();
        userDatabase.computeIfPresent(login, (k, v) -> newPassword);
        System.out.println("Пароль змінено.");
    }
}
