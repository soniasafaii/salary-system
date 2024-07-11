import java.util.Date;

public abstract class Salary {
    Date startDate;
    Date endDate;
    DeactivationReason endReason;
    final double managementFee = 500;
    double amount;
    String salaryType;

    public Salary(Date startDate, Date endDate, DeactivationReason endReason, double amount, String salaryType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.endReason = endReason;
        this.amount = amount;
        this.salaryType = salaryType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public DeactivationReason getEndReason() {
        return endReason;
    }

    public void setEndReason(DeactivationReason endReason) {
        this.endReason = endReason;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public abstract double calculate();
}
