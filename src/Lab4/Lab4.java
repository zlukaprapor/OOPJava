package Lab4;// Tkachenko Oleksii
// OOP Java
// Lab 2 Var18
// Кінцевий срок подання  29.02.2024
// Використано часу- 20 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

/*Напишіть програму, яка зчитує від користувача координати трьох точок використовуючи відповідний
цикл і виводить на екран та у файл result.txt інформацію, чи створюють ці точки трикутник.
Перевірка введених даних: не приймайте від’ємні значення координат.*/

import java.io.*;
import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Масив для зберігання координат трьох точок
        double[][] points = new double[3][2];

        // Зчитування координат точок використовуючи цикл
        for (int i = 0; i < 3; i++) {
            System.out.println("Введіть координати точки " + (i + 1) + ":");
            System.out.print("X: ");
            double x = scanner.nextDouble();
            System.out.print("Y: ");
            double y = scanner.nextDouble();

            // Перевірка на від'ємні значення координат
            if (x < 0 || y < 0) {
                System.out.println("Координати не можуть бути від'ємними. Будь ласка, введіть додатні значення.");
                i--; // Повторити введення для поточної точки
            } else {
                points[i][0] = x;
                points[i][1] = y;
            }
        }

        // Перевірка чи створюється трикутник
        if (isTriangle(points)) {
            System.out.println("Трикутник створений!");
            writeToResultFile(points);
        } else {
            System.out.println("Ці точки не утворюють трикутник.");
            writeToResultFile(points);
        }
    }

    // Метод для перевірки, чи створюється трикутник
    private static boolean isTriangle(double[][] points) {
        double x1 = points[0][0], y1 = points[0][1];
        double x2 = points[1][0], y2 = points[1][1];
        double x3 = points[2][0], y3 = points[2][1];

        double area = 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        return area != 0;
    }

    // Метод для запису результату у файл result.txt

    private static void writeToResultFile(double[][] points) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("result.txt", true));
            writer.write("Координати точок трикутника:\n");
            for (int i = 0; i < 3; i++) {
                writer.write("Точка " + (i + 1) + ": (" + points[i][0] + ", " + points[i][1] + ")\n");
            }
            System.out.println("Результат записано у файл result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //  private static void writeToResultFile(double[][] points) {
    //    try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true))) {
    //        writer.write("Координати точок трикутника:\n");
    //        for (int i = 0; i < 3; i++) {
    //            writer.write("Точка " + (i + 1) + ": (" + points[i][0] + ", " + points[i][1] + ")\n");
    //        }
    //        System.out.println("Результат записано у файл result.txt");
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //   }
    // }





}
