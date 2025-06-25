package lab4.Task3.Papers;

import lab4.Task3.Interfaces.LibraryItem;

public class LibraryCatalog {
    private LibraryItem[] items;
    private int count;

    public LibraryCatalog(int size) {
        items = new LibraryItem[size];
        count = 0;
    }

    public void addItem(LibraryItem item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("Каталог переповнений.");
        }
    }

    public void removeByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title)) {
                for (int j = i; j < count - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--count] = null;
                System.out.println("Об'єкт видалено.");
                return;
            }
        }
        System.out.println("Об'єкт не знайдено.");
    }

    public void displayAll() {
        if (count == 0) {
            System.out.println("Каталог порожній.");
            return;
        }
        for (int i = 0; i < count; i++) {
            items[i].displayInfo();
            System.out.println();
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title)) {
                items[i].displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Нічого не знайдено.");
        }
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (items[i] instanceof Book) {
                Book book = (Book) items[i];
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    book.displayInfo();
                    found = true;
                }
            } else if (items[i] instanceof Almanac) {
                Almanac almanac = (Almanac) items[i];
                for (Book b : almanac.works) {
                    if (b.getAuthor().equalsIgnoreCase(author)) {
                        almanac.displayInfo();
                        found = true;
                        break;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Автор не знайдений.");
        }
    }

    public void testInit() {
        addItem(new Book("Тарас Шевченко", "Кобзар", "Поезія", 300));
        addItem(new Newspaper("День", "25.06.2025", new String[]{"Новини", "Культура", "Економіка"}));
        Book[] works = {
                new Book("Леся Українка", "Лісова пісня", "Драма", 120),
                new Book("Іван Франко", "Мойсей", "Поезія", 150)
        };
        addItem(new Almanac("Українська класика", works));
    }
}
