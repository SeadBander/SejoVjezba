package six;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonXMLDao implements Dao<Person>{

    public static final String FILE_NAME = "persons.xml";

    @Override
    public void write(List<Person> elements) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
             XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream)){
            xmlEncoder.writeObject(elements);

        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Person> read() {
        try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
             XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream)){
            ArrayList<Person> personArrayList = (ArrayList<Person>) xmlDecoder.readObject();
            return  personArrayList;
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return new ArrayList<>();
    }
}
