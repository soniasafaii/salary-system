import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Department {
    private String deptID;
    private String name;
    private List<Employee> employees;
    private Employee manager;
    private Random random;
    //private List<ManagementChange> managementChanges;
    //constructor
    public Department(String name) {
        this.deptID = Utility.generateId();//تولید ایدی منحصر به فرد
        this.name = name;
        this.employees = new ArrayList<>();
        this.random = new Random();// برای نمونه تصادفی
        //this.managementChanges = new ArrayList<>();
        this.manager = null;
    }

    public void addEmployee(int empID , Employee emp){
        emp.setDepartment(this);
        this.employees.add(emp);//کارمند جدید emp را به لیست کارمندان اضافه میکند
    }
    //public void removeEmployeeDeactive
   // public void changeManager(Employee newManager){
     //   ManagementChange change = new ManagementChange(this.manager , newManager);
       // this.manager = newManager;
    //this.managementChanges.add(change);
    //}
    public List<Employee> getEmployees(){
        return employees;
    }
    //method to search an employee by name and lastname
//    public List<Employee> searchEmployeeByNameAndLastname(String name, String lastname){
//        return employees.stream()
//                .filter(emp -> emp.getName().equals(name) && emp.getLastName().equals(lastname))
//                .collect(Collectors.toList());
//    }

   /*public Employee generateRandomEmployee(){
        String[] names = {"ALI" , "SAHAR" , "NEGIN" , "MANI" , "FARHAD" ,"SONIYA" , "SAYEH" , "MOHAMMADREZA" , "AMIN" , "MATIN" ,
                "SHAHIN", "ESKANDAR" , "HAMID" , "MAHAN" , "FATEMEH" , "SANA" , "MOBINA" , "SABRINA" , "DORSA" , "ALARA" , "ARTA" , "RAHA" ,
                "ABTIN" , "SOHRAB" , "SAMIYAR" ,"NARGES" , "JAMILEH" ,"PARISA" , "KHATOON", "HADIS" , "MARAL" };

        String[] lastnames = {"SAFAII" , "RASOLI" , "ENAYATI", "ASGHARI" ,"AGHAEI" , "TAVOOSIKALENOEE" , "BAKHTIYARI" , "GHVIDEL" ,
                "IRANDOST" , "GHASEMI" , "NOROZI" , "CHAGHOMI" , "ISAKHANI" , "BAGHERI" ,"TIMOTIAN" , "SAJADI" , "HEYDARI" , "MAZLAGHANI",
                "ROZBEH" , "MOHAMMADI" , "BASHLIDEH" , "AKBARI"};

        String name = names[random.nextInt(names.length)];
        String lastName = lastnames[random.nextInt(lastnames.length)];
        int wExperience = random.nextInt(31);//random years of experience 0-30
        Employee emp = new Employee(name ,Utility.generateUniqueID() , lastName , wExperience);
        //set deafult active status
        Status activeStatus = new Status(true , DeactivationReason.NONE);
        emp.setCurrentStatus(activeStatus);
        employees.add(emp);
        return emp;

    }*/
   //public List<ManagementChange> getManagementChanges() {
       //return managementChanges;
  //}
   /*public List<Employee> filterEmployeesBasedOnBeingActive(boolean isActive) {
       return employees.stream()
               .filter(emp -> emp.getCurrentStatus().isActive()== isActive)
               .collect(Collectors.toList());
   }*/
   public List<Employee> filterEmployeeBasedOnWExperience(int wExperience){
       return employees.stream()
               .filter(emp -> emp.getwExperience() == wExperience)
               .collect(Collectors.toList());
   }
    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    /*public void setManagementChanges(List<ManagementChange> managementChanges) {
        this.managementChanges = managementChanges;
    }*/

}
