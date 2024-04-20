import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Timeslot {
    private LocalDate date;
    private Date expirationdate2;
    private Date vaccinationDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Doctor doctor;

    // Adjusted constructor
    public Timeslot(int day, int month, int year, int startHour, int startMinute, int endHour, int endMinute, Doctor doctor) {
        this.date = LocalDate.of(year, month, day);
        vaccinationDate=new Date(year,month,day);
        expirationdate2=new Date(year+2,month,day);
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
        this.doctor = doctor;

    }
    public Date vaccinationDate(){
        return vaccinationDate;
    }
    public Date expirationDate(){
        return expirationdate2;
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