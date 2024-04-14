import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String amka;
    private String name;
    private String surname;
    private LocalDate birthdate; // Doctor's birthdate is necessary for AMKA validation
    private List<Timeslot> timeSlots;
    private List<Vaccination> vaccinations;

    public Doctor(String amka, String name, String surname, LocalDate birthdate) {
        this.birthdate = birthdate;
        setAmka(amka);  // Validate and set AMKA within the constructor
        setName(name);  // Validate and set name within the constructor
        setSurname(surname);  // Validate and set surname within the constructor
        this.timeSlots = new ArrayList<>();
        this.vaccinations = new ArrayList<>();
    }

    // Setters with validation
    public void setAmka(String amka) {
        if (!AmkaValidator.isValidAmka(amka, this.birthdate)) {
            throw new IllegalArgumentException("Invalid AMKA for the provided birthdate");
        }
        this.amka = amka;
    }

    public void setName(String name) {
        NameSurnameValidator.validateNameOrSurname(name);
        this.name = name;
    }

    public void setSurname(String surname) {
        NameSurnameValidator.validateNameOrSurname(surname);
        this.surname = surname;
    }

    // Getters
    public String getAmka() {
        return amka;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public List<Timeslot> getTimeSlots() {
        return new ArrayList<>(timeSlots);
    }

    public void addVaccination(Vaccination vaccination) {
        if (vaccination != null && vaccination.getDoctor().equals(this)) {
            vaccinations.add(vaccination);
        }
    }

    public List<String> getVaccinationDetails() {
        List<String> details = new ArrayList<>();
        for (Vaccination v : vaccinations) {
            for (Insured insured : v.getInsureds()) {  // Adjusted to handle a list of Insured individuals
                String detail = "Date: " + v.getVaccinationDate() + ", Insured: " + insured.getName() + " " + insured.getSurname();
                details.add(detail);
            }
        }
        return details;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Doctor doctor = (Doctor) obj;
        return amka.equals(doctor.amka) && name.equals(doctor.name) && surname.equals(doctor.surname) && birthdate.equals(doctor.birthdate);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(amka, name, surname, birthdate);
    }
}
