package sidra;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class OrderForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextArea txtrFillTheDetails;
    private JTextField Phoneno;
    private JTextField Address;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderForm frame = new OrderForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public OrderForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 485, 314);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 204, 0));
        panel.setBounds(0, 0, 469, 275);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (27).png"));
        lblNewLabel.setBounds(25, 154, 138, 121);
        panel.add(lblNewLabel);

        name = new JTextField();
        name.setBounds(172, 44, 194, 22);
        panel.add(name);
        name.setColumns(10);

        txtrFillTheDetails = new JTextArea();
        txtrFillTheDetails.setEditable(false);
        txtrFillTheDetails.setForeground(new Color(0, 0, 0));
        txtrFillTheDetails.setFont(new Font("Monospaced", Font.BOLD, 15));
        txtrFillTheDetails.setBackground(new Color(255, 204, 0));
        txtrFillTheDetails.setText("Fill the details below");
        txtrFillTheDetails.setBounds(45, 11, 241, 22);
        panel.add(txtrFillTheDetails);

        JTextPane txtpnName = new JTextPane();
        txtpnName.setBackground(new Color(255, 204, 0));
        txtpnName.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
        txtpnName.setText("Name");
        txtpnName.setBounds(69, 44, 82, 30);
        panel.add(txtpnName);

        JTextPane txtpnPhoneNo = new JTextPane();
        txtpnPhoneNo.setText("Phone No");
        txtpnPhoneNo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
        txtpnPhoneNo.setBackground(new Color(255, 204, 0));
        txtpnPhoneNo.setBounds(69, 85, 104, 30);
        panel.add(txtpnPhoneNo);

        JTextPane txtpnAddress = new JTextPane();
        txtpnAddress.setText("Address");
        txtpnAddress.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
        txtpnAddress.setBackground(new Color(255, 204, 0));
        txtpnAddress.setBounds(69, 126, 82, 30);
        panel.add(txtpnAddress);

        Phoneno = new JTextField();
        Phoneno.setColumns(10);
        Phoneno.setBounds(172, 85, 194, 22);
        panel.add(Phoneno);

        Address = new JTextField();
        Address.setColumns(10);
        Address.setBounds(172, 126, 194, 60);
        panel.add(Address);

        JButton btnNewButton = new JButton("Confirm");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;
                PreparedStatement ps = null;
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");
                    String query = "INSERT INTO Delivery_INFO (name, Phoneno, Address) VALUES (?, ?, ?)";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, name.getText());
                    ps.setString(2, Phoneno.getText());
                    ps.setString(3, Address.getText());

                    int rowsInserted = ps.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(OrderForm.this, "Order Placed Successfully!");
                        System.out.println("Info added successfully.");
                    } else {
                        JOptionPane.showMessageDialog(OrderForm.this, "Order Placement Failed.");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(OrderForm.this, "Error: " + e1.getMessage());
                } finally{
                    try {
                        if (ps != null) ps.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                dispose();
                System.exit(0);
            }
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(204, 0, 0));
        btnNewButton.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 15));
        btnNewButton.setBounds(318, 208, 114, 42);
        panel.add(btnNewButton);
    }
}
