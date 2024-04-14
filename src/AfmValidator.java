public class AfmValidator {

    private final String afm;

    public AfmValidator(String afm) {
        if (!isValidAFM(afm)) {
            throw new IllegalArgumentException("Invalid AFM: AFM must be exactly 9 digits long.");
        }
        this.afm = afm;
    }

    public String getAfm() {
        return afm;
    }

    private static boolean isValidAFM(String afm) {
        return afm != null && afm.matches("\\d{9}");
    }

    @Override
    public String toString() {
        return "AFMValidator{" +
                "afm='" + afm + '\'' +
                '}';
    }

}