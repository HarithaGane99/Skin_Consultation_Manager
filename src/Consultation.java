import java.util.ArrayList;
import java.util.Date;

public class Consultation {
    private double cost=10;
    private String notes;
    private String consultDate;
    private String consultTime;
    String doctorName;
    Patient patient;
    Doctor doctor;
    String patientNo;
    String patientFirstName;
    String patientLastName;
    String bday;
    String mobileNum;
    private static ArrayList <Consultation> consultationsArrayList= new ArrayList<>(10);

    public Consultation(String docName, double cost, String pNote, String cdate, String consultTime, String patientNo, String fName, String lName,String bday,String mobileNum) {
        this.doctorName=docName;
        this.cost=cost;
        this.notes=pNote;
        this.consultDate=cdate;
        this.consultTime=consultTime;
        this.patientNo=patientNo;
        this.patientFirstName=fName;
        this.patientLastName=lName;
        this.bday=bday;
        this.mobileNum=mobileNum;

    }

    public void setConsultDate(String consultDate) {
        this.consultDate = consultDate;
    }

    public void setConsultTime(String consultTime) {
        this.consultTime = consultTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public static ArrayList<Consultation> getConsultationsArrayList(){
        return consultationsArrayList;
    }


    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }


    @Override
    public String toString() {
        return "Consultation{" +
                "cost=" + cost +
                ", notes='" + notes + '\'' +
                ", consultDate='" + consultDate + '\'' +
                ", consultTime='" + consultTime + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patientNo='" + patientNo + '\'' +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientLastName='" + patientLastName + '\'' +
                '}';
    }

    public double getCost() {
        return cost;

    }

    public String getNotes() {
        return notes;
    }

    public String getConsultDate() {
        return consultDate;
    }

    public String getConsultTime() {
        return consultTime;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
}
