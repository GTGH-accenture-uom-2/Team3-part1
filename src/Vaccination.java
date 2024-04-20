import java.util.Date;

public class Vaccination {
    private Insured insured;
    private Doctor doctor;
    private Date vaccinationDate;
    private Date expirationDate;

    public Vaccination() {

    }

    public void isVaccinated(Reservation reservation){
        reservation=new Reservation(insured);
        Timeslot timeslot2=reservation.getTimeslot();
        vaccinationDate=timeslot2.vaccinationDate();
        expirationDate=timeslot2.expirationDate();
        if (vaccinationDate.compareTo(expirationDate)<0)
          System.out.println("Vaccination is valid");
        else System.out.println("Vaccination is expired!");
    }

    public Insured getInsured() {
        return insured;
    }

    public void setInsured(Insured insured) {
        this.insured = insured;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
