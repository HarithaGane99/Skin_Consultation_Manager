import java.util.Date;

public class Patient extends Person{
    private String patientNo;

    public Patient(String firstName, String lastName, Date dob, String mobileNumber, String patientNo) {
        super(firstName, lastName, dob, mobileNumber);
        this.patientNo = patientNo;
    }



    public String getPatientNo() {
        return patientNo;
    }


    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

}
