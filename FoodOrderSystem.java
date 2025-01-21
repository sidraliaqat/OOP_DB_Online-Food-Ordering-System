import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FoodOrderSystem extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Double> menu;
    private Map<JCheckBox, Double> checkBoxes;
    private JLabel subtotalLabel;

    public FoodOrderSystem() {
        // Set the title of the window
        super("Food Order System");

        // Initialize the menu with item prices
        menu = new HashMap<>();
        menu.put("Burger", 5.99);
        menu.put("Pizza", 7.99);
        menu.put("Salad", 4.99);
        menu.put("Soda", 1.99);

        // Initialize the checkbox map
        checkBoxes = new HashMap<>();

        // Set layout
        setLayout(new GridLayout(0, 1));

        // Add checkboxes for each menu item
        for (Map.Entry<String, Double> entry : menu.entrySet()) {
            JCheckBox checkBox = new JCheckBox(entry.getKey() + " - $" + entry.getValue());
            checkBox.addActionListener(new ItemSelectionListener());
            checkBoxes.put(checkBox, entry.getValue());
            add(checkBox);
        }

        // Subtotal label
        subtotalLabel = new JLabel("Subtotal: $0.00");
        add(subtotalLabel);

        // Frame settings
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // ActionListener for handling checkbox selections
    private class ItemSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double subtotal = 0.0;
            for (Map.Entry<JCheckBox, Double> entry : checkBoxes.entrySet()) {
                if (entry.getKey().isSelected()) {
                    subtotal += entry.getValue();
                }
            }
            subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FoodOrderSystem());
    }
}
