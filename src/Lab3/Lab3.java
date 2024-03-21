package Lab3;// Tkachenko Oleksii
// OOP Java
// Lab 2 Var18
// Кінцевий срок подання  20.02.2024
// Використано часу- 30 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги
// Реалізований алгоритм. Вхідні дані потрібно зчитати з клавіатури а результат вивести на екран.


import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;

        System.out.print("Enter value for bool: ");
        boolean b = scanner.nextBoolean();

        System.out.print("Enter value for i: ");
        int i = scanner.nextInt();

        if (b) {
            if (i < -5 || i >= 5) {
                result = i + 10;

            } else if (i >= -5 && i < 5) {
                result = 10 - (i * i);

            }
        } else if (!b) {
            if (i <= -7 || i > 4) {
                result = i - 100;

            } else if (i > -7 && i <= 4) {
                result = 10 - i;

            }
        }

        System.out.println("Result: " + result);
    }
}
