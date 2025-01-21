package sidra;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Data extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton addButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Data frame = new Data();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Data() {
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

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addButton);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateCustomerData();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteCustomerData();
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCustomerData();
            }
        });

        fetchCustomerData();
    }

    private void fetchCustomerData() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");

            String query = "SELECT name, phoneno, address FROM DELIVERY_INFO";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            model = new DefaultTableModel(
                    new Object[]{"Name", "Phone No", "Address"}, 0);

            while (rs.next()) {
                String name = rs.getString("name");
                String phoneno = rs.getString("phoneno");
                String address = rs.getString("address");
                model.addRow(new Object[]{name, phoneno, address});
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

    private void updateCustomerData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update");
            return;
        }
        String name = model.getValueAt(selectedRow, 0).toString();
        String phoneno = model.getValueAt(selectedRow, 1).toString();
        String address = model.getValueAt(selectedRow, 2).toString();
        // Show input dialog to get new values
        JTextField nameField = new JTextField(name);
        JTextField phonenoField = new JTextField(phoneno);
        JTextField addressField = new JTextField(address);

        Object[] message = {
                "Name:", nameField,
                "Phone No:", phonenoField,
                "Address:", addressField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Update Customer", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle")) {
                String query = "UPDATE DELIVERY_INFO SET name=?, phoneno=?, address=? WHERE name=?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, nameField.getText());
                    ps.setString(2, phonenoField.getText());
                    ps.setString(3, addressField.getText());
                    ps.setString(4, name);
                    ps.executeUpdate();
                    fetchCustomerData();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void deleteCustomerData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete");
            return;
        }

        String name = model.getValueAt(selectedRow, 0).toString();
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this customer?", "Delete Customer", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle")) {
                String query = "DELETE FROM DELIVERY_INFO WHERE name=?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, name);
                    ps.executeUpdate();
                    fetchCustomerData();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void addCustomerData() {
        JTextField nameField = new JTextField();
        JTextField phonenoField = new JTextField();
        JTextField addressField = new JTextField();

        Object[] message = {
                "Name:", nameField,
                "Phone No:", phonenoField,
                "Address:", addressField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Customer", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle")) {
                String query = "INSERT INTO DELIVERY_INFO (name, phoneno, address) VALUES (?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, nameField.getText());
                    ps.setString(2, phonenoField.getText());
                    ps.setString(3, addressField.getText());
                    ps.executeUpdate();
                    fetchCustomerData();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
