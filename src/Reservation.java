import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
    private Map<Insured,Timeslot> reservations=new HashMap<>();

    public Reservation(Insured insured, Timeslot timeslot) {
        this.insured = insured;
        this.timeslot = timeslot;
    }
    public void setReservation(Insured insured, Timeslot timeslot){
        if(timeslot.isAvailable()){
            reservations.put(insured,timeslot);
            timeslot.isAvailable()=false;
        }

    }
    public void changeReservation(Insured insured,Timeslot timeslot){
        if(reservations.containsKey(insured)){
            setReservation(insured,timeslot);
        }

    }
    public void printReservations(HashMap reservations){
        reservations.forEach((insured,timeslot)->
            System.out.println(insured + " : "+ timeslot));

    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }
}
