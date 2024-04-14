import java.time.LocalDate;
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

        for (Insured insured : insuredList) {
            System.out.println(insured);
        }

        Doctor d1 = new Doctor(150298007,"Aikaterini","Stamatiou");
        Doctor d2 = new Doctor(130692564,"Apostolis","Mpalianas");
        Doctor d3 = new Doctor(525965782,"Dimitrios","Sianidis");
        Doctor d4 = new Doctor(120569823,"Ioannis","Vletsos");

        TimeSlot time1 = new TimeSlot(13,4,2024,10,0,10,30,d4);
        TimeSlot time2 = new TimeSlot(13,4,2024,10,30,11,0,d3);
        TimeSlot time3 = new TimeSlot(13, 4, 2024, 11, 0, 11, 30, d4);
        TimeSlot time4 = new TimeSlot(13, 4, 2024, 11, 30, 12, 0, d3);
        TimeSlot time5 = new TimeSlot(13,4,2024,12,0,12,30,d4);
        TimeSlot time6 = new TimeSlot(13,4,2024,12,30,13,0,d3);
        TimeSlot time7 = new TimeSlot(13,4,2024,13,0,13,30,d4);
        TimeSlot time8 = new TimeSlot(13,4,2024,13,30,14,0,d3);
        TimeSlot time9 = new TimeSlot(13,4,2024,14,0,14,30,d4);
        TimeSlot time10 = new TimeSlot(13, 4, 2024, 14, 30, 15, 0, d3);


        TimeSlot time11 = new TimeSlot(13,4,2024,10,0,10,30,d1);
        TimeSlot time12 = new TimeSlot(13,4,2024,10,30,11,0,d2);
        TimeSlot time13 = new TimeSlot(13,4,2024,11,0,11,30,d1);
        TimeSlot time14 = new TimeSlot(13,4,2024,11,30,12,0,d2);
        TimeSlot time15 = new TimeSlot(13,4,2024,12,0,12,30,d1);
        TimeSlot time16 = new TimeSlot(13,4,2024,12,30,13,0,d2);
        TimeSlot time17 = new TimeSlot(13,4,2024,13,0,13,30,d1);
        TimeSlot time18 = new TimeSlot(13,4,2024,13,30,14,0,d2);
        TimeSlot time19 = new TimeSlot(13,4,2024,14,0,14,30,d1);
        TimeSlot time20 = new TimeSlot(13,4,2024,14,30,15,0,d2);


        VaccinationCenter firstCenter = new VaccinationCenter("1234","Ippokrateio");
        VaccinationCenter secondCenter = new VaccinationCenter("5678","Theageneio");

//        if (firstCenter.isAvailable(time1)){
//            Reservation r1 = new Reservation();
//            r1.makeReservation();
//        }


        System.out.println(firstCenter);

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
