import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> greekNames = Arrays.asList("Nikos", "Yiannis", "Kostas", "Maria", "Eleni", "Dimitris", "Alexandra", "Vasiliki", "Georgios", "Panagiotis");
        List<String> greekSurnames = Arrays.asList("Papadopoulos", "Nikolaidou", "Kostas", "Dimitriou", "Vasileiou", "Bozatzidou", "Alexaidou", "Giorgiou", "Stamatakis", "Antonopoulos");

        List<Insured> insuredList = new ArrayList<>();
        Random random = new Random();

        insuredList.add(new Insured("010100101", "27059500515", "Leondidas", "Bozatzidis", new EmailValidator("leonidas@gmaill.com"), LocalDate.of(1995, 5, 27)));
        insuredList.add(new Insured("010600101", "26059500515", "Maria", "Bozatzidis", new EmailValidator("leonidas@gmaill.com"), LocalDate.of(1995, 5, 26)));


//        for (Insured insured : insuredList) {
//            System.out.println(insured);
//        }


        VaccinationCenter firstCenter = new VaccinationCenter("1234","Psaron2");
        VaccinationCenter secondCenter = new VaccinationCenter("5678", "Ipokratio");

        Doctor doctor1 = new Doctor("166803245", "Nikos", "Papadopoulos");
        Doctor doctor2 = new Doctor("166803323", "Maria", "Dimitriou");

        firstCenter.setDailyTimeslots(doctor1,doctor2);
        //firstCenter.printTimeslots();

        Timeslot time = new Timeslot(14,4,2024,13,0,13,30,doctor2);
        if(firstCenter.isAvailable(time)){
            System.out.println("Available");
            //firstCenter.makeReservation(time);
        }else{
            System.out.println("Not Available");
        }

        //firstCenter.printTimeslots();

        List<Map> reservations=new ArrayList<>();

            Reservation r1 = new Reservation(insuredList.get(0),time,firstCenter);
            //Reservation r2 = new Reservation(insuredList.get(1),time,firstCenter);
            /*Reservation r3 = new Reservation(insuredList.get(2),time,firstCenter);
            Reservation r4 = new Reservation(insuredList.get(3),time,firstCenter);
            Reservation r5 = new Reservation(insuredList.get(4),time,firstCenter);
            Reservation r6 = new Reservation(insuredList.get(5),time,firstCenter);
            Reservation r7 = new Reservation(insuredList.get(6),time,firstCenter);
            Reservation r8 = new Reservation(insuredList.get(7),time,firstCenter);*/
            Timeslot time2=new Timeslot(14,4,2024,14,0,14,30,doctor2);

            reservations.add(r1.setReservation(insuredList.get(0),time,firstCenter));
            //reservations.add(r2.setReservation(insuredList.get(1),time,firstCenter));
            r1.changeReservation(insuredList.get(0),time2,firstCenter);

            System.out.println(reservations);
            System.out.println("-----------------------------------------------------------------------");
            r1.printAvailableSlots(firstCenter);



    }

//    private static String generateAmka(LocalDate birthdate) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
//        Random random = new Random();
//        String birthdateStr = birthdate.format(formatter);
//        int randomFiveDigits = 10000 + random.nextInt(90000);
//        return birthdateStr + randomFiveDigits;
//    }
//
//    private static String generateAFM() {
//        Random random = new Random();
//        return String.format("%09d", random.nextInt(1000000000));
//    }




}