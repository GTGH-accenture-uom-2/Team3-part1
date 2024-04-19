import validators.AmkaValidator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private AmkaValidator amka;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private List<Reservation> timeSlots=new ArrayList<>();
    private List<Reservation> rs=new ArrayList<>();


    public Doctor(String amka,String name,String surname,LocalDate birthdate){
        this.amka = new AmkaValidator(amka, birthdate);
        this.name = name;
        this.surname = surname;
        this.birthdate=birthdate;
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


//    public boolean declareVaccinationReservation() {
//        Map<Insured, Timeslot> reservations = reservation.getReservations();
//
//        for (Map.Entry<Insured, Timeslot> entry : reservations.entrySet()) {
//            Insured insured = entry.getKey();
//            Timeslot timeslot = entry.getValue();
//
//
//            insured.setVaccinated(true);
//        }
//
//        return true;
//    }



    public void markAsVaccinated(Reservation reservation) {
        Insured insured = reservation.getInsured();
        insured.setVaccinated(true);
        rs.add(reservation);
        //insured.setVaccination(new Vaccination(reservation.getInsured(),this,reservation.getTimeslot().getDate(), reservation.getTimeslot().getDate().plusYears(2)));
        System.out.println("Insured " + insured.getName() + " " + insured.getSurname() + " marked as vaccinated by Dr. " + this.getName() + ".");
    }

    public void printVaccinations() {
//        System.out.println("Vaccinations for Dr. " + getName() + ":");
        System.out.println("Doctor with name " + name + " and surname " + surname + ", vaccinated the following insured people:");
        for (Reservation reservation : rs) {
            Insured insured = reservation.getInsured();
            if (insured.isVaccinated()) {
                System.out.println("The Insured with name: " + insured.getName() + " " + insured.getSurname() + " on date: " /*+ insured.getVaccinationDate()*/);
            }
        }
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "amka=" + amka +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", rs=" + rs +
                '}';
    }

}