import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor {
    private long amka;
    private String name;
    private String surname;
    private List<TimeSlot> timeSlots;

    public Doctor(long amka,String name,String surname){
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.timeSlots = new ArrayList<>();
    }

    public long getAmka() {
        return amka;
    }

    public void setAmka(long amka) {
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public void printReservedTimeslots(VaccinationCenter center, Reservation reservations) {

        HashMap<TimeSlot, Boolean> timeslots = center.getTimeslots();


        for (Map.Entry<TimeSlot, Boolean> entry : timeslots.entrySet()) {
            TimeSlot timeslot = entry.getKey();
            boolean isAvailable = entry.getValue();

            if (isAvailable && reservations.getReservation().containsValue(timeslot)) {

                for (Map.Entry<Insured, TimeSlot> reservation : reservations.getReservation().entrySet()) {
                    if (reservation.getValue().equals(timeslot)) {
                        Insured insured = reservation.getKey();
                        System.out.println("Ασφαλισμένος: " + insured + ", Ραντεβού: " + timeslot);
                    }
                }
            }
        }
    }

    public String toString(){
        return "Name: " + name +", Surname:" +surname +" ,amka: " + amka;}


}
