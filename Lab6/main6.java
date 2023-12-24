import java.sql.*;


class JDBC{
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Tunetc";

    public void add(String name, int foundedYear, String location) {
        String sql = "INSERT INTO university (name, founded_year, location) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement key = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            key.setString(1, name);
            key.setInt(2, foundedYear);
            key.setString(3, location);

            int affectedRows = key.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Університет додано");
                ResultSet generatedKeys = key.getGeneratedKeys();
                if (generatedKeys.next()) {
                    System.out.println("ID університету: " + generatedKeys.getInt(1));
                }
            } else {
                System.out.println("Помилка додавання університету");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read_all() {
        String sql = "SELECT * FROM university";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement key = connection.prepareStatement(sql);
             ResultSet resultSet = key.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID університету: " + resultSet.getInt("university_id"));
                System.out.println("Назва: " + resultSet.getString("name"));
                System.out.println("Рік заснування: " + resultSet.getInt("founded_year"));
                System.out.println("Розташування: " + resultSet.getString("location"));
                System.out.println("------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read_name(String universityName) {
        String sql = "SELECT * FROM university WHERE name = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement key = connection.prepareStatement(sql)) {

            key.setString(1, universityName);

            try (ResultSet resultSet = key.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("ID університету: " + resultSet.getInt("university_id"));
                    System.out.println("Назва: " + resultSet.getString("name"));
                    System.out.println("Рік заснування: " + resultSet.getInt("founded_year"));
                    System.out.println("Розташування: " + resultSet.getString("location"));
                } else {
                    System.out.println("Університет не знайдено");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void read_id(int universityId) {
        String sql = "SELECT * FROM university WHERE university_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement key = connection.prepareStatement(sql)) {

            key.setInt(1, universityId);

            try (ResultSet resultSet = key.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("ID університету: " + resultSet.getInt("university_id"));
                    System.out.println("Назва: " + resultSet.getString("name"));
                    System.out.println("Рік заснування: " + resultSet.getInt("founded_year"));
                    System.out.println("Розташування: " + resultSet.getString("location"));
                } else {
                    System.out.println("Університет не знайдено");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int universityId, String newName, int newFoundedYear, String newLocation) {
        String sql = "UPDATE university SET name = ?, founded_year = ?, location = ? WHERE university_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement key = connection.prepareStatement(sql)) {

            key.setString(1, newName);
            key.setInt(2, newFoundedYear);
            key.setString(3, newLocation);
            key.setInt(4, universityId);

            int affectedRows = key.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Дані про університет оновлено");
            } else {
                System.out.println("Помилка оновлення даних");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int universityId) {
        String sql = "DELETE FROM university WHERE university_id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement key = connection.prepareStatement(sql)) {

            key.setInt(1, universityId);

            int affectedRows = key.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Успішно видалено університет");
            } else {
                System.out.println("Помилка видалення університету");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        JDBC universityDAO = new JDBC();

        universityDAO.add("Рівненський державний гуманітарний університет", 1940, "Рівне");
        universityDAO.add("Національний університет водного господарства та природокористування", 1915, "Рівне");
        universityDAO.add("Львівський національний університет імені Івана Франка", 1661, "Львів");
        universityDAO.add("Львівський національний медичний університет імені Данила Галицького", 1784, "Львів");
        universityDAO.add("Київський політехнічний інститут імені Ігоря Сікорського", 1898, "Київ");
        universityDAO.add("Київський національний університет імені Тараса Шевченка", 1834, "Київ");
        universityDAO.add("Івано-Франківський національний медичний університет", 1945, " Івано-Франківськ");
        universityDAO.add("Івано-Франківський національний технічний університет нафти і газу", 1967, " Івано-Франківськ");
        universityDAO.add("Луганський державний медичний університет", 1956, "Луганськ");
        universityDAO.add("Луганський національний університет імені Тараса Шевченка", 1921, "Луганськ");

        universityDAO. read_all();

        universityDAO.update(9, "Луганський державний медичний університет", 2022, "Рівне");
        
        universityDAO.read_id(10);
        universityDAO.read_name("Луганський державний медичний університет");
        
        universityDAO.delete(1);
        universityDAO.read_id(1);
    }
}
