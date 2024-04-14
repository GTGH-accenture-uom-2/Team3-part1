import java.util.*;

public class Reservation {
    private Insured insured;
    private Timeslot timeslot;
    private VaccinationCenter vacCenter;
    private Map<Insured, Timeslot> reservations;



    public Reservation(Insured insured, Timeslot timeslot, VaccinationCenter vacCenter) {
        this.timeslot = timeslot;
        this.insured = insured;
        this.vacCenter = vacCenter;
        reservations = new HashMap<>();

    }

   public void printAvailableSlots(VaccinationCenter vacCenter) {
       HashMap<Timeslot,Boolean> timeslots=vacCenter.getTimeslots();
        System.out.println("The Available timeslots are : \n" + timeslots);
    }

    public Map<Insured, Timeslot> setReservation(Insured insured, Timeslot timeslot, VaccinationCenter vacCenter) {
        Scanner setTimeslot=new Scanner(System.in);
        printAvailableSlots(vacCenter);
        System.out.println("Choose a available timeslot");

        if (vacCenter.isAvailable(timeslot)) {
            reservations.put(insured, timeslot);
            vacCenter.makeReservation(timeslot);
        } else System.out.println("The timeslot is not available!");
        return reservations;
    }

    public void changeReservation(Insured insured, Timeslot timeslot, VaccinationCenter vacCenter) {
        if (reservations.containsKey(insured)) {
            setReservation(insured, timeslot, vacCenter);
        }
    }


        public VaccinationCenter getVacCenter () {
            return vacCenter;
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

