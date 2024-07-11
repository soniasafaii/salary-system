import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchEmployeeByWExperienceGUI {
    private JFrame frame;
    private JTextField minExperienceField;
    private JTextField maxExperienceField;
    private JTextArea resultArea;
    private Department department;

    public SearchEmployeeByWExperienceGUI(Department department) {
        this.department = department;

        frame = new JFrame("Search Employee by Experience");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Font font = new Font("Times New Roman", Font.PLAIN, 16);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Min Experience Label and Field
        JLabel minExperienceLabel = new JLabel("Minimum Experience:");
        minExperienceLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(minExperienceLabel, gbc);

        minExperienceField = new JTextField(10);
        minExperienceField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(minExperienceField, gbc);

        // Max Experience Label and Field
        JLabel maxExperienceLabel = new JLabel("Maximum Experience:");
        maxExperienceLabel.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(maxExperienceLabel, gbc);

        maxExperienceField = new JTextField(10);
        maxExperienceField.setFont(font);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(maxExperienceField, gbc);

        // Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setFont(font);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");

                try {
                    int minExperience = Integer.parseInt(minExperienceField.getText());
                    int maxExperience = Integer.parseInt(maxExperienceField.getText());

                    List<Employee> employees = department.getEmployees();
                    boolean found = false;

                    for (Employee emp : employees) {
                        int empExperience = emp.getwExperience();
                        if (empExperience >= minExperience && empExperience <= maxExperience) {
                            resultArea.append(emp.toString() + "\n");
                            found = true;
                        }
                    }

                    if (!found) {
                        resultArea.setText("No employees found with specified experience range.");
                    }
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input for experience fields.");
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
