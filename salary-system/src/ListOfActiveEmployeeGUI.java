import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListOfActiveEmployeeGUI {
    private Department department;
    private JTextArea resultArea;

    public ListOfActiveEmployeeGUI(Department department) {
        this.department = department;
        JFrame frame = new JFrame("List of Active Employees");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        Font font = new Font("Times New Roman", Font.PLAIN, 16);

        resultArea = new JTextArea();
        resultArea.setFont(font);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        displayActiveEmployees();

        frame.setVisible(true);
    }

    private void displayActiveEmployees() {
        List<Employee> employees = department.getEmployees(); // فرض کنید متد getEmployees در کلاس Department تعریف شده
        StringBuilder sb = new StringBuilder();
        for (Employee emp : employees) {
            if (emp.getCurrentStatus().getIsActive()) {
                sb.append("Name: ").append(emp.getName()).append("\n")
                        .append("Last Name: ").append(emp.getLastName()).append("\n")
                        .append("Employee ID: ").append(emp.getEmpID()).append("\n")
                        .append("National Code: ").append(emp.getNationalCode()).append("\n")
                        .append("Father's Name: ").append(emp.getFathersName()).append("\n")
                        .append("Is Manager: ").append(emp.getManager()).append("\n")
                        .append("Work Experience: ").append(emp.getwExperience()).append(" years\n")
                        .append("Current Status: Active\n")
                        .append("----------\n");
            }
        }
        resultArea.setText(sb.toString());
    }
}
