import java.util.*;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;

    private Map<Insured, Timeslot> reservations;


    public Reservation(Insured insured) {
        this.insured = insured;
        reservations = new HashMap<>();

    }

    public Map<Insured, Timeslot> setReservation( Timeslot timeslot, VaccinationCenter vacCenter) {
        //Scanner setTimeslot=new Scanner(System.in);
        //printAvailableSlots(vacCenter);
        //System.out.println("Choose a available timeslot");

        if (vacCenter.isAvailable(timeslot)) {
            this.timeslot = timeslot;
            reservations.put(insured, timeslot);
            vacCenter.makeReservation(timeslot);
        } else System.out.println("The timeslot is not available!");
        return reservations;
    }
    public  void unsetReservation( VaccinationCenter vacCenter) {
        if (!vacCenter.isAvailable(this.timeslot)) {
            vacCenter.changeTheReservation(timeslot);
        } else System.out.println("The timeslot is not available!");
    }


    public void changeReservation( Timeslot timeslot, VaccinationCenter vacCenter) {
        if (reservations.containsKey(insured)) {
            unsetReservation(vacCenter);
            this.timeslot = timeslot;
            setReservation(timeslot, vacCenter);
        }
    }

    public Map<Insured, Timeslot> getReservations () {
        return reservations;
    }

    public Insured getInsured () {
        return insured;
    }

    public void setInsured (Insured insured){
        this.insured = insured;
    }

    public Timeslot getTimeslot () {
        return timeslot;
    }

    public void setTimeslot (Timeslot timeslot){
        this.timeslot = timeslot;
    }
}

