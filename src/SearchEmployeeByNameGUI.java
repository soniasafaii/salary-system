import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchEmployeeByNameGUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField lastNameField;
    private JTextArea resultArea;
    private Department department;

    public SearchEmployeeByNameGUI(Department department) {
        this.department = department;

        frame = new JFrame("Search Employee by Name");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Font font = new Font("Times New Roman", Font.PLAIN, 16);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Name Label
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(nameLabel, gbc);

        // Name Field
        nameField = new JTextField(10);
        nameField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(nameField, gbc);

        // Last Name Label
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(lastNameLabel, gbc);

        // Last Name Field
        lastNameField = new JTextField(10);
        lastNameField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(lastNameField, gbc);

        // Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setFont(font);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "E:\\finalpro3\\finalpro\\employees";
                System.out.println("Loading employees from file: " + filePath);
                department.loadEmployeesFromFile(filePath);
                String name = nameField.getText();
                String lastName = lastNameField.getText();
                List<Employee> employees = department.searchEmployeeByNameAndLastname(name , lastName);
                resultArea.setText("");
                if(employees.isEmpty()){
                    resultArea.setText("No employee found with given name and last name");
                }else{
                    for(Employee emp :employees ){
                        resultArea.append(emp.toString() +"\n---------------------------\n");
                    }
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(searchButton, gbc);

        // Result Area
        resultArea = new JTextArea();
        resultArea.setFont(font);
        resultArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}