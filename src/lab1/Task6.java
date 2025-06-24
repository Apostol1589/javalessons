package lab1;

import java.util.Arrays;
import java.util.Scanner;

import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть числа, розділені крапкою з комою (наприклад: 1.2; 0.5; 7.0):");
        String line = sc.nextLine();
        String[] parts = line.split(";");

        double[] a = new double[parts.length];

        for (int i = 0; i < parts.length; i++) {
            try {
                a[i] = Double.parseDouble(parts[i].trim());
            } catch (NumberFormatException e) {
                System.out.println("Ви намагаєтесь ввести не числа");
                return;
            }
        }

        reorderByMax(a);

        System.out.println("Після впорядкування:");
        for (double v : a) {
            System.out.print(v + "; ");
        }
    }

    public static void reorderByMax(double[] arr) {
        int maxIndex = 0;
        double max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        double[] left = Arrays.copyOfRange(arr, 0, maxIndex);
        double[] right = Arrays.copyOfRange(arr, maxIndex + 1, arr.length);

        Arrays.sort(left);
        Arrays.sort(right);

        for (int i = 0; i < right.length / 2; i++) {
            double temp = right[i];
            right[i] = right[right.length - 1 - i];
            right[right.length - 1 - i] = temp;
        }

        int pos = 0;
        for (int i = 0; i < left.length; i++) {
            arr[pos++] = left[i];
        }

        arr[pos++] = max;

        for (int i = 0; i < right.length; i++) {
            arr[pos++] = right[i];
        }
    }
}

