public class NameSurnameValidator {

    public static boolean isValidNameOrSurname(String input) {
        // Check if the input is not null and does not contain numbers or non-alphabetic characters
        if (input == null || !input.matches("[a-zA-Z\\s]+")) {
            return false;
        }
        return true;
    }

    public static void validateNameOrSurname(String input) {
        if (!isValidNameOrSurname(input)) {
            throw new IllegalArgumentException("Invalid name or surname. Must contain only alphabetic characters and spaces, and cannot be null.");
        }
    }
}
