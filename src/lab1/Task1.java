package lab1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введіть перше число");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();

        System.out.println("Введіть друге число");
        sc = new Scanner(System.in);
        int n2 = sc.nextInt();

        System.out.println("Непарні числа: ");
        if (n1 < n2)
            PrintOdd(n1, n2);
        else
            PrintOdd(n2, n1);
    }
    static void PrintOdd(int n1, int n2){
        for (int i = n1; i <= n2; i++){
            if (i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}
