package lab1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double i = Double.MAX_VALUE;
        double min = Double.MAX_VALUE;
        System.out.println("Вводьте числа від 0 до 9");
        do {
            i = sc.nextDouble();
            if (i < min)
                min = i;
        } while (i >= 0 && i <= 9);

        if (min >= 0 && min <= 9) {
            System.out.printf("Найменше число з введених %f", min);
        } else {
            System.out.println("На жаль, Ви не вводили чисел з запропонованого діапазону");
        }
    }
}
