package lab5.Task3;

import java.io.*;
import java.util.*;


public class CorporationSystem {
    static List<Employee> employees = new ArrayList<>();
    static boolean modified = false;
    static String employeeFile = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть шлях до файлу зі співробітниками: ");
        employeeFile = sc.nextLine();
        loadEmployees(employeeFile);

        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Додати співробітника");
            System.out.println("2. Редагувати співробітника");
            System.out.println("3. Видалити співробітника");
            System.out.println("4. Пошук за прізвищем");
            System.out.println("5. Вивести усіх співробітників (за віком / літерою)");
            System.out.println("6. Зберегти результат у файл-звіт");
            System.out.println("7. Перезаписати основний файл");
            System.out.println("0. Вийти з програми");

            System.out.print("Ваш вибір: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": addEmployee(sc); break;
                case "2": editEmployee(sc); break;
                case "3": deleteEmployee(sc); break;
                case "4": searchEmployee(sc); break;
                case "5": filterEmployees(sc); break;
                case "6": saveReport(sc); break;
                case "7": saveEmployees(employeeFile); break;
                case "0": exitProgram(); return;
                default: System.out.println("Невідома команда.");
            }
        }
    }

    static void loadEmployees(String path) {
        employees.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                employees.add(Employee.fromString(line));
            }
            reader.close();
            System.out.println("Список завантажено.");
        } catch (IOException e) {
            System.out.println("Не вдалося прочитати файл: " + e.getMessage());
        }
    }

    static void saveEmployees(String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (Employee emp : employees) {
                writer.write(emp.toString());
                writer.newLine();
            }
            writer.close();
            modified = false;
            System.out.println("Список збережено у файл.");
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    static void addEmployee(Scanner sc) {
        System.out.print("Прізвище: ");
        String surname = sc.nextLine();
        System.out.print("Ім'я: ");
        String name = sc.nextLine();
        System.out.print("Вік: ");
        int age = Integer.parseInt(sc.nextLine());

        employees.add(new Employee(surname, name, age));
        modified = true;
        System.out.println("Співробітника додано.");
    }

    static void editEmployee(Scanner sc) {
        System.out.print("Введіть номер співробітника (з 1): ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        if (index >= 0 && index < employees.size()) {
            Employee emp = employees.get(index);
            System.out.println("Поточні дані: " + emp.surname + ", " + emp.name + ", " + emp.age);

            System.out.print("Нове прізвище: ");
            emp.surname = sc.nextLine();
            System.out.print("Нове ім'я: ");
            emp.name = sc.nextLine();
            System.out.print("Новий вік: ");
            emp.age = Integer.parseInt(sc.nextLine());

            modified = true;
            System.out.println("Дані оновлено.");
        } else {
            System.out.println("Неправильний номер.");
        }
    }

    static void deleteEmployee(Scanner sc) {
        System.out.print("Введіть номер співробітника для видалення (з 1): ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        if (index >= 0 && index < employees.size()) {
            employees.remove(index);
            modified = true;
            System.out.println("Співробітника видалено.");
        } else {
            System.out.println("Невірний номер.");
        }
    }

    static void searchEmployee(Scanner sc) {
        System.out.print("Введіть прізвище для пошуку: ");
        String surname = sc.nextLine().toLowerCase();
        for (Employee emp : employees) {
            if (emp.surname.toLowerCase().equals(surname)) {
                System.out.println(emp.surname + ", " + emp.name + ", " + emp.age);
            }
        }
    }

    static void filterEmployees(Scanner sc) {
        System.out.println("1. За віком");
        System.out.println("2. За початковою літерою прізвища");
        String option = sc.nextLine();

        if (option.equals("1")) {
            employees.sort(Comparator.comparingInt(e -> e.age));
        } else if (option.equals("2")) {
            System.out.print("Введіть літеру: ");
            String letter = sc.nextLine().toLowerCase();
            for (Employee emp : employees) {
                if (emp.surname.toLowerCase().startsWith(letter)) {
                    System.out.println(emp.surname + ", " + emp.name + ", " + emp.age);
                }
            }
            return;
        }

        int i = 1;
        for (Employee emp : employees) {
            System.out.println(i + ". " + emp.surname + ", " + emp.name + ", " + emp.age);
            i++;
        }
    }

    static void saveReport(Scanner sc) {
        System.out.print("Введіть назву файлу звіту: ");
        String filename = sc.nextLine();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Employee emp : employees) {
                writer.write(emp.toString());
                writer.newLine();
            }
            writer.close();
            System.out.println("Звіт збережено.");
        } catch (IOException e) {
            System.out.println("Помилка при створенні звіту: " + e.getMessage());
        }
    }

    static void exitProgram() {
        if (modified) {
            saveEmployees(employeeFile);
        }
        System.out.println("Завершення програми.");
    }
}
