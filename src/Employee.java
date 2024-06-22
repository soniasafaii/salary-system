import jdk.jshell.Snippet;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException;
//شناسه منحصر به فرد جهانی که تضمین میکند هر ایدی یونیک است Universally Unique Identifier

public class Employee {
    private String nationalCode;
    private String fathersName;
    private String name;
    private String lastName;
    private int empID;
    //private List<Salary> salaryHistory;
    private Boolean isManager;
    private Department department;
    //private List<Status> statusHistory;
    //private Salary currentSalary;
    private int wExperience;
    //private Status currentStatus;


    public Employee (String name, int empID,String lastName , int wExperience){
        //Constructor: مقدار دهی اولیه ویژگی ها
        this.name = name;
        this.lastName = lastName;
        this.wExperience = wExperience;
        this.empID = Utility.generateUniqueID();
        //this.salaryHistory = new ArrayList<>();//به عنوان لیست خالی در نظر گرفته میشود
        //this.statusHistory = new ArrayList<>();//لیست خالی
        this.isManager = false;// در ابتدا مدیر نیست
        this.department = null;// در ابتدا در هیچ دپارتمنتی نیست
        //this.currentSalary = null;
        //this.currentStatus = null;

    }

    //methods to generate unique ID

    //public void setCurrentStatus(Status status){
    //if(status != null){
    //this.currentStatus = status;
    //this.statusHistory.add(status);// add new status to status history
    //}
    //}
    //public void setCurrentSalary(Salary currentSalary){
    //if(currentSalary != null){
    //this.currentSalary = currentSalary;
    //this.salaryHistory.add(currentSalary);//add to salary history}
    //}
    //}

    // public List<Salary> getSalaryHistory(){
    //return salaryHistory;
    //}
    public void setIsManager(Boolean isManager){
        this.isManager = isManager;
    }
    //public List<Status> getStatusHistory(){
    //return statusHistory;
    //}
    //getter and setter
    public String getName(){
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    //public void setSalaryHistory(List<Salary> salaryHistory) {
    //this.salaryHistory = salaryHistory;
    // }

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public Department getDepartment() {
    return department;
     }

    public void setDepartment(Department department) {
    this.department = department;
    }

    // public void setStatusHistory(List<Status> statusHistory) {
    // this.statusHistory = statusHistory;
    //  }

    // public Salary getCurrentSalary() {
    //return currentSalary;
    //}

    public int getwExperience() {
        return wExperience;
    }

    public void setwExperience(int wExperience) {
        this.wExperience = wExperience;
    }

    //public Status getCurrentStatus() {
    //return currentStatus;
    //}
    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public void saveEmployeeToFile(){
        try (FileWriter writer = new FileWriter("employees", true)) {
            writer.write(this.toString() + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {//بقیه ی اطلاعات استتوس و سلری رو یادت نره اضاقه کنی
        return "Name: " + name + "\n" +
                "Last Name: " + lastName + "\n" +
                "Employee ID: " + empID + "\n" +
                "Work Experience: " + wExperience + " years\n" +
                "National Code: " + nationalCode + "\n" +
                "Father's Name: " + fathersName + "\n" +
                "Is Manager: " + (isManager ? "Yes" : "No") + "\n";
    }
}


