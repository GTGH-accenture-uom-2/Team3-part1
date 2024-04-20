import java.util.*;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;



    public Reservation(Insured insured /*, Timeslot timeslot*/) {
        this.insured = insured;
        //this.timeslot = timeslot;
    }

    public void setReservation( Timeslot timeslot , VaccinationCenter vacCenter) {
        if (vacCenter.isAvailable(timeslot)) {
            this.timeslot = timeslot;
            //reservations.put(insured, timeslot);
            vacCenter.makeReservation(timeslot);
        } else System.out.println("The timeslot is not available!");
        //return reservations;
    }

    public  void unsetReservation( VaccinationCenter vacCenter) {
        if (!vacCenter.isAvailable(this.timeslot)) {
            vacCenter.changeTheReservation(timeslot);
        } else System.out.println("The timeslot is not available!");
    }

    public void changeReservation( Timeslot timeslot, VaccinationCenter vacCenter) {
        if(!vacCenter.isAvailable(timeslot)) {
            //auto tha sbhsei mazi me thn unsetReservation kai vacCenter changeReservation
            unsetReservation(vacCenter);
            this.timeslot = timeslot;
            setReservation(timeslot, vacCenter);
            //kai tha anoiksei auto
            //vacCenter.getTimeslots().put(timeslot,true);
        }
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

    @Override
    public String toString() {
        return "Reservation{"+"insured="+insured+", timeslot="+timeslot +'}';
    }
}
