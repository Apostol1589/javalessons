package lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Завдання 1
public class Car {
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


}
