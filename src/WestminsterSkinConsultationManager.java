import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class WestminsterSkinConsultationManager implements SkinConsultationManager,Serializable{
    static ArrayList<Doctor> doctorArrayList= new ArrayList<>(10);
    private Scanner sc;
    Doctor doctor;  //Creating Doctor Object
    private static int noDocs; //Number of doctors in the system
    private final int maxDocs=10;  //Maximum doctors that can be added to the system
    private static ArrayList DoctorRead=new ArrayList<Doctor>();  //Arraylist to load doctor objects from saved file





    public static void main(String[] args) throws ParseException, IOException {
        WestminsterSkinConsultationManager westminsterSkinConsultationManager=new WestminsterSkinConsultationManager();
        westminsterSkinConsultationManager.sc=new Scanner(System.in);
        westminsterSkinConsultationManager.Menu() ;
        westminsterSkinConsultationManager.doctorArrayList=new ArrayList<>(10); //doctors array list


    }

    //returning loaded arraylist
    public static ArrayList<Doctor> docList() {
        return DoctorRead;
    }



    public void Menu() throws ParseException, IOException {
        menu:
        while (true) {
            System.out.println("------Menu - Choose your option------");
            System.out.println();
            System.out.println("Press A for Add a new doctor");//10 doctors
            System.out.println("Press D to delete a doctor");
            System.out.println("Press V for Display the list of doctors");
            System.out.println("Press S for save to a file");
            System.out.println("Press R for read from file");
            System.out.println("Press G to Open GUI");
            System.out.println();
            System.out.println("Enter your selection: ");
            String userInput = sc.nextLine();
            userInput=userInput.toUpperCase();

            switch (userInput) {
                case "A":
                    addDoctor();
                    break;
                case "D":
                    deleteDoctor();
                    break;
                case "S":
                    saveToaFile();
                    break ;
                case "R":
                    readFromFile();
                    break ;
                case "V":
                    printDetails();
                    break ;
                case "G":
                    System.out.println("Starting GUI");
                    DoctorTableModel.start();
                    break ;
                default:
                    System.out.println("Invalid input. Please try again!");  //displaying message for an incorrect menu option
            }

        }
    }

    public void addDoctor() throws ParseException {
                if(noDocs<maxDocs) {
                    String firstName=null;
                    Date dob=null;
                    String mobileNumber=null;
                    int medLicNumber=0;
                    String specialisation=null;
                    String lastName=null;
                    try {

                        //getting user inputs
                        System.out.println("Enter Doctor " + " first name");
                        firstName = sc.nextLine();
                        System.out.println("Enter Doctor " + " surname");
                        lastName = sc.nextLine();
                        System.out.println("Enter Doctor " + " Date of Birth (dd/MM/yyyy)");
                        String dob1 = sc.nextLine();
                        dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob1);
                        System.out.println("Enter Doctor " + " Mobile Number");
                        mobileNumber = sc.nextLine();
                        medLicNumber = 0;
                        System.out.println("Enter Doctor " + " License Number");
                        medLicNumber = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Doctor " + " specialisation");
                        specialisation = sc.nextLine();

                        //creating a Doctor object with user inputs
                        doctor = new Doctor(firstName, lastName, dob, mobileNumber, medLicNumber, specialisation);


                        doctorArrayList.add(doctor); //adding doctors to the arraylist
                        noDocs++;

                    }
                    catch (InputMismatchException e){
                        System.out.println("Uh oh! Your input is not the correct type!");
                        sc.nextLine();
                        addDoctor();

                    }
                    catch (Exception e){
                        System.out.println("Your input is not the correct type! "+e);
                        addDoctor();
                    }




                }
                else {
                    System.out.println("Maximum Doctors that can be added to the system is fulfilled");
                    System.out.println();
                }
            }


    public void deleteDoctor() {

        //showing user the list of medical license number of doctors
        for (int i = 0; i < doctorArrayList.size(); i++) {
            System.out.println(i + " " + doctorArrayList.get(i).getMedLicNumber());
        }
        System.out.println("What doctor you are willing to remove. Enter the relevant index");
        int removeIndex = sc.nextInt();
        sc.nextLine();
        if(removeIndex<=doctorArrayList.size()-1) {
            Doctor removedOne = doctorArrayList.remove(removeIndex);
            System.out.println("Doctor " + removedOne.getMedLicNumber() + " has been removed from the system.");
            System.out.println("Doctors currently in the system= " + doctorArrayList.size());
        }
        else {
            System.out.println("Please enter a valid index.");
            System.out.println();
        }

    }



    public void printDetails(){

        //Sorting the doctor arraylist from last name of the doctor
        //SortedList.sort(doctorArrayList,Comparator.comparing(Doctor::getLastName));
        ArrayList<Doctor> SortedList= new ArrayList<>(doctorArrayList);
        SortedList.sort(Comparator.comparing(Doctor::getLastName));

       //display doctor details
        for (int i=0;i<(SortedList.size());i++) {
            System.out.println("First Name: "+SortedList.get(i).getFirstName());
            System.out.println("Last Name: "+SortedList.get(i).getLastName());
            System.out.println("Birthday: "+SortedList.get(i).getDob());
            System.out.println("Mobile Number: "+SortedList.get(i).getMobileNumber());
            System.out.println("Medical licence no: "+SortedList.get(i).getMedLicNumber());
            System.out.println("Specialisation: "+SortedList.get(i).getSpecialisation());
            System.out.println();

        }
    }



//save data into a file
    public void saveToaFile() throws IOException {
        File file=new File("docInfo.txt");  //creating the file
        FileOutputStream fout=new FileOutputStream(file,true);
        ObjectOutputStream objout=new ObjectOutputStream(fout);

        Iterator it=doctorArrayList.iterator();
        while (it.hasNext()){
            Doctor d=(Doctor) it.next();
            objout.writeObject(d);
        }

    }
    public void readFromFile() throws IOException {
        FileInputStream fin=new FileInputStream("docInfo.txt");
        ObjectInputStream objin=new ObjectInputStream(fin);


        while (true){
            try{
                Doctor d=(Doctor) objin.readObject();
                DoctorRead.add(d); //adding read data again in to a Doctor arraylist
            } catch (IOException|ClassNotFoundException e) {
                break;
            }

        }
        System.out.println(DoctorRead);

    }

    public static int getNoDocs(){
        return noDocs;
    }










}