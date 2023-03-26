import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



public class DoctorBooking implements ActionListener {
    private static ArrayList<Doctor> newDoctorArrayList;
    private static ArrayList<String> bookedDocs;
    private static ArrayList<String> bookedDates;
    private static ArrayList<String> bookedSlots;
    static JFrame frame2,frame3;
    static JLabel title;
    static JPanel dPanel;
    static JPanel p2,p3,p4,p5,p6,p7,p8,p9;
    static JComboBox box,dBox,mBox,yBox,box2;
    static JLabel dName,dTime;
    static JLabel lbl1, lbl2, lbl3, lbl4, lbl5,lbl6,lbl7,dateLbl,monthLbl,yearLbl,lbl8,lbl9;
    static JTextField firstName,lastName,Birthday,mobileNo,patientId,duration,notes;
    static JButton btnBook,btnBook2;
    static String docName,docNameNew;
    static double cost;
    static String[] timeSlots=new String[4];
    static String[] years={"2023"};
    static String[] months={"1","2","3","4","5","6","7","8","9","10","11","12"};
    static String[] dates={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    static String consultTime,fName,lName,patientNo;
    static String pNote,bDay,mobileNum;
    static String cdate,cmonth, cyear,condate;
    static String[] docNames;
    static ArrayList<Consultation> conInfo=new ArrayList<>(); //consultation array list


    public static JFrame consultGUI() { //book consultation frame
        ArrayList<Doctor> list;
        list = WestminsterSkinConsultationManager.docList();
        DoctorBooking booking=new DoctorBooking(list);


        conInfo=Consultation.getConsultationsArrayList();


       docNames=new String[10];
        for(int i=0;i<list.size();i++){
            docNames[i]=list.get(i).getFirstName()+" "+list.get(i).getLastName();
        }
        timeSlots= new String[]{"16.00", "17.00", "18.00", "19.00"};




        frame2 = new JFrame();
        frame2.setTitle("Doctor Booking ");
        frame2.setSize(300, 300);
        frame2.setBackground(Color.CYAN);
        frame2.setVisible(true);
        frame2.setLayout(new GridLayout(14, 1));
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




        title = new JLabel();
        title.setText("Book Your Consultation ");
        title.setFont(new Font("Verdana", Font.PLAIN, 24));

        dPanel=new JPanel();
        dPanel.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
        dName=new JLabel("Doctor :");

        box=new JComboBox(docNames);
        box.addActionListener(booking);
        box.setSelectedIndex(0);

        dPanel.add(dName);
        dPanel.add(box);



        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));

        lbl1 = new JLabel("First Name");
        lbl2 = new JLabel("Last Name");
        lbl5 = new JLabel("Patient No");

        firstName = new JTextField(8);
        lastName = new JTextField(10);

        patientId = new JTextField(4);
        patientId.setVisible(false);



        p2.add(lbl1);
        p2.add(firstName);
        p2.add(lbl2);
        p2.add(lastName);
        p2.add(lbl5);
        p2.add(patientId);



        p3=new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));

        lbl3 = new JLabel("Birthday");
        lbl4 = new JLabel("Mobile ");

        Birthday = new JTextField(10);
        mobileNo = new JTextField(10);

        p3.add(lbl3);
        p3.add(Birthday);
        p3.add(lbl4);
        p3.add(mobileNo);

        p4 = new JPanel();
        p4.setLayout(new FlowLayout());
        p4.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));

        dateLbl=new JLabel("Consultation Date");
        dBox=new JComboBox(dates);
        dBox.addActionListener(booking);


        monthLbl=new JLabel("Consultation Month:");
        mBox=new JComboBox(months);
        mBox.addActionListener(booking);

        yearLbl=new JLabel("Consultation Year:");
        yBox=new JComboBox(years);
        yBox.addActionListener(booking);


        p4.add(dateLbl);
        p4.add(dBox);
        p4.add(monthLbl);
        p4.add(mBox);
        p4.add(yearLbl);
        p4.add(yBox);

        p5=new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));

        dTime=new JLabel("Time :");

        box2=new JComboBox(timeSlots);
        box2.addActionListener(booking);
        box2.setSelectedIndex(0);




        p5.add(dTime);
        p5.add(box2);
        p6=new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
        lbl6=new JLabel("Duration :");
        duration=new JTextField(4);
        p6.add(lbl6);
        p6.add(duration);

        p7=new JPanel();
        p7.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
        lbl7=new JLabel("Notes");
        notes=new JTextField(20);
        p7.add(lbl7);
        p7.add(notes);

        p8=new JPanel();
        p8.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
        btnBook = new JButton("Book the Doctor");
        btnBook.addActionListener(booking);
        btnBook.setSize(20,10);
        btnBook.setFocusable(false);

        btnBook2=new JButton("Book Another Consultation");
        btnBook2.addActionListener(booking);
        btnBook2.setSize(20,10);
        btnBook2.setFocusable(false);

        p8.add(btnBook);
        p8.add(btnBook2);

        p9=new JPanel();
        p9.setLayout(new FlowLayout(FlowLayout.LEFT,40,10));
        lbl8=new JLabel("Cost :");
        lbl8.setVisible(false);
        lbl9=new JLabel();
        p9.add(lbl8);
        p9.add(lbl9);

        //adding components to the frame
        frame2.add(title,SwingConstants.CENTER);
        frame2.add(dPanel);
        frame2.add(p2);
        frame2.add(p3);
        frame2.add(p4);
        frame2.add(p5);
        frame2.add(p6);
        frame2.add(p7);
        frame2.add(p8);
        frame2.add(p9);
        frame2.pack();



        return frame2;
    }

    public DoctorBooking(ArrayList<Doctor>dList){
        newDoctorArrayList=dList;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Consultation consultation=new Consultation(docName,cost,pNote,cdate,consultTime,patientNo,fName,lName,bDay,mobileNum); //creating consultation object
        if(e.getSource()==btnBook) {


            consultation.setPatientFirstName(firstName.getText());  //getting patient first name
            consultation.setPatientLastName(lastName.getText());    //getting patient last name
            consultation.setNotes(notes.getText());                 //getting patient notes
            double calCost;
            int time = Integer.parseInt(duration.getText());
            if (time <= 1) {                                   //calculating consultation cost according to the consultation hours
                calCost = 15;
            } else {
                calCost = 25 * time;
            }
            lbl8.setVisible(true);
            consultation.setCost(calCost);
            String costlbl = calCost + "";
            lbl9.setText(costlbl);

            cdate = (String) dBox.getSelectedItem();            //getting consultation day
            cmonth = (String) mBox.getSelectedItem();
            cyear = (String) yBox.getSelectedItem();
            condate = cdate + "/" + cmonth + "/" + cyear;
            bookedDates = new ArrayList<>();
            bookedDates.add(condate);
            consultation.setConsultDate(condate);

            consultTime = (String) box2.getSelectedItem();  //getting consultation time
            consultation.setConsultTime(consultTime);
            bookedSlots = new ArrayList<>();
            bookedSlots.add(consultTime);

            docName = (String) box.getSelectedItem();
            consultation.setDoctorName(docName);
            bookedDocs = new ArrayList<>();
            bookedDocs.add(docName);
            String mNum=mobileNo.getText();
            String birthD=Birthday.getText();
            int randomNo = (int)(Math.random() * 10001);
            String patientNumber=String.valueOf(randomNo);
            consultation.setPatientNo(patientNumber);
            patientId.setText(patientNumber);
            patientId.setVisible(true);

            consultation.setBday(birthD);
            consultation.setMobileNum(mNum);

            conInfo.add(consultation);  //adding inputs to consultation arraylist

            String newDate=condate;
            String newDoc=docName;
            String newTime=consultTime;
            if(conInfo.size()>1) {  //
                for (int i = 0; i < conInfo.size(); i++) {
                    if (conInfo.get(i).getConsultDate() == newDate && conInfo.get(i).getConsultTime() == newTime && conInfo.get(i).getDoctorName() == newDoc) {  //checking a timeslot has been booked or not
                        JOptionPane.showMessageDialog(null,"This slot is taken. We are assigning an available Doctor for you.","Notice",JOptionPane.INFORMATION_MESSAGE);
                        conInfo.remove(i).getDoctorName();
                        int randomNum = (int) (Math.random() * WestminsterSkinConsultationManager.getNoDocs());  //assigning a random doctor
                        docNameNew = docNames[randomNum];
                        consultation.setDoctorName(docNameNew);

                    }
                }
            }


                    {
                        JOptionPane.showMessageDialog(null,"Booking has been confirmed.\n\n"+"Doctor Name: "+consultation.getDoctorName()+"\n"+"Date: "+consultation.getConsultDate()+"\n"+"Time: "+consultation.getConsultTime()+"\n"+"Patient Name: "+consultation.getPatientFirstName()+" "+consultation.getPatientLastName()+"\n"+"Patient Id: "+consultation.getPatientNo()+"\n"+"Cost: "+consultation.getPatientNo(),"Booking Confirmed!",JOptionPane.PLAIN_MESSAGE);

                    }


        }
        if (e.getSource() == btnBook2) {
                frame2.dispose();
                consultGUI();
            }


}
}