import java.time.LocalDate;
import java.time.LocalTime;

public class Timeslot {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Doctor doctor;

    // Adjusted constructor
    public Timeslot(int day, int month, int year, int startHour, int startMinute, int endHour, int endMinute, Doctor doctor) {
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
                ", doctor=" + doctor.getName() +
                "} \n";
    }
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Timeslot)){
            return false;
        }
        Timeslot tslot = (Timeslot) obj; // type casting
        return date.equals(tslot.date) && startTime.equals(tslot.startTime) && endTime.equals(tslot.endTime) && doctor.equals(tslot.doctor);
    }

}