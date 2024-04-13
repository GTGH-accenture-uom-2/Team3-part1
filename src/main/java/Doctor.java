import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private int amka;
    private String name;
    private String surname;
    private List<TimeSlot> timeSlots;

    public Doctor(int amka,String name,String surname){
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.timeSlots = new ArrayList<>();
    }


}
