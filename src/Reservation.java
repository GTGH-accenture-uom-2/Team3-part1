import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
    private VaccinationCenter vacCenter;
    private Map<Insured,Timeslot> reservations;

    public Reservation(Insured insured, Timeslot timeslot,VaccinationCenter vacCenter) {
        this.insured = insured;
        this.timeslot = timeslot;
        reservations=new HashMap<>();
    }
    public void printAvailableSlots(VaccinationCenter vacCenter){

    }
    public void setReservation(Insured insured, Timeslot timeslot,VaccinationCenter vacCenter){
        if(vacCenter.isAvailable(timeslot)){
            reservations.put(insured,timeslot);
            vacCenter.isAvailable(timeslot);
        }
        else System.out.println("The timeslot is not available!");

    }
    public void changeReservation(Insured insured,Timeslot timeslot,VaccinationCenter vacCenter){
        if(reservations.containsKey(insured)){
            setReservation(insured,timeslot,vacCenter);
        }

    }
    public void printReservations(Map reservations){
        reservations.forEach((insured,timeslot)->
            System.out.println(insured + " : "+ timeslot));

    }

    public VaccinationCenter getVacCenter() {
        return vacCenter;
    }

    public Map<Insured, Timeslot> getReservations() {
        return reservations;
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
