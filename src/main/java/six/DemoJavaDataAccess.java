package six;

import java.util.ArrayList;
import java.util.List;

public class DemoJavaDataAccess {
    public static void main(String[] args) {
        /*Person person = new Person();
        person.setName("Sejo");
        person.setSurname("Bander");
        person.setAge(20);
        person.setJmbg("123456");
        System.out.println(person);*/

        /*List<Person> personList = new ArrayList<>();
        personList.add(new Person("123456", "Sejo", "Bander", 15));
        personList.add(new Person("321654", "Sejo1", "Bander1", 16));
        personList.add(new Person("654789", "Sejo2", "Bander2", 17));
        personList.add(new Person("987456", "Sejo3", "Bander3", 18));
        personList.add(new Person("369852", "Sejo4", "Bander4", 19));*/

        /*Dao<Person> personDao = new PersonFileDao();
        List<Person> personList = personDao.read();*/
        Dao<Person> personDao1 = new PersonXMLDao();
        List<Person> personList1 = personDao1.read();
        personList1.forEach(System.out::println);
        //personDao1.write(personList);
    }
}
