package sidra;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Order extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private JPanel contentPane;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		setTitle("Welcome to Food Ordering System");
		setAlwaysOnTop(true);
		setForeground(new Color(139, 69, 19));
		setBackground(new Color(139, 69, 19));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HANI\\Music\\burger.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(218, 165, 32));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(297, 255, 187, 20);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(525, 0, 374, 489);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\burger.jpg"));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(-185, 0, 447, 505);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\pizza.jpg"));

		contentPane.add(lblNewLabel_1);

		TextField textField = new TextField();
		textField.setBounds(297, 174, 187, 22);
		contentPane.add(textField);

		Button button = new Button("Sign Up");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signup su = new Signup();
				su.show();
				dispose();

			}
		});	

		button.setBackground(new Color(128, 64, 0));

		

		button.setFont(new Font("Bell MT", Font.BOLD, 14));
		button.setBounds(415, 333, 84, 35);
		contentPane.add(button);
		Button button_1 = new Button("Sign In");
		button_1.setBackground(new Color(128, 64, 0));
		button_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println("Attempting login with username: " + username + " and password: " + password);
                boolean authenticated = authenticate(username, password);
                if (authenticated) {
                    System.out.println("Login successful!");

    				Menu m = new Menu();
    				m.show();
    				dispose();
                    // Proceed with your logic for successful login
                } else {
                    System.out.println("Invalid username or password. Please register yourself.");
                    // Prompt user to register or show a message
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please register yourself.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
		
		button_1.setFont(new Font("Bell MT", Font.BOLD, 14));
		button_1.setBounds(297, 333, 77, 35);
		contentPane.add(button_1);

		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setEditable(false);
		txtrUsername.setForeground(new Color(139, 69, 19));
		txtrUsername.setFont(new Font("Bell MT", Font.BOLD, 19));
		txtrUsername.setBackground(new Color(218, 165, 32));
		txtrUsername.setText("Username");
		txtrUsername.setBounds(272, 146, 92, 22);
		contentPane.add(txtrUsername);
		

		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setEditable(false);
		txtrPassword.setForeground(new Color(128, 64, 0));
		txtrPassword.setBackground(new Color(218, 165, 32));
		txtrPassword.setFont(new Font("Bell MT", Font.BOLD, 19));
		txtrPassword.setText("Password");
		txtrPassword.setBounds(272, 222, 92, 22);
		contentPane.add(txtrPassword);

		

		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setEditable(false);
		txtrWelcome.setForeground(new Color(139, 69, 19));
		txtrWelcome.setFont(new Font("Bell MT", Font.BOLD | Font.ITALIC, 37));
		txtrWelcome.setText("WELCOME");
		txtrWelcome.setBackground(new Color(218, 165, 32));
		txtrWelcome.setBounds(288, 55, 227, 69);
		contentPane.add(txtrWelcome);

		ImageIcon img = new ImageIcon("C:\\Users\\ALI\\Downloads\\burger.jpg");}

	private boolean authenticate(String username, String password) {
        boolean isAuthenticated = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");

            String query = "SELECT * FROM Customer_info WHERE username = ? AND password = ?";

            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            System.out.println("Executing query: " + ps);
            rs = ps.executeQuery();


            if (rs.next()) {
                isAuthenticated = true;
                System.out.println("User found in the database.");
            } else {
                System.out.println("User not found in the database.");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



        return isAuthenticated;

    }

}