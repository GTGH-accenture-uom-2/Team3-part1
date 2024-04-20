import java.time.LocalDate;

public class Vaccination {
    private Insured insured;
    private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;
    private Timeslot timeslot;
    private VaccinationCenter vC;



    public Vaccination(Insured insured, Doctor doctor, LocalDate vaccinationDate, LocalDate expirationDate) {
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = expirationDate;
    }

    public Vaccination(Insured insured, Doctor doctor,VaccinationCenter vC) {
        this.insured = insured;
        this.doctor = doctor;
        this.vC=vC;
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

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

//    public LocalDate setVaccinationDate() {
//        if (insured.isVaccinated()){
//            //vaccinationDate= vC.getTimeslots()
//        }
//        this.vaccinationDate = vaccinationDate;
//    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate() {
        this.expirationDate = calculateExpirationDate(vaccinationDate);
    }

    private LocalDate calculateExpirationDate(LocalDate vaccinationDate) {
        return vaccinationDate.plusYears(2);
    }

    public boolean isValid() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isBefore(expirationDate);
    }

    public void V(){
        if (insured.isVaccinated()){
            LocalDate vaccinationDate= timeslot.getDate();
        }
    }

//    public void declareVaccination(Insured insured, Timeslot timeslot, boolean vaccinationOccurred) {
//        if (vaccinationOccurred) {
//            LocalDate vaccinationDate = timeslot.getDate(); // Get the date from the timeslot
//            Vaccination vaccination = new Vaccination(insured, timeslot.getDoctor(), vaccinationDate, calculateExpirationDate(vaccinationDate));
//            // Optionally, set the vaccination date for the insured
//            insured.setVaccinationDate(vaccinationDate);
//            // Add the vaccination to the insured's records or database
//            // For example, you might have a list of vaccinations in the Insured class
//            insured.addVaccination(vaccination);
//        } else {
//            insured.setVaccinationDate(null); // Reset the vaccination date
//        }
//    }

//    public void printVaccinations(Map<Insured, Timeslot> reservations) {
//        System.out.println("Vaccinations made for each insured where isVaccinated=true:");
//
//        for (Map.Entry<Insured, Timeslot> entry : reservations.entrySet()) {
//            Insured insured = entry.getKey();
//            Timeslot timeslot = entry.getValue();
//
//            // Check if the insured is vaccinated
//            if (insured.isVaccinated()) {
//                if (doctor != null) { // Ensure a doctor is associated with the timeslot
//                    // Print vaccination details
//                    System.out.println("Date: " + timeslot.getDate() +
//                            ", Insured: " + insured.getName() + " " + insured.getSurname() +
//                            ", Doctor: " + doctor.getName() + " " + doctor.getSurname());
//                }
//            }
//        }
//    }

}
