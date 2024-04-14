import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Reservation {
    private Insured insured;
    private TimeSlot timeSlot;
    private HashMap<Insured,TimeSlot> reservation;


    public Reservation(Insured insured, TimeSlot timeSlot, HashMap<Insured, TimeSlot> reservation) {
        this.insured = insured;
        this.timeSlot = timeSlot;
        this.reservation = new HashMap<>();
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public HashMap<Insured, TimeSlot> getReservation() {
        return reservation;
    }

    public void setReservation(HashMap<Insured, TimeSlot> reservation) {
        this.reservation = reservation;
    }

    public boolean containsKey(Object key){
        return reservation.containsKey(key);
    }

    /*
    will add if an insured doesn't match with a timeslot.
     */
    public TimeSlot putIfAbsent(Insured insured,TimeSlot timeSlot){
         return reservation.putIfAbsent(insured,timeSlot);
    }

    public boolean replace(Insured insured, TimeSlot oldValue, TimeSlot newValue){
        return reservation.replace(insured,oldValue,newValue);
    }

    public TimeSlot replace(Insured insured, TimeSlot newValue){
        return reservation.replace(insured,newValue);
    }

    public void makeReservation(){
        Set<Insured> insureds = reservation.keySet();
        for(Insured insured1 : insureds){
            if(insured1.equals(insured)){
                reservation.replace(insured1,timeSlot);
            }
        }
    }
}
