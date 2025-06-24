package lab3.task2;

public class Person {
    String firstName;
    String lastName;
    String birthDate;

    Person(String FirstName, String LastName, String BirthDate) {
        firstName = FirstName;
        lastName = LastName;
        birthDate = BirthDate;
    }

    void printInfo() {
        System.out.println(firstName + " " + lastName + ", народився: " + birthDate);
    }
}
