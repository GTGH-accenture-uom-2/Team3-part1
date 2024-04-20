import validators.AFMValidator;
import validators.AmkaValidator;
import validators.EmailValidator;
import validators.NameSurnameValidator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Class representing an insured individual, encapsulating personal data including tax, social security information,
 * name, email, and vaccination status.
 */
public class Insured {
    // Validators to ensure correct formatting and validity of each data type
    private AFMValidator afm;
    private AmkaValidator amka;
    private NameSurnameValidator name;
    private NameSurnameValidator surname;
    private EmailValidator email;
    private LocalDate birthdate;
    private boolean isVaccinated = false;

    /**
     * Constructor to initialize an Insured object with validated data.
     * @param afm Tax Identification Number.
     * @param amka Social Security Number.
     * @param name First Name.
     * @param surname Last Name.
     * @param email Email address.
     * @param birthdate Birthdate of the insured.
     */
    public Insured(String afm, String amka, String name, String surname, String email, LocalDate birthdate) {
        this.afm = new AFMValidator(afm);
        this.amka = new AmkaValidator(amka, birthdate);
        this.name = new NameSurnameValidator(name);
        this.surname = new NameSurnameValidator(surname);
        this.email = new EmailValidator(email);
        this.birthdate = birthdate;
    }

    /**
     * Provides a formatted string representing the data of the Insured object.
     * @return formatted string.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Insured{"+
                " afm=" + afm.getAfm() + "," +
                " amka=" + amka.getAmka() + ", " +
                "name=" + name.getNameOrSurname() + ", " +
                "surname=" + surname.getNameOrSurname() + ", " +
                "email=" + email.getEmailAddress() + ", " +
                "birthdate=" + birthdate.format(formatter) + " " +
                "isVaccinated=" + isVaccinated +
                '}' ;
    }
    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthdate, currentDate);
        return period.getYears();
    }

    // Getters and setters for each field with validation where necessary
    public String getAfm() {
        return afm.getAfm();
    }

    public void setAfm(String afm) {
        this.afm = new AFMValidator(afm);
    }

    public String getAmka() {
        return amka.getAmka();
    }

    public void setAmka(String amka) {
        this.amka = new AmkaValidator(amka, this.birthdate);
    }

    public String getName() {
        return name.getNameOrSurname();
    }

    public void setName(String name) {
        this.name = new NameSurnameValidator(name);
    }

    public String getSurname() {
        return surname.getNameOrSurname();
    }

    public void setSurname(String surname) {
        this.surname = new NameSurnameValidator(surname);
    }

    public EmailValidator getEmail() {
        return email;
    }

    public void setEmail(String emailAddress) {
        this.email = new EmailValidator(emailAddress);
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        // Update AMKA with the new birthdate
        this.amka = new AmkaValidator(this.amka.getAmka(), birthdate);
        this.birthdate = birthdate;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.isVaccinated = vaccinated;
    }
}
