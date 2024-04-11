import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class Insured {
    private int afm;
    private long amka;
    private String name;
    private String surname;
    private isEmail email;
    private LocalDate birthdate;

    public Insured(int afm,String name,String surname,isEmail email,LocalDate birthdate){
        this.afm = afm;
        this.amka = generateAmka(birthdate);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;
    }

    private long generateAmka(LocalDate birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        String birthdateStr = birthdate.format(formatter);
        Random random = new Random();
        int randomFiveDigits = random.nextInt(100000);
        String amka = birthdateStr + String.format("%05d", randomFiveDigits);
        return Long.parseLong(amka);
    }

    @Override
    public String toString() {
        return "Insured {\n" +
                "afm=" + afm + ",\n" +
                "amka=" + amka + ",\n" +
                "name=" + name + ",\n" +
                "surname=" + surname + ",\n" +
                "email=" + email.getEmailAddress() + ",\n" +
                "birthdate=" + birthdate + "\n" +
                '}';
    }

    public int getAfm() {
        return afm;
    }

    public void setAfm(int afm) {
        this.afm = afm;
    }

    public long getAmka() {
        return amka;
    }

    public void setAmka(long amka) {
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

    public isEmail getEmail() {
        return email;
    }

    public void setEmail(isEmail email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        this.amka = generateAmka(birthdate);
    }
}
