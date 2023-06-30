import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerFormGUI extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField ageField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    public CustomerFormGUI() {
        super("Customer Form");

        // Create form components
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        ageField = new JTextField(3);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        // Create buttons
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        // Create action listeners for buttons
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String age = ageField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";

                // Display collected data
                String message = "First Name: " + firstName + "\n" +
                        "Last Name: " + lastName + "\n" +
                        "Age: " + age + "\n" +
                        "Gender: " + gender;

                JOptionPane.showMessageDialog(CustomerFormGUI.this, message, "Customer Demographics", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Group the gender radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Create panel for form components
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // First Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(firstNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(firstNameField, gbc);

        // Last Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lastNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(lastNameField, gbc);

        // Age
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(ageField, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(genderLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(maleRadioButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        formPanel.add(femaleRadioButton, gbc);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        // Create main panel and add form and button panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerFormGUI();
            }
        });
    }
}
