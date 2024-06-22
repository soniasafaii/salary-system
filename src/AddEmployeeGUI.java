import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeGUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField wExperienceField;
    private JTextField nationalCodeField;
    private JTextField fathersNameField;
    private JTextField empIDField;
    private JRadioButton isManagerYes;
    private JRadioButton isManagerNo;
    private JComboBox<String> salaryTypeComboBox;
    private JTextField salaryField;
    private JTextField departmentField;

    public AddEmployeeGUI() {
        frame = new JFrame("Add employee");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(14, 2, 5, 5));

        Font font = new Font("Times New Roman", Font.PLAIN, 14);

        JLabel nameLabel = new JLabel("name :");
        nameLabel.setFont(font);
        nameField = new JTextField();
        nameField.setFont(font);

        JLabel lastNameLabel = new JLabel("lastName :");
        lastNameLabel.setFont(font);
        lastNameField = new JTextField();
        lastNameField.setFont(font);

        JLabel wExperienceLabel = new JLabel("work experience :");
        wExperienceLabel.setFont(font);
        wExperienceField = new JTextField();
        wExperienceField.setFont(font);

        JLabel nationalCodeLabel = new JLabel("national code :");
        nationalCodeLabel.setFont(font);
        nationalCodeField = new JTextField();
        nationalCodeField.setFont(font);

        JLabel fathersNameLabel = new JLabel("father's name :");
        fathersNameLabel.setFont(font);
        fathersNameField = new JTextField();
        fathersNameField.setFont(font);

        JLabel empIDLabel = new JLabel("employee ID :");
        empIDLabel.setFont(font);
        empIDField = new JTextField();
        empIDField.setFont(font);
        empIDField.setEditable(false); // generated automatically

        JLabel isManagerLabel = new JLabel("is manager :");
        isManagerLabel.setFont(font);
        isManagerYes = new JRadioButton("Yes");
        isManagerYes.setFont(font);
        isManagerYes.setBackground(new Color(255, 225, 225));
        isManagerNo = new JRadioButton("No");
        isManagerNo.setFont(font);
        isManagerNo.setBackground(new Color(255, 228, 225));

        JLabel salaryTypeLabel = new JLabel("salary type:");
        salaryTypeLabel.setFont(font);
        salaryTypeComboBox = new JComboBox<>(new String[]{"FixedSalary", "HourlyWage", "Commission", "FixedPlusCommission"});
        salaryTypeComboBox.setFont(font);
        salaryTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) salaryTypeComboBox.getSelectedItem();
                salaryField.setText(""); // Clear previous input
                switch (selectedType) {
                    case "FixedSalary":
                        salaryField.setText("fexed salary");
                        break;
                    case "HourlyWage":
                        salaryField.setText("Hourly wage");
                        break;
                    case "Commission":
                        salaryField.setText("commission");
                        break;
                    case "FixedPlusCommission":
                        salaryField.setText("fixed plus commission");
                        break;
                }
            }
        });
        JLabel salaryLabel = new JLabel("Salary :");
        salaryLabel.setFont(font);
        salaryField = new JTextField();
        salaryField.setFont(font);

        JLabel departmentLabel = new JLabel("Department");
        departmentLabel.setFont(font);
        departmentField = new JTextField();
        departmentField.setFont(font);

        JButton addButton = new JButton("Add employee");
        addButton.setFont(font);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String lastName = lastNameField.getText();
                int wExperience = Integer.parseInt(wExperienceField.getText());
                String nationalCode = nationalCodeField.getText();
                String fathersName = fathersNameField.getText();
                boolean isManager = isManagerYes.isSelected();
                String salaryType = (String) salaryTypeComboBox.getSelectedItem();
                String salary = salaryField.getText();

                // Generate a unique employee ID
                int empID = Utility.generateUniqueID();
                empIDField.setText(String.valueOf(empID));

                // Create an employee object
                Employee employee = new Employee(name, empID, lastName, wExperience);
                employee.setNationalCode(nationalCode);
                employee.setFathersName(fathersName);
                employee.setIsManager(isManager);

                // Save employee to file
                employee.saveEmployeeToFile();

                // Display success message
                JOptionPane.showMessageDialog(frame, "employee added successfully! employee ID is:" + empID);
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(wExperienceLabel);
        frame.add(wExperienceField);
        frame.add(nationalCodeLabel);
        frame.add(nationalCodeField);
        frame.add(fathersNameLabel);
        frame.add(fathersNameField);
        frame.add(empIDLabel);
        frame.add(empIDField);
        frame.add(isManagerLabel);
        frame.add(isManagerYes);
        frame.add(new JLabel()); // Empty cell for layout
        frame.add(isManagerNo);
        frame.add(salaryTypeLabel);
        frame.add(salaryTypeComboBox);
        frame.add(salaryLabel);
        frame.add(salaryField);
        frame.add(departmentLabel);
        frame.add(departmentField);
        frame.add(new JLabel());
        frame.add(addButton);

        frame.setVisible(true);

    }
}

