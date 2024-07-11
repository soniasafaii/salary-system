import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentGUI {
    private JFrame frame;
    private Department department;

    public DepartmentGUI() {
        EmployeeFileManager employeeFileManager = new EmployeeFileManager();
        department = new Department("IT"); // ایجاد یک دپارتمان نمونه با نام IT
        department.setEmployees(employeeFileManager.readEmployeesFromFile());
        frame = new JFrame("Department Management");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(10, 1, 5, 5));

        Font font = new Font("Times New Roman", Font.PLAIN, 16);

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setFont(font);
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployeeGUI(); // هدایت به صفحه افزودن کارمند
            }

        });

        JButton removeEmployeeButton = new JButton("Remove Employee");
        removeEmployeeButton.setFont(font);
        removeEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployeeGUI(department ,employeeFileManager);
            }
        });

        JButton changeManagerButton = new JButton("Change Manager");
        changeManagerButton.setFont(font);
        changeManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // کد برای تغییر مدیر
            }
        });

        JButton searchEmployeeByNameButton = new JButton("Search Employee by Name");
        searchEmployeeByNameButton.setFont(font);
        searchEmployeeByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployeeByNameGUI(department);
            }
        });

        JButton searchEmployeeByIDButton = new JButton("Search Employee by ID");
        searchEmployeeByIDButton.setFont(font);
        searchEmployeeByIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployeeByIDGUI(department);
            }
        });

        JButton filterEmployeeBySalaryTypeButton = new JButton("Filter Employee by Salary Type");
        filterEmployeeBySalaryTypeButton.setFont(font);
        filterEmployeeBySalaryTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // کد برای فیلتر کردن کارمندان بر اساس نوع حقوق
            }
        });

        JButton filterEmployeeByWExperienceButton = new JButton("Filter Employee by Work Experience");
        filterEmployeeByWExperienceButton.setFont(font);
        filterEmployeeByWExperienceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployeeByWExperienceGUI(department);

            }
        });

        JButton listOfActiveEmployeesButton = new JButton("List of Active Employees");
        listOfActiveEmployeesButton.setFont(font);
        listOfActiveEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new  ListOfActiveEmployeeGUI(department);
            }
        });

        JButton historyOfChangeManagementButton = new JButton("History of Change Management");
        historyOfChangeManagementButton.setFont(font);
        historyOfChangeManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // کد برای نمایش تاریخچه تغییر مدیریت
            }
        });

        JButton generateRandomEmployeeButton = new JButton("Generate Random Employee");
        generateRandomEmployeeButton.setFont(font);
        generateRandomEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // کد برای ایجاد کارمند تصادفی
            }
        });

        frame.add(addEmployeeButton);
        frame.add(removeEmployeeButton);
        frame.add(changeManagerButton);
        frame.add(searchEmployeeByNameButton);
        frame.add(searchEmployeeByIDButton);
        frame.add(filterEmployeeBySalaryTypeButton);
        frame.add(filterEmployeeByWExperienceButton);
        frame.add(listOfActiveEmployeesButton);
        frame.add(historyOfChangeManagementButton);
        frame.add(generateRandomEmployeeButton);

        frame.setVisible(true);
    }


}
