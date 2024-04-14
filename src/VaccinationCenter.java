import java.time.LocalTime;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;
public class VaccinationCenter {
    private String code;
    private String address;
    private Timeslot timeslot;
    private LinkedHashMap<Timeslot, Boolean> timeslots;
    //private static final int OPEN_AT = 10;
    //private static final int CLOSE_AT = 15;
    private static final LocalTime OPENS_AT = LocalTime.of(10,0);
    private static final LocalTime CLOSE_AT = LocalTime.of(15,0);
    private static final int DURATION = 30; //minutes
    private static final int MAX_PER_DOCTOR_TIMESLOTS = 5;

    public VaccinationCenter(String code, String address) {
        this.code = code;
        this.address = address;
        timeslots = new LinkedHashMap<>();
    }
    public HashMap<Timeslot, Boolean> getTimeslots() {
        return timeslots;
    }

    public void makeReservation(Timeslot timeslot){
        Set<Timeslot> slots = timeslots.keySet();
        for(Timeslot aslot : slots){
            if(aslot.equals(timeslot)){
                timeslots.replace(aslot,false);
            }
        }
    }
    public void setDailyTimeslots(Doctor firstDoctor, Doctor secondDoctor){
        LocalDate currentDate = LocalDate.now();
        LocalTime time = OPENS_AT;
        int count = 0;
        while(time.isBefore(CLOSE_AT)){
            Timeslot timeslot = new Timeslot(currentDate.getDayOfMonth(),currentDate.getMonthValue(),currentDate.getYear(),time.getHour(),
                    time.getMinute(),time.plusMinutes(DURATION).getHour(), time.plusMinutes(DURATION).getMinute(),
                    count< MAX_PER_DOCTOR_TIMESLOTS ? firstDoctor : secondDoctor);
            timeslots.put(timeslot,true);
            count ++;
            time = time.plusMinutes(DURATION);
        }
    }
    /*public boolean isAvailable(Timeslot timeslot){
        Set<Timeslot> slots = timeslots.keySet();

        for(Timeslot aslot : slots){
            if(aslot.equals(timeslot)){
                if(timeslots.get(aslot))
                    return true;
            }
        }
        return false;
    }*/

    public void perMonthTimeslots(){
        //for(int day=currentDate.getDayOfMonth();day <= currentDate.lengthOfMonth() ;day++){ } //per month
        //...
    }
    public void printTimeslots(){
        System.out.println("------------------- Daily timeslots ----------------");
        timeslots.forEach((key, value) -> {
            System.out.println( key + " Appointment: " + value);
        });
    }

    @Override
    public String toString(){
        String text;
        text = "Vaccination Center Code : " + code;
        text += '\n' + "Address : " + address;
        return text;
    }


    public boolean isAvailable(Timeslot timeslot) {
        boolean available;
        if(timeslots.get(timeslot)==null)
            available=true;
        else available=false;
        return  available;
    }
}