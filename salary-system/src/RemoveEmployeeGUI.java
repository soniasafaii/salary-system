import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveEmployeeGUI {
    private JFrame frame;
    private JTextField idField;
    private JTextArea resultArea;
    private Department department;
    private EmployeeFileManager fileManager;

    public RemoveEmployeeGUI(Department department, EmployeeFileManager fileManager) {
        this.department = department;
        this.fileManager = fileManager;

        frame = new JFrame("Remove Employee by ID");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        Font font = new Font("Times New Roman", Font.PLAIN, 14);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setFont(font);
        inputPanel.add(idLabel);

        idField = new JTextField(10);
        idField.setFont(font);
        inputPanel.add(idField);

        JButton removeButton = new JButton("Remove");
        removeButton.setFont(font);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                String idToRemove = idField.getText();
                boolean found = false;

                List<Employee> employees = department.getEmployees();
                for (Employee emp : employees) {
                    if (emp.getEmpID().equals(idToRemove)) {
                        emp.getCurrentStatus().setIsActive(false);
                        resultArea.setText(emp.toString() + "\nStatus deactivated.");
                        found = true;
                        break; // No need to continue searching once found
                    }
                }

                if (found) {
                    fileManager.updateEmployeesToFile(employees);
                } else {
                    resultArea.setText("Employee with ID " + idToRemove + " not found.");
                }
            }
        });

        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(removeButton);

        resultArea = new JTextArea();
        resultArea.setFont(font);
        resultArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
