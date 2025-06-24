package lab3.task2;

class Magazine {
    String name;
    Frequency frequency;
    String releaseDate;
    int circulation;
    Article[] articles;

    Magazine(String Name, Frequency Frequency, String ReleaseDate, int Circulation, Article[] Articles) {
        name = Name;
        frequency = Frequency;
        releaseDate = ReleaseDate;
        circulation = Circulation;
        articles = Articles;
    }

    void printInfo() {
        System.out.println("Журнал: " + name);
        System.out.println("Періодичність: " + frequency);
        System.out.println("Дата виходу: " + releaseDate);
        System.out.println("Тираж: " + circulation);
        System.out.println("Статті:");
        for (int i = 0; i < articles.length; i++) {
            System.out.println("  [" + (i + 1) + "]");
            articles[i].printInfo();
        }
    }
}

