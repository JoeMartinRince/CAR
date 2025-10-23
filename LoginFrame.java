import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener {
    JTextField userField;
    JPasswordField passField;
    JComboBox<String> roleBox;
    JButton loginBtn;

    public LoginFrame() {
        setTitle("Car Rental Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        add(new JLabel("Role:"));
        roleBox = new JComboBox<>(new String[]{"Admin", "User", "Seller"});
        add(roleBox);

        loginBtn = new JButton("Login");
        add(loginBtn);
        loginBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());
        String role = (String) roleBox.getSelectedItem();

        // Simple hardcoded logins
        if (role.equals("Admin") && username.equals("admin") && password.equals("123")) {
            new AdminFrame();
            dispose();
        } else if (role.equals("User") && username.equals("user") && password.equals("123")) {
            new UserFrame();
            dispose();
        } else if (role.equals("Seller") && username.equals("seller") && password.equals("123")) {
            new SellerFrame();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!");
        }
    }
}
