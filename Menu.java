package sidra;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane; // Declare JTabbedPane instance at the class level
	private JTable Billl;
	private JTextField txtBill;
	int total;
	private JTextField gtotal;

	/**
	 * Create the frame.
	 */
	public Menu() {
		
		DefaultTableModel model = new DefaultTableModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1247, 483);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_13 = new JButton("ORDER NOW");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OrderForm o = new OrderForm();
				o.show();
				dispose();
			}
		});
		btnNewButton_13.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 15));
		btnNewButton_13.setBackground(new Color(204, 0, 0));
		btnNewButton_13.setForeground(new Color(255, 255, 255));
		btnNewButton_13.setBounds(1064, 363, 157, 70);
		contentPane.add(btnNewButton_13);

		JPanel panel = new JPanel();
		panel.setBounds(216, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1237, 55);
		panel_1.setBackground(Color.BLACK);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Menu Items");
		lblNewLabel_4.setFocusTraversalKeysEnabled(false);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 40));
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(0, 0, 995, 55);
		panel_1.add(lblNewLabel_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 50, 217, 400);
		panel_2.setBackground(new Color(255, 215, 0));
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JPanel Burger_Pannel = new JPanel();
		Burger_Pannel.setBackground(new Color(240, 230, 140));
		Burger_Pannel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		Burger_Pannel.setBounds(0, 47, 217, 35);
		panel_2.add(Burger_Pannel);
		Burger_Pannel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Burger");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(71, 0, 68, 35);
		lblNewLabel.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 20));
		Burger_Pannel.add(lblNewLabel);

		JPanel Pizza_Pannel = new JPanel();
		Pizza_Pannel.setBackground(new Color(240, 230, 140));
		Pizza_Pannel.setBounds(0, 101, 217, 35);
		Pizza_Pannel.setLayout(null);
		Pizza_Pannel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel_2.add(Pizza_Pannel);

		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setBounds(67, 0, 68, 35);
		lblPizza.setHorizontalAlignment(SwingConstants.CENTER);
		lblPizza.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 20));
		Pizza_Pannel.add(lblPizza);

		JPanel Drinks_Pannel = new JPanel();
		Drinks_Pannel.setBackground(new Color(240, 230, 140));
		Drinks_Pannel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		Drinks_Pannel.setBounds(0, 155, 217, 35);
		panel_2.add(Drinks_Pannel);
		Drinks_Pannel.setLayout(null);

		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setHorizontalAlignment(SwingConstants.CENTER);
		lblDrinks.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 20));
		lblDrinks.setBounds(72, 0, 72, 35);
		Drinks_Pannel.add(lblDrinks);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(216, 22, 572, 431);
		contentPane.add(tabbedPane);

		JPanel Burger = new JPanel();
		tabbedPane.addTab("Burger", null, Burger, null);
		Burger.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(0, -1, 577, 401);
		Burger.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("+\r\n");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Jalapeno Crunch";
				int price = 800;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				total+= price ;
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(204, 0, 0));
		btnNewButton_4.setBounds(302, 334, 41, 23);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("+\r\n");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Special Burger";
				int price = 800;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(204, 0, 0));
		btnNewButton_5.setBounds(484, 334, 41, 23);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton = new JButton("+\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = "Chicken Burger";
				int price = 500;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				total+= price ;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton.setBackground(new Color(204, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(130, 157, 41, 23);
		panel_3.add(btnNewButton);
		
		JTextArea txtrRs = new JTextArea();
		txtrRs.setEditable(false);
		txtrRs.setText("Rs 500");
		txtrRs.setForeground(Color.WHITE);
		txtrRs.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs.setBackground(Color.BLACK);
		txtrRs.setBounds(33, 145, 69, 22);
		panel_3.add(txtrRs);
		
		JTextArea txtrRs_2 = new JTextArea();
		txtrRs_2.setEditable(false);
		txtrRs_2.setText("Rs 580");
		txtrRs_2.setForeground(Color.WHITE);
		txtrRs_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_2.setBackground(Color.BLACK);
		txtrRs_2.setBounds(198, 145, 78, 30);
		panel_3.add(txtrRs_2);
		
		JTextArea txtrRs_2_1 = new JTextArea();
		txtrRs_2_1.setEditable(false);
		txtrRs_2_1.setText("Rs 750");
		txtrRs_2_1.setForeground(Color.WHITE);
		txtrRs_2_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_2_1.setBackground(Color.BLACK);
		txtrRs_2_1.setBounds(386, 146, 88, 16);
		panel_3.add(txtrRs_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\Screenshot_2024-06-05_050052-removebg-preview.png"));
		lblNewLabel_1.setBounds(188, 11, 155, 118);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\Screenshot_2024-06-05_050453-removebg-preview.png"));
		lblNewLabel_1_1.setBounds(371, 182, 155, 118);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\Screenshot_2024-06-05_050509-removebg-preview.png"));
		lblNewLabel_1_2.setBounds(376, 11, 155, 118);
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\Screenshot_2024-06-05_050500-removebg-preview.png"));
		lblNewLabel_1_4.setBounds(207, 186, 155, 118);
		panel_3.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("New label");
		lblNewLabel_1_4_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (5).png"));
		lblNewLabel_1_4_1.setBounds(18, 191, 179, 109);
		panel_3.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("New label");
		lblNewLabel_1_4_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
		lblNewLabel_1_4_2.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (7).png"));
		lblNewLabel_1_4_2.setBounds(23, 25, 139, 109);
		panel_3.add(lblNewLabel_1_4_2);
		
		JTextArea txtrChickenBurger = new JTextArea();
		txtrChickenBurger.setEditable(false);
		txtrChickenBurger.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrChickenBurger.setText("Chicken Burger");
		txtrChickenBurger.setForeground(Color.WHITE);
		txtrChickenBurger.setBackground(Color.BLACK);
		txtrChickenBurger.setBounds(33, 128, 139, 22);
		panel_3.add(txtrChickenBurger);
		
		JTextArea txtrZingerBurger = new JTextArea();
		txtrZingerBurger.setEditable(false);
		txtrZingerBurger.setText("Zinger Burger");
		txtrZingerBurger.setForeground(Color.WHITE);
		txtrZingerBurger.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrZingerBurger.setBackground(Color.BLACK);
		txtrZingerBurger.setBounds(204, 128, 139, 22);
		panel_3.add(txtrZingerBurger);
		
		JTextArea txtrDoubleDeckerburger = new JTextArea();
		txtrDoubleDeckerburger.setEditable(false);
		txtrDoubleDeckerburger.setText("Mighty ZInger");
		txtrDoubleDeckerburger.setForeground(Color.WHITE);
		txtrDoubleDeckerburger.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrDoubleDeckerburger.setBackground(Color.BLACK);
		txtrDoubleDeckerburger.setBounds(386, 128, 139, 22);
		panel_3.add(txtrDoubleDeckerburger);
		
		JTextArea txtrSubwayBurger = new JTextArea();
		txtrSubwayBurger.setEditable(false);
		txtrSubwayBurger.setText("Subway Burger");
		txtrSubwayBurger.setForeground(Color.WHITE);
		txtrSubwayBurger.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrSubwayBurger.setBackground(Color.BLACK);
		txtrSubwayBurger.setBounds(28, 302, 139, 22);
		panel_3.add(txtrSubwayBurger);
		
		JTextArea txtrJalapenoBurger = new JTextArea();
		txtrJalapenoBurger.setEditable(false);
		txtrJalapenoBurger.setText("Jalapeno Krunch");
		txtrJalapenoBurger.setForeground(Color.WHITE);
		txtrJalapenoBurger.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrJalapenoBurger.setBackground(Color.BLACK);
		txtrJalapenoBurger.setBounds(207, 301, 139, 22);
		panel_3.add(txtrJalapenoBurger);
		
		JTextArea txtrSpecialBurger = new JTextArea();
		txtrSpecialBurger.setEditable(false);
		txtrSpecialBurger.setText("Special Burger");
		txtrSpecialBurger.setForeground(Color.WHITE);
		txtrSpecialBurger.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrSpecialBurger.setBackground(Color.BLACK);
		txtrSpecialBurger.setBounds(387, 301, 139, 22);
		panel_3.add(txtrSpecialBurger);
		
		JTextArea txtrRs_2_1_1 = new JTextArea();
		txtrRs_2_1_1.setEditable(false);
		txtrRs_2_1_1.setText("Rs 380");
		txtrRs_2_1_1.setForeground(Color.WHITE);
		txtrRs_2_1_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_2_1_1.setBackground(Color.BLACK);
		txtrRs_2_1_1.setBounds(33, 322, 69, 16);
		panel_3.add(txtrRs_2_1_1);
		
		JTextArea txtrRs_2_1_2 = new JTextArea();
		txtrRs_2_1_2.setEditable(false);
		txtrRs_2_1_2.setText("Rs 800");
		txtrRs_2_1_2.setForeground(Color.WHITE);
		txtrRs_2_1_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_2_1_2.setBackground(Color.BLACK);
		txtrRs_2_1_2.setBounds(217, 321, 126, 16);
		panel_3.add(txtrRs_2_1_2);
		
		JTextArea txtrRs_2_1_3 = new JTextArea();
		txtrRs_2_1_3.setEditable(false);
		txtrRs_2_1_3.setText("Rs 800");
		txtrRs_2_1_3.setForeground(Color.WHITE);
		txtrRs_2_1_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_2_1_3.setBackground(Color.BLACK);
		txtrRs_2_1_3.setBounds(397, 321, 99, 16);
		panel_3.add(txtrRs_2_1_3);
		
		JButton btnNewButton_1 = new JButton("+\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Zinger Burger";
				int price = 550;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(204, 0, 0));
		btnNewButton_1.setBounds(302, 157, 41, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("+\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Mighty Zinger";
				int price = 750;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(204, 0, 0));
		btnNewButton_2.setBounds(484, 157, 41, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("+\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Subway Burger";
				int price = 380;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(204, 0, 0));
		btnNewButton_3.setBounds(130, 335, 41, 23);
		panel_3.add(btnNewButton_3);

		JPanel Pizza = new JPanel();
		tabbedPane.addTab("Pizza", null, Pizza, null);
		Pizza.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(0, 5, 559, 398);
		Pizza.add(panel_4);
		panel_4.setLayout(null);
		
		JComboBox Veg = new JComboBox();
		Veg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Veg.getSelectedItem().equals("Small Rs 500")) {
					

					String name = "Vegetable Pizza";
					int price = 500;
					
					int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					int tot = price * qty;
					
					final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					
					model.addRow(new Object[] {
							name,
							price,
							qty,
							tot,

					});
				}
				else
					if (Veg.getSelectedItem().equals("Medium Rs 1150")) {
        String name = "Vegetable Pizza(M)";
        int price = 1150;
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
        int tot = price * qty;
        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
        model.addRow(new Object[] { 
        		name, 
        		price, 
        		qty, 
        		tot });
        }
					else 
						if (Veg.getSelectedItem().equals("Large Rs 1500")) {
					        String name = "Vegetable Pizza(L)";
					        int price = 1500;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
						else if (Veg.getSelectedItem().equals("Party Rs 2500")) {
					        String name = "Vegetable Pizza(XL)";
					        int price = 2500;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
			}
		});
		Veg.setBackground(Color.BLACK);
		Veg.setForeground(Color.WHITE);
		Veg.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
		Veg.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Small Rs 500", "Medium Rs 1150", "Large Rs 1500", "Party Rs 2500"}));
		Veg.setToolTipText("");
		Veg.setBounds(59, 161, 112, 22);
		panel_4.add(Veg);
		
		JComboBox Faj = new JComboBox();
		Faj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Faj.getSelectedItem().equals("Small Rs 530")) {
					

					String name = "Chicken Fajita (S)";
					int price = 530;
					
					int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					int tot = price * qty;
					
					final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					
					model.addRow(new Object[] {
							name,
							price,
							qty,
							tot,

					});
				}
				else
					if (Faj.getSelectedItem().equals("Medium Rs 1230")) {
        String name = "Chicken Fajita(M)";
        int price = 1230;
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
        int tot = price * qty;
        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
        model.addRow(new Object[] { 
        		name, 
        		price, 
        		qty, 
        		tot });
        }
					else 
						if (Faj.getSelectedItem().equals("Large Rs 1590")) {
					        String name = "Chicken Fajita(L)";
					        int price = 1590;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
						else if (Faj.getSelectedItem().equals("Party Rs 2600")) {
					        String name = "Chicken Fajita(XL)";
					        int price = 2500;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
			}
		});
		Faj.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Small Rs 530", "Medium Rs 1230", "Large Rs 1590", "Party Rs 2600"}));
		Faj.setToolTipText("");
		Faj.setForeground(Color.WHITE);
		Faj.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
		Faj.setBackground(Color.BLACK);
		Faj.setBounds(242, 161, 112, 22);
		panel_4.add(Faj);
		
		JComboBox Pep = new JComboBox();
		Pep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Pep.getSelectedItem().equals("Small Rs 560")) {
					

					String name = "Pepporni Pizza(S)";
					int price = 560;
					
					int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					int tot = price * qty;
					
					final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					
					model.addRow(new Object[] {
							name,
							price,
							qty,
							tot,

					});
				}
				else
					if (Pep.getSelectedItem().equals("Medium Rs 1240")) {
        String name = "Pepporni Pizza(M)";
        int price = 1240;
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
        int tot = price * qty;
        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
        model.addRow(new Object[] { 
        		name, 
        		price, 
        		qty, 
        		tot });
        }
					else 
						if (Pep.getSelectedItem().equals("Large Rs 1700")) {
					        String name = "Pepporni Pizza(L)";
					        int price = 1700;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
						else if (Pep.getSelectedItem().equals("Party Rs 2700")) {
					        String name = "Pepporni Pizza(XL)";
					        int price = 2700;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
				
			}
		});
		Pep.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Small Rs 560", "Medium Rs 1240", "Large Rs 1700", "Party Rs 2700"}));
		Pep.setToolTipText("");
		Pep.setForeground(Color.WHITE);
		Pep.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
		Pep.setBackground(Color.BLACK);
		Pep.setBounds(417, 161, 112, 22);
		panel_4.add(Pep);
		
		JComboBox cc = new JComboBox();
		cc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cc.getSelectedItem().equals("Small Rs 620")) {
					

					String name = "Crown Crust(S)";
					int price = 620;
					
					int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					int tot = price * qty;
					
					final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					
					model.addRow(new Object[] {
							name,
							price,
							qty,
							tot,

					});
				}
				else
					if (cc.getSelectedItem().equals("Medium Rs 1320")) {
        String name = "Crown Crust(M)";
        int price = 1320;
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
        int tot = price * qty;
        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
        model.addRow(new Object[] { 
        		name, 
        		price, 
        		qty, 
        		tot });
        }
					else 
						if (cc.getSelectedItem().equals("Large Rs 1820")) {
					        String name = "Crown Crust(L)";
					        int price = 1820;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
						else if (cc.getSelectedItem().equals("Party Rs 2800")) {
					        String name = "Crown Crust(XL)";
					        int price = 2800;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
			}
			
		});
		cc.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Small Rs 620", "Medium Rs 1320", "Large Rs 1820", "Party Rs 2800"}));
		cc.setToolTipText("");
		cc.setForeground(Color.WHITE);
		cc.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
		cc.setBackground(Color.BLACK);
		cc.setBounds(417, 341, 112, 22);
		panel_4.add(cc);
		
		JComboBox tc = new JComboBox();
		tc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tc.getSelectedItem().equals("Small Rs 600")) {
					

					String name = "Thick Crust(S)";
					int price = 600;
					
					int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					int tot = price * qty;
					
					final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					
					model.addRow(new Object[] {
							name,
							price,
							qty,
							tot,

					});
				}
				else
					if (tc.getSelectedItem().equals("Medium Rs 1300")) {
        String name = "Thick Crust(M)";
        int price = 1300;
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
        int tot = price * qty;
        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
        model.addRow(new Object[] { 
        		name, 
        		price, 
        		qty, 
        		tot });
        }
					else 
						if (tc.getSelectedItem().equals("Large Rs 1800")) {
					        String name = "Thick Crust(L)";
					        int price = 1800;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
						else if (tc.getSelectedItem().equals("Party Rs 2800")) {
					        String name = "Thick Crust(XL)";
					        int price = 2800;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
			}
		});
		tc.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Small Rs 600", "Medium Rs 1300", "Large Rs 1800", "Party Rs 2800"}));
		tc.setToolTipText("");
		tc.setForeground(Color.WHITE);
		tc.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
		tc.setBackground(Color.BLACK);
		tc.setBounds(242, 341, 112, 22);
		panel_4.add(tc);
		
		JComboBox Bih = new JComboBox();
		Bih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Bih.getSelectedItem().equals("Small Rs 560")) {
					

					String name = "Bihari Kebab(S)";
					int price = 560;
					
					int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					int tot = price * qty;
					
					final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					
					model.addRow(new Object[] {
							name,
							price,
							qty,
							tot,

					});
				}
				else
					if (Bih.getSelectedItem().equals("Medium Rs 1240")) {
        String name = "Bihari Kebab(M)";
        int price = 1240;
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
        int tot = price * qty;
        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
        model.addRow(new Object[] { 
        		name, 
        		price, 
        		qty, 
        		tot });
        }
					else 
						if (Bih.getSelectedItem().equals("Large Rs 1700")) {
					        String name = "Bihari Kebab(L)";
					        int price = 1700;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
						else if (Bih.getSelectedItem().equals("Party Rs 2700")) {
					        String name = "Bihari Kebab(XL)";
					        int price = 2700;
					        int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
					        int tot = price * qty;
					        final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
					        model.addRow(new Object[] { 
					        		name, 
					        		price, 
					        		qty, 
					        		tot });
					        }
				
			}
		});
		Bih.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "Small Rs 560", "Medium Rs 1240", "Large Rs 1700", "Party Rs 2700"}));
		Bih.setToolTipText("");
		Bih.setForeground(Color.WHITE);
		Bih.setFont(new Font("Lucida Calligraphy", Font.BOLD, 12));
		Bih.setBackground(Color.BLACK);
		Bih.setBounds(59, 341, 112, 22);
		panel_4.add(Bih);
		
		JTextArea txtrPepporni = new JTextArea();
		txtrPepporni.setEditable(false);
		txtrPepporni.setText("Pepporni Pizza");
		txtrPepporni.setForeground(Color.WHITE);
		txtrPepporni.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrPepporni.setBackground(Color.BLACK);
		txtrPepporni.setBounds(366, 139, 139, 22);
		panel_4.add(txtrPepporni);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\ALI\\Pictures\\Screenshots\\Screenshot 2024-06-05 055755.png"));
		lblNewLabel_2.setBounds(8, 27, 163, 107);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (8).png"));
		lblNewLabel_2_1.setBounds(356, 9, 173, 138);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (9).png"));
		lblNewLabel_2_1_1.setBounds(195, 27, 173, 110);
		panel_4.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (13).png"));
		lblNewLabel_2_1_1_1.setBounds(-19, 178, 200, 142);
		panel_4.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\Screenshot_2024-06-05_060751-removebg-preview.png"));
		lblNewLabel_2_1_1_1_1.setBounds(195, 180, 169, 142);
		panel_4.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (16).png"));
		lblNewLabel_2_1_1_1_1_1.setBounds(362, 187, 169, 142);
		panel_4.add(lblNewLabel_2_1_1_1_1_1);
		
		JTextArea txtrVegPizza = new JTextArea();
		txtrVegPizza.setEditable(false);
		txtrVegPizza.setText("Vegetable Pizza");
		txtrVegPizza.setForeground(Color.WHITE);
		txtrVegPizza.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrVegPizza.setBackground(Color.BLACK);
		txtrVegPizza.setBounds(18, 139, 139, 22);
		panel_4.add(txtrVegPizza);
		
		JTextArea txtrFajitaPizza = new JTextArea();
		txtrFajitaPizza.setEditable(false);
		txtrFajitaPizza.setText("Chicken Fajita");
		txtrFajitaPizza.setForeground(Color.WHITE);
		txtrFajitaPizza.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrFajitaPizza.setBackground(Color.BLACK);
		txtrFajitaPizza.setBounds(205, 141, 139, 22);
		panel_4.add(txtrFajitaPizza);
		
		JTextArea txtrBihariKebab = new JTextArea();
		txtrBihariKebab.setEditable(false);
		txtrBihariKebab.setText("Bihari Kebab");
		txtrBihariKebab.setForeground(Color.WHITE);
		txtrBihariKebab.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrBihariKebab.setBackground(Color.BLACK);
		txtrBihariKebab.setBounds(10, 322, 139, 22);
		panel_4.add(txtrBihariKebab);
		
		JTextArea txtrThickCrust = new JTextArea();
		txtrThickCrust.setEditable(false);
		txtrThickCrust.setText("Thick Crust Special");
		txtrThickCrust.setForeground(Color.WHITE);
		txtrThickCrust.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrThickCrust.setBackground(Color.BLACK);
		txtrThickCrust.setBounds(197, 321, 155, 22);
		panel_4.add(txtrThickCrust);
		
		JTextArea txtrCrownCrust = new JTextArea();
		txtrCrownCrust.setEditable(false);
		txtrCrownCrust.setText("Crown Crust");
		txtrCrownCrust.setForeground(Color.WHITE);
		txtrCrownCrust.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrCrownCrust.setBackground(Color.BLACK);
		txtrCrownCrust.setBounds(374, 321, 139, 22);
		panel_4.add(txtrCrownCrust);

		JPanel Drinks = new JPanel();
		tabbedPane.addTab("Drinks", null, Drinks, null);
		Drinks.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(0, 0, 540, 398);
		Drinks.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton_12_2 = new JButton("+\r\n");
		btnNewButton_12_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Water";
				int price = 70;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					

			}
		});
		btnNewButton_12_2.setForeground(Color.WHITE);
		btnNewButton_12_2.setBackground(new Color(204, 0, 0));
		btnNewButton_12_2.setBounds(430, 240, 41, 23);
		panel_5.add(btnNewButton_12_2);
		
		JButton btnNewButton_12_1 = new JButton("+\r\n");
		btnNewButton_12_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Pepsi";
				int price = 100;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton_12_1.setForeground(Color.WHITE);
		btnNewButton_12_1.setBackground(new Color(204, 0, 0));
		btnNewButton_12_1.setBounds(274, 240, 41, 23);
		panel_5.add(btnNewButton_12_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (18).png"));
		lblNewLabel_3.setBounds(-43, 16, 170, 183);
		panel_5.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (20).png"));
		lblNewLabel_3_1.setBounds(205, 1, 91, 213);
		panel_5.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1.setIcon(new ImageIcon("C:\\Users\\ALI\\Downloads\\image-removebg-preview (22).png"));
		lblNewLabel_3_1_1.setBounds(366, 0, 91, 215);
		panel_5.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton_12 = new JButton("+\r\n");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = "Juice";
				int price = 150;
				
				int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));
				int tot = price * qty;
				
				final DefaultTableModel model = (DefaultTableModel) Billl.getModel();
				
				model.addRow(new Object[] {
						name,
						price,
						qty,
						tot,

				});
					
			}
		});
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setBackground(new Color(204, 0, 0));
		btnNewButton_12.setBounds(108, 240, 41, 23);
		panel_5.add(btnNewButton_12);
		
		JTextArea txtrJuice = new JTextArea();
		txtrJuice.setText("Juice");
		txtrJuice.setForeground(Color.WHITE);
		txtrJuice.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrJuice.setBackground(Color.BLACK);
		txtrJuice.setBounds(40, 207, 62, 22);
		panel_5.add(txtrJuice);
		
		JTextArea txtrPepsi = new JTextArea();
		txtrPepsi.setText("Pepsi");
		txtrPepsi.setForeground(Color.WHITE);
		txtrPepsi.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrPepsi.setBackground(Color.BLACK);
		txtrPepsi.setBounds(215, 210, 62, 19);
		panel_5.add(txtrPepsi);
		
		JTextArea txtrWater = new JTextArea();
		txtrWater.setText("Water");
		txtrWater.setForeground(Color.WHITE);
		txtrWater.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrWater.setBackground(Color.BLACK);
		txtrWater.setBounds(376, 209, 62, 19);
		panel_5.add(txtrWater);
		
		JTextArea txtrRs_1 = new JTextArea();
		txtrRs_1.setText("Rs 150");
		txtrRs_1.setForeground(Color.WHITE);
		txtrRs_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_1.setBackground(Color.BLACK);
		txtrRs_1.setBounds(40, 226, 62, 22);
		panel_5.add(txtrRs_1);
		
		JTextArea txtrRs_1_1 = new JTextArea();
		txtrRs_1_1.setText("Rs 100");
		txtrRs_1_1.setForeground(Color.WHITE);
		txtrRs_1_1.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_1_1.setBackground(Color.BLACK);
		txtrRs_1_1.setBounds(215, 226, 62, 22);
		panel_5.add(txtrRs_1_1);
		
		JTextArea txtrRs_1_2 = new JTextArea();
		txtrRs_1_2.setText("Rs 70");
		txtrRs_1_2.setForeground(Color.WHITE);
		txtrRs_1_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 13));
		txtrRs_1_2.setBackground(Color.BLACK);
		txtrRs_1_2.setBounds(376, 226, 62, 22);
		panel_5.add(txtrRs_1_2);
		
		// Add the table to a JScrollPane
		JScrollPane Bill = new JScrollPane();
		
		
		Bill.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Bill.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		Bill.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Bill.setBounds(790, 118, 447, 234);
		contentPane.add(Bill);

		Billl = new JTable();
		Billl.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Price", "Qty", "Total"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class
			};
			
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		Billl.setFont(new Font("WinCC_flexible_smart", Font.PLAIN, 14));
		Billl.setBorder(new LineBorder(new Color(0, 0, 0)));
		Billl.setSurrendersFocusOnKeystroke(true);
		Bill.setViewportView(Billl);
		
		txtBill = new JTextField();
		txtBill.setEditable(false);
		txtBill.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 23));
		txtBill.setHorizontalAlignment(SwingConstants.CENTER);
		txtBill.setForeground(new Color(255, 255, 255));
		txtBill.setBackground(new Color(0, 0, 0));
		txtBill.setText("BILL");
		txtBill.setBounds(757, 50, 480, 68);
		contentPane.add(txtBill);
		txtBill.setColumns(10);
		
		
		gtotal = new JTextField();
		gtotal.setFont(new Font("MS Gothic", Font.BOLD, 20));
		gtotal.setEditable(false);
		gtotal.setForeground(new Color(255, 0, 0));
		gtotal.setBackground(new Color(0, 0, 0));
		gtotal.setBounds(898, 375, 131, 45);
		contentPane.add(gtotal);
		gtotal.setColumns(10);
		
		JTextArea txtrTotal = new JTextArea();
		txtrTotal.setEditable(false);
		txtrTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int sum=0;
				for(int i=0; i < Billl.getRowCount(); i++) {
					sum= sum + Integer.parseInt(Billl.getValueAt(i, 3).toString());
				}
				gtotal.setText(Integer.toString(sum));
				Connection conn = null;
                PreparedStatement ps = null;

		        try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");
		            String query = "INSERT INTO Menu_INFO (item, price, qty, total) VALUES (?, ?, ?, ?)";
		            ps = conn.prepareStatement(query);
		            
		            DefaultTableModel model = (DefaultTableModel) Billl.getModel(); // Corrected variable name
		            for (int i = 0; i < model.getRowCount(); i++) {
		                String item = model.getValueAt(i, 0).toString();
		                int price = Integer.parseInt(model.getValueAt(i, 1).toString());
		                double qty = Double.parseDouble(model.getValueAt(i, 2).toString());
		                double total = Double.parseDouble(model.getValueAt(i, 3).toString());
		                
		                ps.setString(1, item);
		                ps.setInt(2, price);
		                ps.setDouble(3, qty);
		                ps.setDouble(4, total);

		                int rowsInserted = ps.executeUpdate();
		                if (rowsInserted > 0) {
		                    System.out.println("Row " + (i+1) + " inserted successfully.");
		                } else {
		                    System.out.println("Failed to insert row " + (i+1) + ".");
		                }
		            }
		        } catch (Exception e1) {
		            e1.printStackTrace();
		           
		        } finally {
		            try {
		                if (ps != null) ps.close();
		                if (conn != null) conn.close();
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
                try {
                    // Load Oracle JDBC driver
                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    // Establish connection to Oracle database
                    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sidra", "oracle");

                    // Disable auto-commit for transaction control
                    conn.setAutoCommit(false);

                    // SQL query to insert into ORDERS table
                    String query = "INSERT INTO ORDER_info (TOTAL) VALUES (?)";

                    // Create PreparedStatement with auto-generated keys support
                    ps = conn.prepareStatement(query);

                    // Set parameters for the PreparedStatement
                    ps.setString(1, gtotal.getText());

                    // Execute the insert statement
                    int rowsInserted = ps.executeUpdate();

                    // Check if insertion was successful
                    if (rowsInserted > 0) {
                        System.out.println("Order detail inserted successfully!");
                        // If this is a JFrame or JDialog, you may want to dispose it
                        // dispose(); // Make sure you handle closing of GUI components properly
                    }

                    // Commit the transaction
                    conn.commit();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    if (conn != null) {
                        try {
                            conn.rollback(); // Rollback transaction if there's an error
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }
                    }
                } finally {
                    // Close PreparedStatement and Connection in finally block to ensure they are released
                    if (ps != null) {
                        try {
                            ps.close();
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }
                    }
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException se) {
                            se.printStackTrace();
                        }
                    }
                }
            }
        });
		
		
		txtrTotal.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 20));
		txtrTotal.setBackground(Color.BLACK);
		txtrTotal.setForeground(Color.WHITE);
		txtrTotal.setText("TOTAL:");
		txtrTotal.setBounds(798, 382, 92, 32);
		contentPane.add(txtrTotal);
	}
}
