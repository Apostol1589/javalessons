package lab2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть пароль:");
        String password = sc.nextLine();

        if (password.length() < 8) {
            System.out.println("Пароль ненадійний: менше 8 символів.");
            return;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                hasUpper = true;
            } else if (ch >= 'a' && ch <= 'z') {
                hasLower = true;
            } else if (ch >= '0' && ch <= '9') {
                hasDigit = true;
            } else if (ch == '!' || ch == '*' || ch == '_' || ch == '.') {
                hasSymbol = true;
            }
        }

        if (hasUpper && hasLower && hasDigit && hasSymbol) {
            System.out.println("Пароль надійний.");
        } else {
            System.out.println("Пароль ненадійний: має містити великі й малі літери, цифри та символи ! * _ .");
        }
    }
}
