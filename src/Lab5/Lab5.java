package Lab5;// Tkachenko Oleksii
// OOP Java
// Lab 5 Var18
// Кінцевий срок подання  07.03.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

//Написана програма на Java, яка зчитує з файлу input.txt координати трьох точок використовуючи відповідний
//цикл (х та у координати кожної точки знаходяться у файлі на окремій строці, між ними пробіл) і
//виводить на екран та у файл result.txt інформацію, знаходяться чи ні ці точки на одній прямій. Сам
//підрахунок мусить виконуватись в окремому методі сheckIfOnSameLine. Метод сheckIfOnSameLine бере
//координати трьох точок як аргументи, підраховує та повертає boolean значення true/false. В методі не
//повинно бути ніякої роботи, пов’язаної з вводом\виводом інформації на екран або роботи з файлами. Всі
//методи мусять бути належно задокументовані.


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab5 {
    /**
     * Метод main є головним методом програми, який викликається при запуску.
     * Він відповідає за виклик інших методів для зчитування координат точок,
     * перевірки чи вони знаходяться на одній прямій та виводу результату на екран та у файл.
     */
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {

            // Зчитуємо координати трьох точок з файлу
            double[] coordinates1 = readPointCoordinates(reader);
            double[] coordinates2 = readPointCoordinates(reader);
            double[] coordinates3 = readPointCoordinates(reader);

            // Перевіряємо, чи точки знаходяться на одній прямій
            boolean result = checkIfOnSameLine(coordinates1, coordinates2, coordinates3);

            outputResult(result);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, який зчитує координати точки з файлу.
     *
     * @param reader Об'єкт для зчитування з файлу
     * @return Масив із координатами точки [x, y]
     * @throws IOException Помилка при зчитуванні з файлу
     */
    private static double[] readPointCoordinates(BufferedReader reader) throws IOException {
        String[] coordinates = reader.readLine().split(" ");

        double x = Double.parseDouble(coordinates[0]);
        double y = Double.parseDouble(coordinates[1]);

        return new double[]{x, y};
    }

    /**
     * Метод, який перевіряє, чи три точки знаходяться на одній прямій.
     * (x2 -x1)*(y3 -y1) представляє площу трикутника,утвореного першою та другою точками .
     * (x3 - x1)*(y2 - y1) представляє площу трикутника, утвореного першою та третьою точками.
     * Якщо три точки лежать на одній прямій, то площі цих двох трикутників будуть пропорційні.
     * Таким чином, рівність цих двох виразів вказує на те, що точки лежать на одній прямій.
     * Це базується на принципі "проходження через три точки" або
     * "зміна координат при руху по прямій"
     *
     * @param coordinates1 Масив координат першої точки [x, y]
     * @param coordinates2 Масив координат другої точки [x, y]
     * @param coordinates3 Масив координат третьої точки [x, y]
     * @return true, якщо точки знаходяться на одній прямій, інакше false
     */
    private static boolean checkIfOnSameLine(double[] coordinates1,
                                             double[] coordinates2,
                                             double[] coordinates3) {
        double x1 = coordinates1[0], y1 = coordinates1[1];
        double x2 = coordinates2[0], y2 = coordinates2[1];
        double x3 = coordinates3[0], y3 = coordinates3[1];

        return (x2 - x1) * (y3 - y1) == (x3 - x1) * (y2 - y1);
    }

    /**
     * Метод, який виводить результат на екран та у файл.
     *
     * @param result Результат перевірки
     * @throws IOException Помилка при записі в файл
     */
    private static void outputResult(boolean result) throws IOException {
        System.out.println("Точки на одній прямій: " + result);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true))) {
            writer.write("Точки на одній прямій: " + result + "\n");
        }
    }



}





