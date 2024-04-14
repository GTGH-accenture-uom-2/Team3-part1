import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Insured {
    private AfmValidator afm;
    private String amka;
    private String name;
    private String surname;
    private EmailValidator email;
    private LocalDate birthdate;

    public Insured(String afm,String amka,String name,String surname,EmailValidator email,LocalDate birthdate){
        this.afm = new AfmValidator(afm);
        if (!AmkaValidator.isValidAmka(amka, birthdate)) {
            throw new IllegalArgumentException("Invalid AMKA");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email validator cannot be null");
        }
        this.amka = amka;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Insured {\n" +
                "afm=" + afm + ",\n" +
                "amka=" + amka + ",\n" +
                "name=" + name + ",\n" +
                "surname=" + surname + ",\n" +
                "email=" + email.getEmailAddress() + ",\n" +
                "birthdate=" + birthdate.format(formatter) + "\n" +
                '}';
    }

    public String getAfm() {
        return afm.getAfm();
    }

    public void setAfm(String afm) {
        this.afm = new AfmValidator(afm);
    }

    public String getAmka() {
        return amka;
    }

    public void setAmka(String amka) {
        if (!AmkaValidator.isValidAmka(amka, this.birthdate)) {
            throw new IllegalArgumentException("Invalid AMKA");
        }
        this.amka = amka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public EmailValidator getEmail() {
        return email;
    }

    public void setEmail(EmailValidator email) {
        if (email == null) {
            throw new IllegalArgumentException("Email validator cannot be null");
        }
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        if (!AmkaValidator.isValidAmka(this.amka, birthdate)) {
            throw new IllegalArgumentException("AMKA does not match new birthdate");
        }
        this.birthdate = birthdate;
    }

}
