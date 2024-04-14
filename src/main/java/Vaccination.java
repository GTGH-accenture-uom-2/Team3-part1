import java.time.LocalDate;
import java.util.List;

public class Vaccination {
    private List<Insured> insureds;  // Handles a list of insured individuals
    private Doctor doctor;
    private LocalDate vaccinationDate;
    private LocalDate expirationDate;

    public Vaccination(List<Insured> insureds, Doctor doctor, LocalDate vaccinationDate) {
        this.insureds = insureds;
        this.doctor = doctor;
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = calculateExpirationDate(vaccinationDate);  // Automatically calculate the expiration date
        isVaccinated();
    }

    private LocalDate calculateExpirationDate(LocalDate vaccinationDate) {
        return vaccinationDate.plusYears(2);  // Expiration date is two years after the vaccination date
    }

    private void isVaccinated() {
        for (Insured insured : insureds) {
            insured.setVaccinated(true);  // Update the isVaccinated status
        }
    }

    // Getters
    public List<Insured> getInsureds() {
        return insureds;
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

    // Setters, in case you need to update any fields post-creation
    public void setInsureds(List<Insured> insureds) {
        this.insureds = insureds;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
        this.expirationDate = calculateExpirationDate(vaccinationDate);  // Recalculate expiration when vaccination date changes
    }
}
