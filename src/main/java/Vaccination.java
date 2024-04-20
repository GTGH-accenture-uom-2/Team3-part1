import java.time.LocalDate;
import java.util.List;

public class Vaccination {
    private Insured insured;
    private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    public Vaccination(Insured insured, Doctor doctor, LocalDate vaccinationDate) {
        this.insured = insured;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = calculateExpirationDate(vaccinationDate);
        isVaccinated();
    }

    private LocalDate calculateExpirationDate(LocalDate vaccinationDate) {
        return vaccinationDate.plusYears(2);
    }

    private void isVaccinated() {
        insured.setVaccinated(true);
    }

    // Getters
    public Insured getInsureds() {
        return insured;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setInsureds(Insured insured) {
        this.insured = insured;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = calculateExpirationDate(vaccinationDate);
    }
}