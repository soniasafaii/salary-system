import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchEmployeeByIDGUI {
    private JFrame frame;
    private JTextField idField;
    private JTextArea resultArea;
    private Department department;

    public SearchEmployeeByIDGUI(Department department) {
        this.department = department;

        frame = new JFrame("Search Employee by ID");
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

        JButton searchButton = new JButton("Search");
        searchButton.setFont(font);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultArea.setText("");
                List<Employee> employees=department.getEmployees();
                for (int i=0;i<employees.size();i++){
                    if (employees.get(i).getEmpID().equals(idField.getText())){
                        resultArea.setText(employees.get(i).toString());
                    }
                }
                if (resultArea.getText().equals("")){
                    resultArea.setText("not found");
                }
            }
        });

        // Add empty labels to adjust the button's position
        inputPanel.add(new JLabel());
        inputPanel.add(searchButton);

        resultArea = new JTextArea();
        resultArea.setFont(font);
        resultArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }}
