import java.sql.*;

public class CarDAO {
    public static void createTable() {
        try (Connection c = DBConnection.getConnection();
             Statement s = c.createStatement()) {
            s.execute("CREATE TABLE IF NOT EXISTS cars(id INTEGER PRIMARY KEY, name TEXT, owner TEXT, price REAL)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCar(Car car) {
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO cars VALUES(?,?,?,?)")) {
            ps.setInt(1, car.getId());
            ps.setString(2, car.getName());
            ps.setString(3, car.getOwner());
            ps.setDouble(4, car.getPricePerDay());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAllCars() {
        try {
            Connection c = DBConnection.getConnection();
            Statement s = c.createStatement();
            return s.executeQuery("SELECT * FROM cars");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
