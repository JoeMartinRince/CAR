import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SellerFrame extends JFrame implements ActionListener {
    JTextField idField, nameField, priceField, ownerField;
    JButton addBtn;

    public SellerFrame() {
        setTitle("Seller - Add Car");
        setSize(300, 250);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Car ID:"));
        idField = new JTextField(); add(idField);

        add(new JLabel("Car Name:"));
        nameField = new JTextField(); add(nameField);

        add(new JLabel("Owner Name:"));
        ownerField = new JTextField(); add(ownerField);

        add(new JLabel("Price/Day:"));
        priceField = new JTextField(); add(priceField);

        addBtn = new JButton("Add Car");
        add(addBtn);
        addBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String owner = ownerField.getText();
            double price = Double.parseDouble(priceField.getText());

            Car c = new Car(id, name, owner, price);
            CarDAO.addCar(c);
            JOptionPane.showMessageDialog(this, "Car Added Successfully!");
        } catch (InvalidDataException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}
