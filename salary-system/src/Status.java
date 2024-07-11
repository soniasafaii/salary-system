import java.util.Date;

public class Status {
    private boolean isActive;
    private DeactivationReason deactivationReason;
    private Date date;

    public Status(boolean isActive, DeactivationReason deactivationReason) {
        this.isActive = isActive;
        this.deactivationReason = deactivationReason;
        this.date = new Date(); // Set the current date
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public DeactivationReason getDeactivationReason() {
        return deactivationReason;
    }

    public void setDeactivationReason(DeactivationReason deactivationReason) {
        this.deactivationReason = deactivationReason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return isActive+","+deactivationReason.toString()+","+date;
    }
}
