package lab4.Task3.Papers;

import lab4.Task3.Interfaces.LibraryItem;

public class Almanac implements LibraryItem {
    private String title;
    public Book[] works;

    public Almanac(String title, Book[] works) {
        this.title = title;
        this.works = works;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("Альманах:");
        System.out.println("  Назва: " + title);
        System.out.println("  Твори:");
        for (Book b : works) {
            System.out.print("    - ");
            System.out.println(b.getTitle() + " (Автор: " + b.getAuthor() + ")");
        }
    }
}
