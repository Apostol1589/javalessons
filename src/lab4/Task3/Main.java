package lab4.Task3;

import lab4.Task3.Papers.Almanac;
import lab4.Task3.Papers.LibraryCatalog;
import lab4.Task3.Papers.Newspaper;
import lab4.Task3.Papers.Book;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryCatalog catalog = new LibraryCatalog(100);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Тестова ініціалізація");
            System.out.println("2. Додати книгу");
            System.out.println("3. Додати газету");
            System.out.println("4. Додати альманах");
            System.out.println("5. Вивести всі");
            System.out.println("6. Видалити за назвою");
            System.out.println("7. Пошук за назвою");
            System.out.println("8. Пошук за автором");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");
            int choice = sc.nextInt();
            sc.nextLine(); // очистка

            switch (choice) {
                case 1:
                    catalog.testInit();
                    break;
                case 2:
                    System.out.print("Автор: ");
                    String author = sc.nextLine();
                    System.out.print("Назва: ");
                    String title = sc.nextLine();
                    System.out.print("Жанр: ");
                    String genre = sc.nextLine();
                    System.out.print("Сторінок: ");
                    int pages = sc.nextInt();
                    sc.nextLine();
                    catalog.addItem(new Book(author, title, genre, pages));
                    break;
                case 3:
                    System.out.print("Назва газети: ");
                    String gTitle = sc.nextLine();
                    System.out.print("Дата: ");
                    String date = sc.nextLine();
                    System.out.print("Кількість заголовків: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    String[] headlines = new String[n];
                    for (int i = 0; i < n; i++) {
                        System.out.print("Заголовок " + (i + 1) + ": ");
                        headlines[i] = sc.nextLine();
                    }
                    catalog.addItem(new Newspaper(gTitle, date, headlines));
                    break;
                case 4:
                    System.out.print("Назва альманаху: ");
                    String aTitle = sc.nextLine();
                    System.out.print("Кількість творів: ");
                    int k = sc.nextInt();
                    sc.nextLine();
                    Book[] books = new Book[k];
                    for (int i = 0; i < k; i++) {
                        System.out.println("Твір " + (i + 1) + ":");
                        System.out.print("  Автор: ");
                        String bAuthor = sc.nextLine();
                        System.out.print("  Назва: ");
                        String bTitle = sc.nextLine();
                        System.out.print("  Жанр: ");
                        String bGenre = sc.nextLine();
                        System.out.print("  Сторінок: ");
                        int bPages = sc.nextInt();
                        sc.nextLine();
                        books[i] = new Book(bAuthor, bTitle, bGenre, bPages);
                    }
                    catalog.addItem(new Almanac(aTitle, books));
                    break;
                case 5:
                    catalog.displayAll();
                    break;
                case 6:
                    System.out.print("Назва для видалення: ");
                    String delTitle = sc.nextLine();
                    catalog.removeByTitle(delTitle);
                    break;
                case 7:
                    System.out.print("Назва для пошуку: ");
                    String searchTitle = sc.nextLine();
                    catalog.searchByTitle(searchTitle);
                    break;
                case 8:
                    System.out.print("Ім’я автора для пошуку: ");
                    String searchAuthor = sc.nextLine();
                    catalog.searchByAuthor(searchAuthor);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Невірна опція.");
            }
        }

        System.out.println("До побачення!");
    }
}

