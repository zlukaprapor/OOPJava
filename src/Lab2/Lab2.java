package Lab2;// Tkachenko Oleksii
// OOP Java
// Lab 2 Var18
// Кінцевий срок подання  13.02.2024
// Використано часу- 20 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

// Ця програма  просить користувача ввести назву своєї улюбленої книги. Використовує
//змінну типу String для зберігання вхідних даних. Програма повинна відобразити наступне:
//• Назва книги з великої літери
//• Назва книги тільки малими літерами
//• Кількість голосних у назві книги
//• Кількість приголосних у назві книги


import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {

        // Створюємо об'єкт Scanner для зчитування введення користувача
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть назву вашої улюбленої книги Англійською)): ");
        String favoriteBook = input.nextLine();

        String capBook = capFirstLetter(favoriteBook);
        System.out.println("Назва книги з великої літери: " + capBook);

        String lowercaseBook = favoriteBook.toLowerCase();
        System.out.println("Назва книги тільки малими літерами: " + lowercaseBook);

        int vowelsCount = countVowels(favoriteBook);
        System.out.println("Кількість голосних у назві книги: " + vowelsCount);

        int consonantsCount = countConsonants(favoriteBook);
        System.out.println("Кількість приголосних у назві книги: " + consonantsCount);


    }

    // Метод для зміни першої літери рядка на велику
    private static String capFirstLetter(String str) {
        return  str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    // Метод для підрахунку кількості голосних у рядку
    private static int countVowels(String str) {
        int count = 0;
        String vowels = "AEIOUYaeiouy";
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

    // Метод для підрахунку кількості приголосних у рядку
    private static int countConsonants(String str) {
        int count = 0;
        String consonants = "BCDFGHJKLMNPQRSTVWXZbcdfghjklmnpqrstvwxz";
        for (int i = 0; i < str.length(); i++) {
            if (consonants.contains(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        return count;
    }
}

//eFfective JAVA
