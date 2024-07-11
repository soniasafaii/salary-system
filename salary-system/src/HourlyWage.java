import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HourlyWage extends Salary {
 private static final double HOURLY_WAGE = 20; // حقوق ساعتی به صورت final تعریف شده است
 private Employee employee;

 public HourlyWage(Employee employee, Date startDate, Date endDate, DeactivationReason endReason, double amount, String salaryType) {
  super(startDate, endDate, endReason, amount, salaryType);
  this.employee = employee;
 }

 @Override
 public double calculate() {
  long diffInMillis = endDate.getTime() - startDate.getTime();
  long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

  // محاسبه تعداد ساعت‌های کاری بر اساس 8 ساعت کار در هر روز
  double totalHoursWorked = diffInDays * 8;
  double totalSalary = totalHoursWorked * HOURLY_WAGE;

  // افزودن مدیریت فی به محاسبه اگر کارمند مدیر باشد
  if (employee != null && employee.getManager()) {
   long numberOfMonths = diffInDays / 30;
   totalSalary += numberOfMonths * managementFee;
  }

  return totalSalary;
 }

 public Employee getEmployee() {
  return employee;
 }

 public void setEmployee(Employee employee) {
  this.employee = employee;
 }
}
