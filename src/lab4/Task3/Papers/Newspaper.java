package lab4.Task3.Papers;

import lab4.Task3.Interfaces.LibraryItem;

public class Newspaper implements LibraryItem {
    private String title;
    private String date;
    private String[] headlines;

    public Newspaper(String title, String date, String[] headlines) {
        this.title = title;
        this.date = date;
        this.headlines = headlines;
    }

    public String getTitle() {
        return title;
    }

    public void displayInfo() {
        System.out.println("Газета:");
        System.out.println("  Назва: " + title);
        System.out.println("  Дата виходу: " + date);
        System.out.println("  Заголовки:");
        for (String h : headlines) {
            System.out.println("    - " + h);
        }
    }
}
