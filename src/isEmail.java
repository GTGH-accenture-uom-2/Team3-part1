public class isEmail {
    private String emailAddress;

    public isEmail(String emailAddress) {
        if (!isValidEmail(emailAddress)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && !email.trim().isEmpty();
    }

}
