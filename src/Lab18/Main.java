package Lab18;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();
        Menu menu = new Menu(catalogue);

        // Зчитування інформації з файлу при початку програми
        try {
            catalogue.readInfoFromFile("catalogue.txt");
            System.out.println("Catalogue loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading catalogue from file: " + e.getMessage());
        }

        // Відображення меню
        menu.displayMenu();
    }
}

