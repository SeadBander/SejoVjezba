package six;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PersonFileDao implements Dao<Person> {

    public static final String FILE_NAME = "persons.txt";

    @Override
    public void write(List<Person> elements) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (Person person : elements) {
                StringJoiner stringJoiner = new StringJoiner(";");
                stringJoiner.add(person.getJmbg());
                stringJoiner.add(person.getName());
                stringJoiner.add(person.getSurname());
                stringJoiner.add(person.getAge() + "");
                //StringBuilder stringBuilder = new StringBuilder();
                //String lineFormat = person.getJmbg()+";"+person.getName()+";"+person.getSurname()+";"+person.getAge();
                printWriter.println(stringJoiner);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public List<Person> read() {
        List<Person> personList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineFields = line.split(";");
                String jmbg = lineFields[0];
                String name = lineFields[1];
                String surname = lineFields[2];
                int age = Integer.parseInt(lineFields[3]);
                Person person = new Person(jmbg, name, surname, age);
                personList.add(person);
            }
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        return personList;
    }
}
