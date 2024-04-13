import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<String> greekNames = Arrays.asList("Nikos", "Yiannis", "Kostas", "Maria", "Eleni", "Dimitris", "Alexandra", "Vasiliki", "Georgios", "Panagiotis");
        List<String> greekSurnames = Arrays.asList("Papadopoulos", "Nikolaidou", "Kostas", "Dimitriou", "Vasileiou", "Bozatzidou", "Alexaidou", "Giorgiou", "Stamatakis", "Antonopoulos");

        List<Insured> insuredList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            String name = greekNames.get(random.nextInt(greekNames.size()));
            String surname = greekSurnames.get(random.nextInt(greekSurnames.size()));
            String email = name.toLowerCase() + "." + surname.toLowerCase() + "@gmail.com";
            LocalDate birthdate = LocalDate.now().minusYears(10 + random.nextInt(81));
            String amka = generateAmka(birthdate);
            String afm = generateAFM();

            //insuredList.add(new Insured("010101010101", amka, name, surname, new EmailValidator(email), birthdate)); //INVALID AFM CASE
            //insuredList.add(new Insured(afm, "01010101010", name, surname, new EmailValidator(email), birthdate)); //INVALID AMKA CASE
            //insuredList.add(new Insured(afm, amka, name, surname, new EmailValidator("leonidas"), birthdate)); //INVALID email CASE

            insuredList.add(new Insured(afm, amka, name, surname, new EmailValidator(email), birthdate));
        }
        /*
        for (Insured insured : insuredList) {
            System.out.println(insured);
        }
         */

        VaccinationCenter firstCenter = new VaccinationCenter("1234","Psaron2");
        VaccinationCenter secondCenter = new VaccinationCenter("5678", "Ipokratio");

        Doctor doctor1 = new Doctor("166803245", "Nikos", "Papadopoulos");
        Doctor doctor2 = new Doctor("166803323", "Maria", "Dimitriou");
        Doctor doctor3 = new Doctor("166803123", "Kostas", "Papanikolaou");
        Doctor doctor4 = new Doctor("166803789", "Anna", "Iwannou");

        firstCenter.setDailyTimeslots(doctor1,doctor2);
        secondCenter.setDailyTimeslots(doctor3,doctor4);
        //firstCenter.printTimeslots();
        //secondCenter.printTimeslots();

        /*
        //elegxos gia thn allagh sto hashMap tou VaccinationCenter
        Timeslot time = new Timeslot(13,4,2024,13,0,13,30,doctor2);
        if(!firstCenter.isAvailable(time)){
            System.out.println("Available");
        }else{
            System.out.println("Not Availlable");
            firstCenter.makeReservation(time);
        }
        firstCenter.printTimeslots();
        if(!firstCenter.isAvailable(time)){
            System.out.println("Available");
        }else{
            System.out.println("Not Availlable");
        }
         */

    }

    private static String generateAmka(LocalDate birthdate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        Random random = new Random();
        String birthdateStr = birthdate.format(formatter);
        int randomFiveDigits = 10000 + random.nextInt(90000);
        return birthdateStr + randomFiveDigits;
    }

    private static String generateAFM() {
        Random random = new Random();
        return String.format("%09d", random.nextInt(1000000000));
    }
}
