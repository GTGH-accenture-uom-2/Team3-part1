import java.util.*;
import java.time.LocalDate;
import java.time.Month;
public class VaccinationCenter {
    private String code;
    private String address;
    private HashMap<Timeslot, Boolean> timeslots;
    private static final int OPEN_AT = 10;
    private static final int CLOSE_AT = 15;
    private static final int DURATION = 30; //minutes

    public VaccinationCenter(String code, String address) {
        this.code = code;
        this.address = address;
        timeslots = new HashMap<>();
    }
    public HashMap<Timeslot, Boolean> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(HashMap<Timeslot, Boolean> timeslots) {
        this.timeslots = timeslots;
    }
    public void makeReservation(Timeslot timeslot){
        Set<Timeslot> slots = timeslots.keySet();
        for(Timeslot aslot : slots){
            if(aslot.equals(timeslot)){
                timeslots.replace(aslot,false);
            }
        }
    }
    //tha to spasw se mikroteres synarthseis
    public void setDayTimeslots(Doctor firstDoctor, Doctor secondDoctor){
        LocalDate currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int count = 0 ;
        for(int hour = OPEN_AT ; hour < CLOSE_AT ; hour ++){
            for(int minutes=0; minutes + DURATION<=60 ; minutes= minutes + DURATION) {
                count ++;
                if(count <= 5){
                    if(minutes + DURATION  == 60){
                        Timeslot timeslot = new Timeslot(day,currentDate.getMonthValue(),currentDate.getYear(),hour,minutes,hour + 1,0,firstDoctor);
                        timeslots.put(timeslot,true);
                        break;
                    }
                    Timeslot timeslot = new Timeslot(day,currentDate.getMonthValue(),currentDate.getYear(),hour,minutes,hour,minutes + DURATION,firstDoctor);
                    timeslots.put(timeslot,true);
                }else{
                    if(minutes + DURATION  == 60){
                        Timeslot timeslot = new Timeslot(day,currentDate.getMonthValue(),currentDate.getYear(),hour,minutes,hour + 1,0,secondDoctor);
                        timeslots.put(timeslot,true);
                        break;
                    }
                    Timeslot timeslot = new Timeslot(day,currentDate.getMonthValue(),currentDate.getYear(),hour,minutes,hour,minutes + DURATION,secondDoctor);
                    timeslots.put(timeslot,true);
                }
            }
        }
    }
    public boolean isAvailable(Timeslot timeslot){
        Set<Timeslot> slots = timeslots.keySet();

        for(Timeslot aslot : slots){
            if(aslot.equals(timeslot)){
                if(timeslots.get(aslot))
                    return true;
            }
        }
        return false;
    }

    public void perMonthTimeslots(){
        //for(int day=currentDate.getDayOfMonth();day <= currentDate.lengthOfMonth() ;day++){ } //per month
        //...
    }
    public void printTimeslots(){
        for(Timeslot slot : timeslots.keySet()){
            System.out.println(slot);
            System.out.println("Appointment : " + timeslots.get(slot));
        }
    }

    @Override
    public String toString(){
        String text;
        text = "Vaccination Center Code : " + code;
        text += '\n' + "Address : " + address;
        return text;
    }
}

