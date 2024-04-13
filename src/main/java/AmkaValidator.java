import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AmkaValidator {

    public static boolean isValidAmka(String amka, LocalDate birthdate) {
        if (amka == null || amka.length() != 11) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        String birthdateStr = birthdate.format(formatter);

        // Check if the first 6 digits match the birthdate
        if (!amka.startsWith(birthdateStr)) {
            return false;
        }

        // Check if the remaining digits are numeric
        for (int i = 6; i < amka.length(); i++) {
            if (!Character.isDigit(amka.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
