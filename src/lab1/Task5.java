package lab1;

import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        int[] a = new int[100];
        int[][] b = new int[4][100];
        int k1 = 0, k2 = 0, k3 = 0, k4 = 0;

        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000) - 500;
        }

        System.out.println("Початковий масив:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                b[0][k1] = a[i];
                k1++;
            }

            if (isFibo(a[i])) {
                b[1][k2] = a[i];
                k2++;
            }

            if (a[i] < 0 && a[i] > -17) {
                b[2][k3] = a[i];
                k3++;
            }

            if (isPrime(a[i])) {
                b[3][k4] = a[i];
                k4++;
            }
        }

        System.out.println("Парні числа:");
        for (int i = 0; i < k1; i++) {
            System.out.print(b[0][i] + " ");
        }
        System.out.println();

        System.out.println("Числа Фібоначчі:");
        for (int i = 0; i < k2; i++) {
            System.out.print(b[1][i] + " ");
        }
        System.out.println();

        System.out.println("Від’ємні числа > -17:");
        for (int i = 0; i < k3; i++) {
            System.out.print(b[2][i] + " ");
        }
        System.out.println();

        System.out.println("Прості числа:");
        for (int i = 0; i < k4; i++) {
            System.out.print(b[3][i] + " ");
        }
        System.out.println();
    }

    public static boolean isFibo(int n) {
        if (n < 0) return false;
        int a = 0, b = 1;
        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return n == a || n == b;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
