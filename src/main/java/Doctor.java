import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String amka;
    private String name;
    private String surname;
    private List<Timeslot> timeSlots;

    public Doctor(String amka,String name,String surname){
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.timeSlots = new ArrayList<>();
    }

    public String getName() {return name;}
    public String getSurname(){return surname;}
    public boolean equals(Object obj){
        //deixnoun stin idia thesi mnhmhs tote true
        if(this == obj){
            return true;
        }
        // einai antikeimeno typou Doctor
        if(!(obj instanceof Doctor)){
            return false;
        }
        Doctor doc = (Doctor) obj; // type casting

        return name.equals(doc.name) && amka.equals(doc.amka) && surname.equals(doc.surname);
    }

}
