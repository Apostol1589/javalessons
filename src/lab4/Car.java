package lab4;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//Завдання 1
public class Car implements Serializable, Comparable<Car> {
    private final String brand;
    private final String licensePlate;
    private final int year;
    private boolean rented;
    private Date rentDate;
    private int rentTerm;

    public Car(String Brand, String LicensePlate, int Year){
        brand = Brand;
        licensePlate = LicensePlate;
        year = Year;
        rented = false;
        rentDate = null;
        rentTerm = 0;
    }

    public String getBrand() {
        return licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getYear() {
        return year;
    }

    public boolean isRented() {
        return rented;
    }

    public String getRentDate() {
        if (rentDate != null){
            var sdf = new SimpleDateFormat("dd.MM.yyy");
            return sdf.format(rentDate);
        }
        return "";
    }

    public int getRentTerm(){
        return rentTerm;
    }

    public void rent(int termInDays) {
        if (!rented){
            rented = true;
            rentDate = new Date();
            rentTerm = termInDays;
        }
    }

    public void returnCar() {
        if(rented) {
            rented = false;
            rentDate = null;
            rentTerm = 0;
        }
    }

    @Override
    public String toString() {
        String rentInfo = rented ? ", орендовано з " + getRentDate() + " на " + rentTerm + " днів" : ", вільний";
        return brand + " [" + licensePlate + "], " + year + rentInfo;
    }

    public static void printAvailableCars(Car[] cars){
        for (Car car : cars){
            if (!car.isRented()){
                System.out.println(car);
            }
        }
    }

    public static void printRentedCars(Car[] cars){
        for (Car car : cars){
            if (car.isRented()){
                System.out.println(car);
            }
        }
    }

    public static void findCarsFreeInMonth(Car[] cars, int month, int year) {
        for (Car car : cars) {
            if (car.isRented() && car.getRentDate() != null && car.getRentTerm() > 0) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date rentDate = sdf.parse(car.getRentDate());

                    long rentEndMillis = rentDate.getTime() + (long)car.getRentTerm() * 24 * 60 * 60 * 1000;
                    Date rentEndDate = new Date(rentEndMillis);

                    @SuppressWarnings("deprecation")
                    int endMonth = rentEndDate.getMonth() + 1;
                    @SuppressWarnings("deprecation")
                    int endYear = rentEndDate.getYear() + 1900;

                    if (endMonth == month && endYear == year) {
                        System.out.println(car);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public int compareTo(Car o) {
        if (year != o.year) {
            return Integer.compare(year, o.year);
        }
        return brand.compareTo(o.brand);
    }

    public static void saveCarsToFile(Car[] cars, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Car[] loadCarsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Car[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Car[0];
    }

    public static void main(String[] args) {
        Car[] cars = {
                new Car("Toyota", "AA1234BB", 2015),
                new Car("BMW", "CC5678DD", 2012),
                new Car("Audi", "EE9012FF", 2015)
        };

        Arrays.sort(cars);
        for (Car car : cars){
            System.out.println(car);
        }

        saveCarsToFile(cars, "cars.dat");
        Car[] loaded = loadCarsFromFile("cars.dat");

        System.out.println("Завантажено з файлу:");
        for (Car car : loaded){
            System.out.println(car);
        }
    }


}
