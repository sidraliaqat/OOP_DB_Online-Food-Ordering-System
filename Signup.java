package sidra;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Signup extends JFrame {

private static final long serialVersionUID = 1L;
JPanel signup;
JTextField txtusername;
JTextField txtemail;
JTextField txtfirstname;
private JPasswordField txtpassword;
private JTextField txtlastname;
private JTextField txtcontact;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Signup frame = new Signup();
frame.signup.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public Signup() {
setType(Type.UTILITY);
setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HANI\\Music\\burger.jpg"));
setForeground(new Color(139, 69, 19));
setBackground(new Color(139, 69, 19));
setAlwaysOnTop(true);
setTitle("Sign Up");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 425, 509);
signup = new JPanel();
signup.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(signup);
signup.setLayout(null);

txtcontact = new JTextField();
txtcontact.setColumns(10);
txtcontact.setBounds(108, 362, 172, 27);
signup.add(txtcontact);

JTextArea txtrUsername_1_2 = new JTextArea();
txtrUsername_1_2.setText("Contact");
txtrUsername_1_2.setForeground(Color.BLACK);
txtrUsername_1_2.setFont(new Font("Monospaced", Font.BOLD, 16));
txtrUsername_1_2.setEditable(false);
txtrUsername_1_2.setBackground(new Color(218, 165, 32));
txtrUsername_1_2.setBounds(10, 362, 98, 27);
signup.add(txtrUsername_1_2);

txtlastname = new JTextField();
txtlastname.setColumns(10);
txtlastname.setBounds(105, 149, 175, 27);
signup.add(txtlastname);

JTextArea txtrUsername_1_1 = new JTextArea();
txtrUsername_1_1.setText("Last Name");
txtrUsername_1_1.setForeground(Color.BLACK);
txtrUsername_1_1.setFont(new Font("Monospaced", Font.BOLD, 16));
txtrUsername_1_1.setEditable(false);
txtrUsername_1_1.setBackground(new Color(218, 165, 32));
txtrUsername_1_1.setBounds(7, 147, 98, 27);
signup.add(txtrUsername_1_1);

txtpassword = new JPasswordField();
txtpassword.setBounds(108, 300, 172, 25);
signup.add(txtpassword);

JButton ok = new JButton("OK");
ok.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");
            conn.setAutoCommit(false);
            
            String query = "INSERT INTO Customer_info (first_name, last_name, username, email, password, contact) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, txtfirstname.getText());
            ps.setString(2, txtlastname.getText());
            ps.setString(3, txtusername.getText());
            ps.setString(4, txtemail.getText());
            ps.setString(5, txtpassword.getText());
            
            // Validate and parse contact number
            String contactStr = txtcontact.getText().trim(); // Trim to remove leading/trailing spaces
            if (!contactStr.isEmpty() && contactStr.matches("\\d+")) { // Ensure it contains only digits
                ps.setLong(6, Long.parseLong(contactStr));
            } else {
                System.err.println("Invalid contact number: " + contactStr);
            }
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                dispose(); // Assuming Signup extends JFrame

                // Open the previous frame (Order frame)
                Order orderFrame = new Order();
                orderFrame.setVisible(true);
            }

            conn.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
});


ok.setFont(new Font("Times New Roman", Font.BOLD, 15));
ok.setForeground(new Color(0, 0, 0));
ok.setBackground(new Color(139, 69, 19));
ok.setBounds(191, 417, 89, 23);
signup.add(ok);

txtfirstname = new JTextField();
txtfirstname.setColumns(10);
txtfirstname.setBounds(108, 99, 172, 27);
signup.add(txtfirstname);

JTextArea txtrUsername_1 = new JTextArea();
txtrUsername_1.setEditable(false);
txtrUsername_1.setText("First Name");
txtrUsername_1.setForeground(Color.BLACK);
txtrUsername_1.setFont(new Font("Monospaced", Font.BOLD, 15));
txtrUsername_1.setBackground(new Color(218, 165, 32));
txtrUsername_1.setBounds(10, 99, 98, 27);
signup.add(txtrUsername_1);

JTextArea txtrSignIn = new JTextArea();
txtrSignIn.setBackground(new Color(218, 165, 32));
txtrSignIn.setCaretColor(new Color(184, 134, 11));
txtrSignIn.setEditable(false);
txtrSignIn.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 36));
txtrSignIn.setText("Create Your Account");
txtrSignIn.setBounds(42, 30, 341, 49);
signup.add(txtrSignIn);

JTextArea txtrEmail_1 = new JTextArea();
txtrEmail_1.setEditable(false);
txtrEmail_1.setText("Password");
txtrEmail_1.setForeground(Color.BLACK);
txtrEmail_1.setFont(new Font("Monospaced", Font.BOLD, 16));
txtrEmail_1.setBackground(new Color(218, 165, 32));
txtrEmail_1.setBounds(10, 300, 98, 27);
signup.add(txtrEmail_1);

JTextArea txtrEmail = new JTextArea();
txtrEmail.setEditable(false);
txtrEmail.setText("Email");
txtrEmail.setForeground(Color.BLACK);
txtrEmail.setFont(new Font("Monospaced", Font.BOLD, 16));
txtrEmail.setBackground(new Color(218, 165, 32));
txtrEmail.setBounds(10, 250, 98, 27);
signup.add(txtrEmail);

txtemail = new JTextField();
txtemail.setColumns(10);
txtemail.setBounds(108, 250, 172, 29);
signup.add(txtemail);

JTextArea txtrUsername = new JTextArea();
txtrUsername.setEditable(false);
txtrUsername.setFont(new Font("Monospaced", Font.BOLD, 16));
txtrUsername.setBackground(new Color(218, 165, 32));
txtrUsername.setForeground(new Color(0, 0, 0));
txtrUsername.setText("Username");
txtrUsername.setBounds(10, 198, 98, 27);
signup.add(txtrUsername);

txtusername = new JTextField();
txtusername.setBounds(108, 200, 172, 27);
signup.add(txtusername);
txtusername.setColumns(10);

JLabel lblNewLabel = new JLabel("New label");
lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\ddd.jpg"));
lblNewLabel.setBounds(0, 3, 591, 467);
signup.add(lblNewLabel);
}

public void setvisible(boolean b) {

}
}
