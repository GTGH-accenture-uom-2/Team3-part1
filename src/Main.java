import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate birthdate = LocalDate.of(1990, 6, 5);
        isEmail email = new isEmail("example@example.com");
        Insured insured = new Insured(123456789, "John", "Doe", email, birthdate);

        System.out.println(insured);

    }
}
