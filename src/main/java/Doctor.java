import validators.AmkaValidator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private AmkaValidator amka;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private List<Timeslot> timeSlots;

    public Doctor(String amka,String name,String surname,LocalDate birthdate){
        this.amka = new AmkaValidator(amka, birthdate);
        this.name = name;
        this.surname = surname;
        this.timeSlots = new ArrayList<>();
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }
    public String getSurname(){return surname;}

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAmka() {
        return amka.getAmka();
    }

    public LocalDate getBirthdate() {
        return amka.getBirthdate();
    }

    public void addTimeSlot(Timeslot timeSlot) {
        this.timeSlots.add(timeSlot);
    }

    public List<Timeslot> getTimeSlots() {
        return timeSlots;
    }


    @Override
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

    @Override
    public String toString() {
        return "Doctor{" +
                "AMKA='" + amka.getAmka() + '\'' +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", Birthdate='" + amka.getBirthdate() + '\'' +
                ", TimeSlots=" + timeSlots.size() +
                '}';
    }

}