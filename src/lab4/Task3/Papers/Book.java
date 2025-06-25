package lab4.Task3.Papers;

import lab4.Task3.Interfaces.LibraryItem;

public class Book implements LibraryItem {
    private String author;
    private String title;
    private String genre;
    private int pages;

    public Book(String author, String title, String genre, int pages) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("Книга:");
        System.out.println("  Автор: " + author);
        System.out.println("  Назва: " + title);
        System.out.println("  Жанр: " + genre);
        System.out.println("  Сторінок: " + pages);
    }
}
