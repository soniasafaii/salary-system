import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EmployeeFileManager {

    private FileWriter myWriter;

    public EmployeeFileManager() {
        try {
            myWriter = new FileWriter("filename.txt", true); // 'true' enables appending to the file

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void addEmployeeToFile(Employee employee) {
        try {
            myWriter.write(employee.toString() + "\n\n");
            myWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> readEmployeesFromFile() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("filename.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim(); // Trim to remove leading/trailing whitespace
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }
                String[] employeeData = line.split(",");
                String empId = employeeData[0];
                String name = employeeData[1];
                String lastName = employeeData[2];
                String nationalCode = employeeData[3];
                String fatherName = employeeData[4];
                boolean isManager = Boolean.parseBoolean(employeeData[5]);
                int wExperience = Integer.parseInt(employeeData[6]);
                DeactivationReason deactivationReason;
                switch (employeeData[8]) {
                    case "DOCOOPERATION":
                        deactivationReason = DeactivationReason.DOCOOPERATION;
                        break;
                    case "UNPAYOFF":
                        deactivationReason = DeactivationReason.UNPAYOFF;
                        break;
                    case "RETIREMENT":
                        deactivationReason = DeactivationReason.RETIREMENT;
                        break;
                    case "FIRED":
                        deactivationReason = DeactivationReason.FIRED;
                        break;
                    default:
                        deactivationReason = DeactivationReason.NONE;

                }
                DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date date = formatter.parse(employeeData[9]);
                Status currentStatus = new Status(Boolean.parseBoolean(employeeData[7]), deactivationReason);
                currentStatus.setDate(date);
                Employee employee=new Employee(name,empId,lastName,wExperience);
                employee.setIsManager(isManager);
                employee.setCurrentStatus(currentStatus);
                employee.setFathersName(fatherName);
                employee.setNationalCode(nationalCode);
                employee.setwExperience(wExperience);
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

//
public void updateEmployeesToFile(List<Employee> employees) {
    try (FileWriter writer = new FileWriter("filename.txt")) {
        for (Employee emp : employees) {
            writer.write(emp.toString() + "\n\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
