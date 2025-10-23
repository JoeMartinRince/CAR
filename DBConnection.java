import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:car_rental.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
