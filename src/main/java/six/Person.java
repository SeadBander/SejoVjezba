package six;

public class Person {

    private String jmbg;
    private String name;
    private String surname;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "jmbg='" + jmbg + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String jmbg, String name, String surname, int age) {
        this.jmbg = jmbg;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person() {

    }
}
