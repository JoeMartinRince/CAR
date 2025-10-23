import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AdminFrame extends JFrame {
    JTextArea area;

    public AdminFrame() {
        setTitle("Admin Dashboard");
        setSize(400, 300);
        area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);
        displayCars();
        setVisible(true);
    }

    private void displayCars() {
        try (ResultSet rs = CarDAO.getAllCars()) {
            area.setText("ID\tName\tOwner\tPrice\n");
            while (rs.next()) {
                area.append(rs.getInt("id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getString("owner") + "\t" +
                            rs.getDouble("price") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
