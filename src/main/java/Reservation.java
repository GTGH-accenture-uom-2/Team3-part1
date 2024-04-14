import java.util.*;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
    //private VaccinationCenter vacCenter; //den to xrhsimopoieis pouthena
    private Map<Insured, Timeslot> reservations;


    public Reservation(Insured insured/*, Timeslot timeslot, VaccinationCenter vacCenter*/) {
        this.insured = insured;
        //this.timeslot = timeslot;
        reservations = new HashMap<>();
        //this.vacCenter = vacCenter;

    }

    public void printAvailableSlots(VaccinationCenter vacCenter) {
        //HashMap<Timeslot,Boolean> timeslots=vacCenter.getTimeslots();
        //System.out.println("The Available timeslots are : \n" + timeslots);
        vacCenter.printAvailableTimeslots();

    }

    public Map<Insured, Timeslot> setReservation(/*Insured insured,*/ Timeslot timeslot, VaccinationCenter vacCenter) {
        //Scanner setTimeslot=new Scanner(System.in);
        //printAvailableSlots(vacCenter);
        //System.out.println("Choose a available timeslot");

        if (vacCenter.isAvailable(timeslot)) {
            this.timeslot = timeslot;
            reservations.put(insured, timeslot);
            vacCenter.makeReservation(timeslot);
        } else System.out.println("The timeslot is not available!?!?");
        return reservations;
    }
    public /*Map<Insured, Timeslot>*/ void unsetReservation(/*Insured insured, Timeslot timeslot,*/ VaccinationCenter vacCenter) {
        if (!vacCenter.isAvailable(this.timeslot)) {
            vacCenter.changeTheReservation(timeslot);
        } else System.out.println("The timeslot is not available!?!?");
        //return reservations;
    }

    public void changeReservation(/*Insured insured,*/ Timeslot timeslot, VaccinationCenter vacCenter) {
        if (reservations.containsKey(insured)) {
            unsetReservation(vacCenter);
            this.timeslot = timeslot;
            setReservation(/*insured, */timeslot, vacCenter);
        }
    }


       /* public VaccinationCenter getVacCenter () {
            return vacCenter;
        }*/

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

