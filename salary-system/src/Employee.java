import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String empID;
    private String name;
    private String lastName;
    private String nationalCode;
    private String fathersName;


    private List<Salary> salaryHistory;
    private Boolean isManager;
    private Department department;
    private List<Status> statusHistory;
    private Salary currentSalary;
    private int wExperience;
    private Status currentStatus;


    public Employee(String name, String empID, String lastName, int wExperience) {
        //Constructor: مقدار دهی اولیه ویژگی ها
        this.name = name;
        this.lastName = lastName;
        this.wExperience = wExperience;
        this.empID = empID;
        this.salaryHistory = new ArrayList<>();//به عنوان لیست خالی در نظر گرفته میشود
        this.statusHistory = new ArrayList<>();//لیست خالی
        this.isManager = false;// در ابتدا مدیر نیست
        this.department = null;// در ابتدا در هیچ دپارتمنتی نیست
        this.currentSalary = null;
        this.currentStatus = new Status(true, DeactivationReason.NONE);

    }

    //methods to generate unique ID

    public void setCurrentStatus(Status status) {
        if (status != null) {
            this.currentStatus = status;
            this.statusHistory.add(status);// add new status to status history
        }
    }
    //public void setCurrentSalary(Salary currentSalary){
    //if(currentSalary != null){
    //this.currentSalary = currentSalary;
    //this.salaryHistory.add(currentSalary);//add to salary history}
    //}
    //}

    // public List<Salary> getSalaryHistory(){
    //return salaryHistory;
    //}
    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    public List<Status> getStatusHistory() {
        return statusHistory;
    }

    //getter and setter
    public String getName() {
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

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    //public void setSalaryHistory(List<Salary> salaryHistory) {
    //this.salaryHistory = salaryHistory;
    // }

    public Boolean getManager() {
        return isManager;
    }



    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setStatusHistory(List<Status> statusHistory) {
        this.statusHistory = statusHistory;
    }

    // public Salary getCurrentSalary() {
    //return currentSalary;
    //}

    public int getwExperience() {
        return wExperience;
    }

    public void setwExperience(int wExperience) {
        this.wExperience = wExperience;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

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

    public void setCurrentStatus() {
        this.currentStatus = currentStatus;
        this.statusHistory.add(currentStatus);
    }

    @Override
    public String toString() {
        return empID + "," + name + "," + lastName + "," + nationalCode + "," + fathersName + ","+isManager+","+wExperience+","+currentStatus.toString();
    }


}


