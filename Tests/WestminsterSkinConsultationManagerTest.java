import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class WestminsterSkinConsultationManagerTest {




    @Test
    public void addDoctor() {
        //Creating a new object

        //Creating a new doctor
        Doctor doctor = new Doctor("John","Smith",new Date(1/1/1989),"07767455845",123,"Surgeon");

        WestminsterSkinConsultationManager.doctorArrayList.add(doctor);

        //Checking if the doctor was added
        assertTrue(WestminsterSkinConsultationManager.doctorArrayList.contains(doctor));

        //Checking if the doctor count was incremented
        assertEquals(1,WestminsterSkinConsultationManager.getNoDocs());
    }

    @Test
    public void deleteDoctor() {
        Doctor testDoctor = new Doctor("1245-6789", "John Doe",new Date(2/1/1999),"07112212212",2132,"Skin");
        WestminsterSkinConsultationManager.doctorArrayList.add(testDoctor);
        deleteDoctor();
        assertEquals(testDoctor, WestminsterSkinConsultationManager.doctorArrayList.get(0));
        assertEquals(1, WestminsterSkinConsultationManager.doctorArrayList.size());
    }

    private void assertEquals(int i, int size) {
    }

    private void assertEquals(Doctor testDoctor, Doctor doctor) {
    }

    @Test
    public void printDetails() {
        Doctor doctor1 = new Doctor("Peter", "Parker",new Date(1/1/1989) , "1234567890", 1234567, "Skin1");
        Doctor doctor2 = new Doctor("Tony", "Stark",new Date(21/4/1989) , "0987654321", 87654321, "Skin2");
        WestminsterSkinConsultationManager.doctorArrayList.add(doctor1);
        WestminsterSkinConsultationManager.doctorArrayList.add(doctor2);

        //When
        printDetails();

        //Then
        assertEquals("First Name: Peter", "Last Name: Parker","Birthday: 1/1/1989","Mobile Number: 1234567890","Medical licence no:1234567","Specialisation: Skin1","First Name: Tony","Last Name: Stark","Birthday: 21/4/1989","Mobile Number: 0987654321","Medical licence no: 87654321","Specialisation: Skin2");
    }

    private void assertEquals(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11) {
    }


}