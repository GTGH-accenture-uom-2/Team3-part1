import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlot {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Doctor doctor;

    // Adjusted constructor
    public TimeSlot(int day, int month, int year, int startHour, int startMinute, int endHour, int endMinute, Doctor doctor) {
        this.date = LocalDate.of(year, month, day);
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
        this.doctor = doctor;
    }



    @Override
    public String toString() {
        return "TimeSlot{" +
                "date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
//                ", doctor=" + (doctor != null ? doctor.getName() : "None") +
                '}';
    }
}