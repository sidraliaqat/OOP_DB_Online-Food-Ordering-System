package sidra;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CustomerDataDisplay extends JFrame {

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
                    CustomerDataDisplay frame = new CustomerDataDisplay();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CustomerDataDisplay() {
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

            String query = "SELECT first_name, last_name, username, email, contact FROM Customer_info";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            model = new DefaultTableModel(
                    new Object[]{"First Name", "Last Name", "Username", "Email", "Contact"}, 0);

            while (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                model.addRow(new Object[]{firstName, lastName, username, email, contact});
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
        String firstName = model.getValueAt(selectedRow, 0).toString();
        String lastName = model.getValueAt(selectedRow, 1).toString();
        String username = model.getValueAt(selectedRow, 2).toString();
        String email = model.getValueAt(selectedRow, 3).toString();
        String contact = model.getValueAt(selectedRow, 4).toString();
        // Show input dialog to get new values
        JTextField firstNameField = new JTextField(firstName);
        JTextField lastNameField = new JTextField(lastName);
        JTextField usernameField = new JTextField(username);
        JTextField emailField = new JTextField(email);
        JTextField contactField = new JTextField(contact);

        Object[] message = {
                "First Name:", firstNameField,
                "Last Name:", lastNameField,
                "Username:", usernameField,
                "Email:", emailField,
                "Contact:", contactField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Update Customer", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {

            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");
                String query = "UPDATE Customer_info SET first_name=?, last_name=?, username=?, email=?, contact=? WHERE username=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, firstNameField.getText());
                ps.setString(2, lastNameField.getText());
                ps.setString(3, usernameField.getText());
                ps.setString(4, emailField.getText());
                ps.setString(5, contactField.getText());
                ps.setString(6, username);
                ps.executeUpdate();
                fetchCustomerData();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating customer: " + ex.getMessage());
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void deleteCustomerData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete");
            return;
        }

        String username = model.getValueAt(selectedRow, 2).toString();
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this customer?", "Delete Customer", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");
                String query = "DELETE FROM Customer_info WHERE username=?";
                ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.executeUpdate();
                fetchCustomerData();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting customer: " + ex.getMessage());
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void addCustomerData() {
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField usernameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField contactField = new JTextField();
        JPasswordField passwordField = new JPasswordField(); // Add password field

        Object[] message = {
                "First Name:", firstNameField,
                "Last Name:", lastNameField,
                "Username:", usernameField,
                "Email:", emailField,
                "Contact:", contactField,
                "Password:", passwordField // Include password field in the dialog
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Add Customer", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");
                String query = "INSERT INTO Customer_info (first_name, last_name, username, email, contact, password) VALUES (?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(query);
                ps.setString(1, firstNameField.getText());
                ps.setString(2, lastNameField.getText());
                ps.setString(3, usernameField.getText());
                ps.setString(4, emailField.getText());
                ps.setString(5, contactField.getText());
                ps.setString(6, new String(passwordField.getPassword())); // Insert the password

                int rowsInserted = ps.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Customer added successfully!");
                    fetchCustomerData(); // Refresh table to reflect the new data
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add customer. No rows affected.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding customer: " + ex.getMessage());
            } finally {
                try {
                    if (ps != null) ps.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
