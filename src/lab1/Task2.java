package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args)
        throws FileNotFoundException {
            int[] fuel = {1, 4, 7, 9, 10};
            int rzhd = 1;
            File file = new File("data.txt");
            Scanner sc = new Scanner(file);
            int X = sc.nextInt();
            int AB = sc.nextInt();
            int BC = sc.nextInt();
            int weight = sc.nextInt();

            int c = 0;
            for (int i = 500; i < 2001; i += 500) {
                if (weight < i) {
                    rzhd = fuel[c];
                    break;
                }
                c += 1;
            }

            if (rzhd == 10) {
                System.out.println("Літак не полетить, вага надто велика");
            }

            int needAB = AB * rzhd;
            int needBC = BC * rzhd;

            if (needAB > X) {
                System.out.println("Літак не може долетіти від A до B");
                return;
            }

            int fuelLeft = X - needAB;
            int toRefuel = needBC - fuelLeft;

            if (toRefuel <= 0) {
                System.out.println("Дозаправка в B не потрібна");
            } else if (toRefuel > X) {
                System.out.println("Літак не може долетіти від B до C — потрібно більше пального, ніж вміщує бак");
            } else {
                System.out.println("Мінімальна кількість пального для дозаправки в B: " + toRefuel + " літрів");
            }
        }
    }

