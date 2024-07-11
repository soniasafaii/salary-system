import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Commission extends Salary {
    private static final double COMMISSION_FEE = 500; // حق کمیسیون به صورت final تعریف شده است
    Employee employee;

    public Commission(Employee employee, Date startDate, Date endDate, DeactivationReason endReason, double amount, String salaryType) {
        super(startDate, endDate, endReason, amount, salaryType);
        this.employee = employee;
    }

    @Override
    public double calculate() {
        long diffInMillis = endDate.getTime() - startDate.getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        long numberOfMonths = diffInDays / 30;

        // محاسبه درآمد بر اساس حق کمیسیون
        double totalSalary = numberOfMonths * 3 * COMMISSION_FEE;

        // افزودن مدیریت فی به محاسبه اگر کارمند مدیر باشد
        if (employee != null && employee.getManager()) {
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
