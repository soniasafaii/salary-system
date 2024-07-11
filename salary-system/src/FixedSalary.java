import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FixedSalary extends Salary {
    final double fixedSal = 1000;
    Employee employee;

    public FixedSalary(Employee employee,Date startDate, Date endDate, DeactivationReason endReason, double amount, String salaryType, double fixedSal) {
        super(startDate, endDate, endReason, amount, salaryType);
        this.employee=employee;
    }

    @Override
    public double calculate() {
        long diffInMillis = endDate.getTime() - startDate.getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        long numberOfMonths = diffInDays / 30;
        double totalSalary = numberOfMonths * fixedSal;
        if (employee.getManager()) {
            totalSalary += numberOfMonths * managementFee;
        }

        return totalSalary;
    }

    public double getFixedSal() {
        return fixedSal;
    }

}
