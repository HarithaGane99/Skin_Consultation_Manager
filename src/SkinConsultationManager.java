import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface SkinConsultationManager {
    void Menu() throws IOException, ParseException;
    void addDoctor() throws ParseException;
    void deleteDoctor();
    void printDetails();
    void readFromFile () throws IOException;
    void saveToaFile() throws IOException;

}
