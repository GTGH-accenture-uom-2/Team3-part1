import validators.AFMValidator;

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //Creation of 15 insured
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

        //Creation of 2 Vaccination Centers
        VaccinationCenter firstCenter = new VaccinationCenter("61669","Simeonidi");
        VaccinationCenter secondCenter = new VaccinationCenter("85257", "Konstantinoupoleos");

        //creation of 4 doctors
        for (int i = 0; i < 4; i++){
            String name = greekNames.get(random.nextInt(greekNames.size()));
            String surname = greekSurnames.get(random.nextInt(greekSurnames.size()));
            LocalDate birthdate = generateRandomBirthdate(random);
            String amka = generateAmka(birthdate);
            doctorsList.add(new Doctor(amka, name, surname,birthdate));
        }

        //assign doctors to vaccination center
        firstCenter.assignDoctorsToTimeslots(doctorsList.get(0), doctorsList.get(1));
        secondCenter.assignDoctorsToTimeslots(doctorsList.get(2), doctorsList.get(3));

        //creation of 8 reservations
        List<Reservation> reservations = new ArrayList<>();

        //list of slots for the first center
        Set<Timeslot> firstCenterTimeslotsSet = firstCenter.getTimeslots().keySet();
        List<Timeslot> firstCenterTimeslotsList = new ArrayList<>(firstCenterTimeslotsSet);
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

        reservation1.setReservation(firstCenterTimeslotsList.get(0), firstCenter);
        reservation2.setReservation(firstCenterTimeslotsList.get(1), firstCenter);
        reservation3.setReservation(firstCenterTimeslotsList.get(2), firstCenter);
        reservation4.setReservation(firstCenterTimeslotsList.get(3), firstCenter);
        reservation1.changeReservation(firstCenterTimeslotsList.get(9),firstCenter);

        //list of slots for the second center
        Set<Timeslot> secondCenterTimeslotsSet = secondCenter.getTimeslots().keySet();
        List<Timeslot> secondCenterTimeslotsList = new ArrayList<>(secondCenterTimeslotsSet);
        //Prwto Center MONO


        Reservation reservation5 = new Reservation(insuredList.get(4));
        Reservation reservation6 = new Reservation(insuredList.get(5));
        Reservation reservation7 = new Reservation(insuredList.get(6));
        Reservation reservation8 = new Reservation(insuredList.get(7));


        ArrayList<Reservation> secondCenterReservations = new ArrayList<>();

        secondCenterReservations.add(reservation5);
        secondCenterReservations.add(reservation6);
        secondCenterReservations.add(reservation7);
        secondCenterReservations.add(reservation8);

        secondCenter.setReservationList(firstCenterReservations);

        reservation5.setReservation(secondCenterTimeslotsList.get(0), secondCenter);
        reservation6.setReservation(secondCenterTimeslotsList.get(1), secondCenter);
        reservation7.setReservation(secondCenterTimeslotsList.get(2), secondCenter);
        reservation8.setReservation(secondCenterTimeslotsList.get(3), secondCenter);

        // Displaying the reserved timeslots for verification
        System.out.println("Reservations at First Center:");
        firstCenter.printBookedTimeslots();
        System.out.println("------------------------------------------------");
        System.out.println("Reservations at Second Center:");
        secondCenter.printBookedTimeslots();

        System.out.println("-------------------------------------------------------------------");

        // Displaying the free timeslots for verification
        System.out.println("Available Timeslots for each Vacciantion Center.");
        System.out.println("First Center:");
        firstCenter.printAvailableTimeslots();
        System.out.println("Second Center:");
        secondCenter.printAvailableTimeslots();

        //na emfanizei ta ranteboy toy giatroy
        //doctorsList.get(0).setPerDoctorTimeslots(firstCenter);
        //doctorsList.get(0).printReservedTimeslots();


        System.out.println();
        System.out.println();

        doctorsList.get(0).makeAVaccination(insuredList.get(0),LocalDate.now());
        doctorsList.get(0).makeAVaccination(insuredList.get(1),LocalDate.now());
        doctorsList.get(0).printAllVacinations();

        System.out.println("Those people are over 60 and they didn t book an appointment! ");
        for(Insured ins : insuredList){
            if(!ins.isVaccinated() && ins.getAge()>=60){
                System.out.println(ins);
            }
        }

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
