import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UserFrame extends JFrame {
    JTextArea area;

    public UserFrame() {
        setTitle("User - Available Cars");
        setSize(400, 300);
        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);
        displayCars();
        setVisible(true);
    }

    private void displayCars() {
        try (ResultSet rs = CarDAO.getAllCars()) {
            area.setText("Available Cars:\n\n");
            while (rs.next()) {
                area.append(rs.getInt("id") + " - " +
                            rs.getString("name") + " (Owner: " +
                            rs.getString("owner") + ") Rs." +
                            rs.getDouble("price") + "/day\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
