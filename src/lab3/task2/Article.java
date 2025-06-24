package lab3.task2;

public class Article {
    Person author;
    String title;
    double rating;

    Article(Person Author, String Title, double Rating) {
        author = Author;
        title = Title;
        rating = Rating;
    }

    void printInfo() {
        System.out.println("Стаття: " + title);
        System.out.println("Автор: " + author.firstName + " " + author.lastName);
        System.out.println("Рейтинг: " + rating);
    }
}


