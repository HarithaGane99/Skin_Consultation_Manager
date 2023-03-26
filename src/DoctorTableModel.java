import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DoctorTableModel extends AbstractTableModel implements ActionListener {
    private String[] doctorNames={"First Name","Last Name","DOB","Mobile Number","Medical License Number","Specialisation"}; //Titles of the doctor details table
    private static ArrayList<Doctor> newDoctorArrayList;
    static JPanel p1;
    static JFrame frame;
    static JTable myTable;
    static int index;
    static JButton book,btnSortNew;



    public static JFrame start(){
        ArrayList<Doctor> list;
        list = WestminsterSkinConsultationManager.docList();  //adding loaded doctor details to a new arraylist


        DoctorTableModel tableModel = new DoctorTableModel(list);
        myTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(myTable);



        frame= new JFrame();         //table window frame
        frame.setTitle("Skin Consultation Manager "); //setting frame title

        frame.setVisible(true);
        frame.setSize(400, 300);

        p1=new JPanel();
        p1.setLayout(new BorderLayout());
        JLabel lbl=new JLabel("Skin Consultation Manager ");
        Font  f1  = new Font(Font.DIALOG,  Font.BOLD, 30);
        lbl.setFont(f1);
        btnSortNew=new JButton("Sort");
        DoctorTableModel handler=new DoctorTableModel(list);
        btnSortNew.addActionListener(handler);

        book=new JButton("Book a Doctor");
        book.addActionListener(handler);


        p1.setBorder(new EmptyBorder(0,50,15,45));

        p1.add(lbl,BorderLayout.PAGE_START);
        p1.add(btnSortNew,BorderLayout.EAST);
        p1.add(scrollPane,BorderLayout.CENTER);
        p1.add(book,BorderLayout.SOUTH);

        frame.getContentPane().add(p1);


        return frame;
    }



    public DoctorTableModel(ArrayList<Doctor>dList){
        newDoctorArrayList=dList;
    }

    @Override
    public int getRowCount(){ //getting row counts to create the doctor table
        return newDoctorArrayList.size();
    }
    @Override
    public int getColumnCount() {  //getting column counts to create the doctor table
        return doctorNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;

        if(columnIndex == 0){ // first coloumn - First Name
            temp = newDoctorArrayList.get(rowIndex).getFirstName();

        }
        else if(columnIndex == 1){ // second coloumn - Last Name
            temp = newDoctorArrayList.get(rowIndex).getLastName();

        }
        else if(columnIndex == 2){ // third coloumn - Date of Birth
            temp = newDoctorArrayList.get(rowIndex).getDob();

        }
        else if(columnIndex == 3){ // forth coloumn - Mobile Number
            temp = newDoctorArrayList.get(rowIndex).getMobileNumber();

        }
        else if(columnIndex == 4){ // fifth coloumn - Medical License Number
            temp = newDoctorArrayList.get(rowIndex).getMedLicNumber();

        }
        else if(columnIndex == 5){ // sixth coloumn - Specialisation
            temp = newDoctorArrayList.get(rowIndex).getSpecialisation();

        }
        return temp;

    }
    @Override
    public String getColumnName(int col){                  //getting column name
        return doctorNames[col];
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== btnSortNew) {
            Collections.sort(newDoctorArrayList, Comparator.comparing(Doctor::getLastName));      //sorting doctor list from doctors last name
            frame.dispose();
            start();
        }
        if(e.getSource()==book){
            frame.dispose();
            DoctorBooking.consultGUI();

        }

    }



}
