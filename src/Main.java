import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate birthdate = LocalDate.of(1990, 1, 1);
        isEmail email = new isEmail("examplee@xample.com");
        Insured insured = new Insured(123456789, 987654321, "John", "Doe", email, birthdate);

        System.out.println(insured);

    }
}