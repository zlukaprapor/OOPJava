package Lab_DB;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DataTransfer {

    public static void main(String[] args) {
        String h2Url = "jdbc:h2:tcp://localhost/~/test";
        String h2User = "h2";
        String h2Password = "h2";

        String sqliteUrl = "jdbc:sqlite:taxpayer.db";

        Connection h2Connection = null;
        Connection sqliteConnection = null;

        try {
            // Завантаження драйверів
            Class.forName("org.h2.Driver");
            Class.forName("org.sqlite.JDBC");

            // Підключення до H2
            h2Connection = DriverManager.getConnection(h2Url, h2User, h2Password);
            System.out.println("Підключення до H2 виконано.");

            // Підключення до SQLite
            sqliteConnection = DriverManager.getConnection(sqliteUrl);
            System.out.println("Підключення до SQLite виконано.");

            // Створення таблиць у SQLite
            createTables(sqliteConnection);

            // Перенесення даних з H2 до SQLite
            transferData(h2Connection, sqliteConnection);

            // Перевірка даних
            verifyData(sqliteConnection);

        } catch (ClassNotFoundException e) {
            System.err.println("Не вдалося знайти клас драйвера: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (h2Connection != null) h2Connection.close();
                if (sqliteConnection != null) sqliteConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createTables(Connection sqliteConnection) throws SQLException {
        String createTaxpayerTable = "CREATE TABLE IF NOT EXISTS Taxpayer (" +
                "TIN INTEGER PRIMARY KEY, " +
                "last_name VARCHAR(50) NOT NULL, " +
                "first_name VARCHAR(50) NOT NULL, " +
                "middle_name VARCHAR(50) NOT NULL, " +
                "date_of_birth DATE NOT NULL, " +
                "address VARCHAR(100) NOT NULL, " +
                "suspect BOOLEAN NOT NULL);";

        String createDeclarationTable = "CREATE TABLE IF NOT EXISTS Declaration (" +
                "TIN INTEGER, " +
                "year_of_declaration DATE NOT NULL, " +
                "amount_of_taxes DECIMAL NOT NULL, " +
                "income DECIMAL NOT NULL, " +
                "expenses DECIMAL NOT NULL, " +
                "FOREIGN KEY (TIN) REFERENCES Taxpayer(TIN));";

        try (PreparedStatement pstmt = sqliteConnection.prepareStatement(createTaxpayerTable)) {
            pstmt.executeUpdate();
            System.out.println("Таблиця Taxpayer створена.");
        }

        try (PreparedStatement pstmt = sqliteConnection.prepareStatement(createDeclarationTable)) {
            pstmt.executeUpdate();
            System.out.println("Таблиця Declaration створена.");
        }
    }

    private static void transferData(Connection h2Connection, Connection sqliteConnection) throws SQLException {
        String selectTaxpayer = "SELECT * FROM Taxpayer";
        String insertTaxpayer = "INSERT OR IGNORE INTO Taxpayer (TIN, last_name, first_name, middle_name, date_of_birth, address, suspect) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement h2Stmt = h2Connection.prepareStatement(selectTaxpayer);
             PreparedStatement sqliteStmt = sqliteConnection.prepareStatement(insertTaxpayer);
             ResultSet rs = h2Stmt.executeQuery()) {

            while (rs.next()) {
                sqliteStmt.setInt(1, rs.getInt("TIN"));
                sqliteStmt.setString(2, rs.getString("last_name"));
                sqliteStmt.setString(3, rs.getString("first_name"));
                sqliteStmt.setString(4, rs.getString("middle_name"));
                // Перетворення формату дати
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateOfBirth = sdf.format(rs.getDate("date_of_birth"));

                sqliteStmt.setString(5, dateOfBirth);
                sqliteStmt.setString(6, rs.getString("address"));
                sqliteStmt.setBoolean(7, rs.getBoolean("suspect"));
                sqliteStmt.executeUpdate();
                System.out.println("Записано платника податків: " + rs.getInt("TIN"));
            }
        }

        String selectDeclaration = "SELECT * FROM Declaration";
        String insertDeclaration = "INSERT INTO Declaration (TIN, year_of_declaration, amount_of_taxes, income, expenses) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement h2Stmt = h2Connection.prepareStatement(selectDeclaration);
             PreparedStatement sqliteStmt = sqliteConnection.prepareStatement(insertDeclaration);
             ResultSet rs = h2Stmt.executeQuery()) {

            while (rs.next()) {
                sqliteStmt.setInt(1, rs.getInt("TIN"));
                // Перетворення формату дати
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateOfDeclaration = sdf.format(rs.getDate("year_of_declaration"));
                sqliteStmt.setString(2, dateOfDeclaration);

                sqliteStmt.setBigDecimal(3, rs.getBigDecimal("amount_of_taxes"));
                sqliteStmt.setBigDecimal(4, rs.getBigDecimal("income"));
                sqliteStmt.setBigDecimal(5, rs.getBigDecimal("expenses"));
                sqliteStmt.executeUpdate();
                System.out.println("Записано декларацію для платника податків: " + rs.getInt("TIN"));
            }
        }
    }

    private static void verifyData(Connection sqliteConnection) throws SQLException {
        String countTaxpayer = "SELECT COUNT(*) FROM Taxpayer";
        String countDeclaration = "SELECT COUNT(*) FROM Declaration";

        try (PreparedStatement stmt = sqliteConnection.prepareStatement(countTaxpayer);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Кількість платників податків: " + rs.getInt(1));
            }
        }

        try (PreparedStatement stmt = sqliteConnection.prepareStatement(countDeclaration);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                System.out.println("Кількість декларацій: " + rs.getInt(1));
            }
        }

        String sampleTaxpayer = "SELECT * FROM Taxpayer LIMIT 5";
        String sampleDeclaration = "SELECT * FROM Declaration LIMIT 5";

        try (PreparedStatement stmt = sqliteConnection.prepareStatement(sampleTaxpayer);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Приклад записів платників податків:");
            while (rs.next()) {
                System.out.println(rs.getInt("TIN") + ", " + rs.getString("last_name") + ", " + rs.getString("first_name"));
            }
        }

        try (PreparedStatement stmt = sqliteConnection.prepareStatement(sampleDeclaration);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Приклад записів декларацій:");
            while (rs.next()) {
                System.out.println(rs.getInt("TIN") + ", " + rs.getBigDecimal("amount_of_taxes"));
            }
        }
    }
}

