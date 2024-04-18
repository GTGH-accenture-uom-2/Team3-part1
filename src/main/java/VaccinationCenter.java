import java.time.LocalTime;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;

public class VaccinationCenter {
    private String code;
    private String address;
    private LinkedHashMap<Timeslot, Boolean> timeslots;
    private static final LocalTime OPENS_AT = LocalTime.of(10,0);
    private static final LocalTime CLOSE_AT = LocalTime.of(15,0);
    private static final int DURATION = 30; //minutes
    private static final int MAX_PER_DOCTOR_TIMESLOTS = 5;

    public VaccinationCenter(String code, String address) {
        this.code = code;
        this.address = address;
        timeslots = new LinkedHashMap<>();
        createTimeslots();
    }

    public HashMap<Timeslot, Boolean> getTimeslots() {
        return timeslots;
    }

    private void createTimeslots() {
        LocalDate currentDate = LocalDate.now();
        LocalTime time = OPENS_AT;

        while (time.plusMinutes(DURATION).isBefore(CLOSE_AT.plusMinutes(1))) {
            if (time.plusMinutes(DURATION).isAfter(CLOSE_AT)) {
                break;  // Prevents creation of a timeslot that would end after the center closes
            }

            Timeslot timeslot = new Timeslot(currentDate, time, time.plusMinutes(DURATION), null);
            timeslots.put(timeslot, true);

            time = time.plusMinutes(DURATION);
        }
    }

    public void assignDoctorsToTimeslots(Doctor firstDoctor, Doctor secondDoctor) {
        int count = 0;
        for (Timeslot timeslot : timeslots.keySet()) {
            Doctor assignedDoctor = count % (2 * MAX_PER_DOCTOR_TIMESLOTS) < MAX_PER_DOCTOR_TIMESLOTS ? firstDoctor : secondDoctor;
            timeslot.assignDoctor(assignedDoctor);
            count++;
        }
    }

    public void printAvailableTimeslots(){
        timeslots.forEach((key, value) -> {
            if(value)
                System.out.println(" Available Appointments: " + key );
        });
    }

    public void printBookedTimeslots(){
        timeslots.forEach((key, value) -> {
            if(!value)
                System.out.println(" Booked Timeslots: " + key );
        });
    }

    public void makeReservation(Timeslot timeslot){
        Set<Timeslot> slots = timeslots.keySet();
        for(Timeslot aslot : slots){
            if(aslot.equals(timeslot)){
                timeslots.replace(aslot,false);
            }
        }
    }

    public void changeTheReservation(Timeslot timeslot){
        Set<Timeslot> slots = timeslots.keySet();
        for(Timeslot aslot : slots){
            if(aslot.equals(timeslot)){
                timeslots.replace(aslot,true);
            }
        }
    }

    public boolean isAvailable(Timeslot timeslot){
        Set<Timeslot> slots = timeslots.keySet();
        for(Timeslot aslot : slots){
            if(aslot.equals(timeslot)){
                return timeslots.get(aslot);
            }
        }
        return false;
    }


    @Override
    public String toString(){
        String text;
        text = "Vaccination Center Code:" + code;
        text += '\n' + "Address:" + address;
        return text;
    }

}
