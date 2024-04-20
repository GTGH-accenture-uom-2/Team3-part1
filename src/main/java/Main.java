import validators.AFMValidator;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        List<String> greekNames = Arrays.asList("Nikos", "Yiannis", "Kostas", "Maria", "Eleni", "Dimitris", "Alexandra", "Vasiliki", "Georgios", "Panagiotis");
        List<String> greekSurnames = Arrays.asList("Papadopoulos", "Nikolaidou", "Kostas", "Dimitriou", "Vasileiou", "Bozatzidou", "Alexaidou", "Giorgiou", "Stamatakis", "Antonopoulos");

        List<Insured> insuredList = new ArrayList<>();
        List<Doctor> doctorsList = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            String name = greekNames.get(random.nextInt(greekNames.size()));
            String surname = greekSurnames.get(random.nextInt(greekSurnames.size()));
            String email = name.toLowerCase() + "." + surname.toLowerCase() + "@gmail.com";
            LocalDate birthdate = generateRandomBirthdate(random);
            String amka = generateAmka(birthdate);
            String afm = generateAFM();

            insuredList.add(new Insured(afm, amka, name, surname, email, birthdate));
        }


        VaccinationCenter firstCenter = new VaccinationCenter("61669","Simeonidi");
        VaccinationCenter secondCenter = new VaccinationCenter("85257", "Konstantinoupoleos");

        for (int i = 0; i < 4; i++){
            String name = greekNames.get(random.nextInt(greekNames.size()));
            String surname = greekSurnames.get(random.nextInt(greekSurnames.size()));
            LocalDate birthdate = generateRandomBirthdate(random);
            String amka = generateAmka(birthdate);

            doctorsList.add(new Doctor(amka, name, surname,birthdate));
        }


        firstCenter.assignDoctorsToTimeslots(doctorsList.get(0), doctorsList.get(1));
        secondCenter.assignDoctorsToTimeslots(doctorsList.get(2), doctorsList.get(3));


        List<Timeslot> firstCenterTimeslots = new ArrayList<>(firstCenter.getTimeslots().keySet());
        List<Timeslot> secondCenterTimeslots = new ArrayList<>(secondCenter.getTimeslots().keySet());

        List<Reservation> reservations = new ArrayList<>();

        //Prwto Center MONO
        Set<Timeslot> timeslotSet = firstCenter.getTimeslots().keySet();
        List<Timeslot> timeslotList = new ArrayList<>(timeslotSet);
        //Prwto Center MONO


        Reservation reservation1 = new Reservation(insuredList.get(0));
        Reservation reservation2 = new Reservation(insuredList.get(1));
        Reservation reservation3 = new Reservation(insuredList.get(2));
        Reservation reservation4 = new Reservation(insuredList.get(3));


        ArrayList<Reservation> firstCenterReservations = new ArrayList<>();

        firstCenterReservations.add(reservation1);
        firstCenterReservations.add(reservation2);
        firstCenterReservations.add(reservation3);
        firstCenterReservations.add(reservation4);

        firstCenter.setReservationList(firstCenterReservations);

        reservation1.setReservation(timeslotList.get(0), firstCenter);
        reservation2.setReservation(timeslotList.get(1), firstCenter);
        reservation3.setReservation(timeslotList.get(2), firstCenter);
        reservation4.setReservation(timeslotList.get(3), firstCenter);

        //doctorsList.get(0).completeVaccination(reservation1);
        //doctorsList.get(0).completeVaccination(reservation2);





//        if (!firstCenterTimeslots.isEmpty() && !secondCenterTimeslots.isEmpty()) {
//            for (int i = 0; i < 4; i++) {
//                if (i < firstCenterTimeslots.size() && i < insuredList.size()) {
//                    firstCenter.makeReservation(firstCenterTimeslots.get(i));
//                    new Reservation(insuredList.get(i)).setReservation(firstCenterTimeslots.get(i), firstCenter);
//                }
//                if (i < secondCenterTimeslots.size() && i+4 < insuredList.size()) {
//                    secondCenter.makeReservation(secondCenterTimeslots.get(i));
//                    new Reservation(insuredList.get(i+4)).setReservation(secondCenterTimeslots.get(i), secondCenter);
//                }
//            }
//        }

        // Displaying the reserved timeslots for verification
        System.out.println("Reservations at First Center:");
        firstCenter.printBookedTimeslots();
        //System.out.println("Reservations at Second Center:");
        //secondCenter.printBookedTimeslots();

        System.out.println("-------------------------------------------------------------------");

        // Displaying the free timeslots for verification
        System.out.println("Available Timeslots for each Vacciantion Center.");
        System.out.println("First Center:");
        firstCenter.printAvailableTimeslots();
        System.out.println("Second Center:");
        secondCenter.printAvailableTimeslots();


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

    private static LocalDate generateRandomBirthdate(Random random) {
        int year = LocalDate.now().getYear() - (10 + random.nextInt(81));
        int month = 1 + random.nextInt(12);
        int dayOfMonth = 1 + random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth());
        return LocalDate.of(year, month, dayOfMonth);
    }

}
