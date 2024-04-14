import java.time.LocalDate;
import java.time.LocalTime;

public class Timeslot {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Doctor doctor;

    // Constructor
    public Timeslot(int day, int month, int year, int startHour, int startMinute, int endHour, int endMinute, Doctor doctor) {
        this.date = LocalDate.of(year, month, day);
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
        this.doctor = doctor;
    }

    // Overriding equals method to compare timeslot objects based on their properties
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Timeslot timeslot = (Timeslot) obj;
        return date.equals(timeslot.date) &&
                startTime.equals(timeslot.startTime) &&
                endTime.equals(timeslot.endTime) &&
                (doctor != null ? doctor.equals(timeslot.doctor) : timeslot.doctor == null);
    }

    // Overriding hashCode method to produce a consistent hash code based on its properties
    @Override
    public int hashCode() {
        return java.util.Objects.hash(date, startTime, endTime, doctor);
    }

    // toString method for printing timeslot details
    @Override
    public String toString() {
        return "TimeSlot{" +
                "date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", doctor=" + (doctor != null ? doctor.getName() : "None") +
                '}';
    }

    // Getters and Setters (add these if you need to access properties from outside the class)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
