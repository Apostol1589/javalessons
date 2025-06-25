package lab6.Task4;

public class Television {
    private final String model;
    private final int year;
    private final double price;
    private final double diagonal;
    private final String manufacturer;

    public Television(String model, int year, double price, double diagonal, String manufacturer) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.diagonal = diagonal;
        this.manufacturer = manufacturer;
    }

    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public double getDiagonal() { return diagonal; }
    public String getManufacturer() { return manufacturer; }

    @Override
    public String toString() {
        return String.format("Модель: %s | Рік: %d | Ціна: %.2f$ | Діагональ: %.1f\" | Виробник: %s",
                model, year, price, diagonal, manufacturer);
    }
}
