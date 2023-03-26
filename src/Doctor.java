import java.io.Serializable;
import java.util.Date;

public class Doctor extends Person implements Serializable {
    private int medLicNumber;
    private String specialisation;

    public Doctor(String firstName, String lastName, Date dob, String mobileNumber, int medLicNumber, String specialisation) {
        super(firstName, lastName, dob, mobileNumber);
        this.medLicNumber = medLicNumber;
        this.specialisation = specialisation;
    }





    public int getMedLicNumber() {
        return medLicNumber;
    }

    public void setMedLicNumber(int medLicNumber) {
        this.medLicNumber = medLicNumber;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getSpecialisation() {
        return specialisation;
    }




    @Override
    public String toString() {
        return super.toString()+" "+medLicNumber+" "+specialisation;
    }
}
