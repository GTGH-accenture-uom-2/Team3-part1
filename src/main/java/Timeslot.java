import java.time.LocalDate;
import java.time.LocalTime;

public class Timeslot {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Doctor doctor;


    public Timeslot(LocalDate date, LocalTime startTime, LocalTime endTime, Doctor doctor) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
    }

    public void assignDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", doctor=" + (doctor != null ? doctor.getName() : "Unassigned") +
                '}';
    }

    //Override trhe equals method to provide a way to compare two Timeslot objects.
    @Override
    public boolean equals(Object obj){
        //This method first checks if the object being compared is the same instance.
        if(this == obj){
            return true;
        }
        //Checks whether the provided object is an instance of Timeslot
        if(!(obj instanceof Timeslot)){
            return false;
        }
        Timeslot otherTimeslot = (Timeslot) obj;
        return date.equals(otherTimeslot.date) &&  //Compares the date properties of both objects.
                startTime.equals(otherTimeslot.startTime) && //Compares the startTime properties of both objects.
                endTime.equals(otherTimeslot.endTime) &&
                doctor.equals(otherTimeslot.doctor);
    }


}