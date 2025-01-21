package sidra;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MenuData extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton addButton;
    private JButton deleteSpecificButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuData frame = new MenuData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuData() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
        JPanel buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        addButton = new JButton("Add");
        deleteSpecificButton = new JButton("Delete Specific");

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteSpecificButton);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateMenuData();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteMenuData();
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMenuData();
            }
        });

        deleteSpecificButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteSpecificMenuItem();
            }
        });

        fetchMenuData();
    }

    private void fetchMenuData() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");

            String query = "SELECT item, price, qty, total FROM MENU_INFO";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            model = new DefaultTableModel(
                    new Object[]{"item", "price", "qty", "total"}, 0);

            while (rs.next()) {
                String item = rs.getString("item");
                double price = rs.getDouble("price");
                int qty = rs.getInt("qty");
                double total = rs.getDouble("total");

                model.addRow(new Object[]{item, price, qty, total});
            }
            table.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void updateMenuData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update");
            return;
        }
        String item = model.getValueAt(selectedRow, 0).toString();
        double price = Double.parseDouble(model.getValueAt(selectedRow, 1).toString());
        int qty = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
        double total = Double.parseDouble(model.getValueAt(selectedRow, 3).toString());

        // Show input dialog to get new values
        JTextField itemField = new JTextField(item);
        JTextField priceField = new JTextField(String.valueOf(price));
        JTextField qtyField = new JTextField(String.valueOf(qty));
        JTextField totalField = new JTextField(String.valueOf(total));

        Object[] message = {
                "Item:", itemField,
                "Price:", priceField,
                "Quantity:", qtyField,
                "Total:", totalField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Update Menu Item", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle")) {
                String query = "UPDATE MENU_INFO SET price=?, qty=?, total=? WHERE item=?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setDouble(1, Double.parseDouble(priceField.getText()));
                    ps.setInt(2, Integer.parseInt(qtyField.getText()));
                    ps.setDouble(3, Double.parseDouble(totalField.getText()));
                    ps.setString(4, item);
                    ps.executeUpdate();
                    fetchMenuData();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void deleteMenuData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete");
            return;
        }

        String item = model.getValueAt(selectedRow, 0).toString();
        int qty = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
        double total = Double.parseDouble(model.getValueAt(selectedRow, 3).toString());
        
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this menu item?", "Delete Menu Item", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle")) {
                String query = "DELETE FROM MENU_INFO WHERE item=? AND qty=? AND total=?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, item);
                    ps.setInt(2, qty);
                    ps.setDouble(3, total);
                    ps.executeUpdate();
                    fetchMenuData();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void deleteSpecificMenuItem() {
        JTextField itemField = new JTextField();
        JTextField qtyField = new JTextField();
        JTextField totalField = new JTextField();

        Object[] message = {
            "Item:", itemField,
            "Quantity:", qtyField,
            "Total:", totalField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Delete Specific Menu Item", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle")) {
                String query = "DELETE FROM MENU_INFO WHERE item=? AND qty=? AND total=?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, itemField.getText());
                    ps.setInt(2, Integer.parseInt(qtyField.getText()));
                    ps.setDouble(3, Double.parseDouble(totalField.getText()));
                    ps.executeUpdate();
                    fetchMenuData();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addMenuData() {
        JTextField itemField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField qtyField = new JTextField();
        JTextField totalField = new JTextField();

        Object[] message = {
                "Item:", itemField,
                "Price:", priceField,
                "Quantity:", qtyField,
                "Total:", totalField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Menu Item", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle")) {
                String query = "INSERT INTO MENU_INFO (item, price, qty, total) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, itemField.getText());
                    ps.setDouble(2, Double.parseDouble(priceField.getText()));
                    ps.setInt(3, Integer.parseInt(qtyField.getText()));
                    ps.setDouble(4, Double.parseDouble(totalField.getText()));
                    ps.executeUpdate();
                    fetchMenuData();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
