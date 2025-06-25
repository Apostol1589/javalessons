package lab5.Task3;

public class Employee {
    String surname;
    String name;
    int age;

    public Employee(String surname, String name, int age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return surname + "," + name + "," + age;
    }

    public static Employee fromString(String line) {
        String[] parts = line.split(",");
        return new Employee(parts[0], parts[1], Integer.parseInt(parts[2]));
    }
}
