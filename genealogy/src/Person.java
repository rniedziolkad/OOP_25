import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.*;
//import java.util.TreeSet;

public class Person implements Comparable<Person>{
    private final String name, surname;
    private final LocalDate birth;
    private final LocalDate death;
    private final Set<Person> children; //= new TreeSet<>();

    public Person(String name, String surname, LocalDate birth, LocalDate death) throws NegativeLifespanException {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.death = death;
        this.children = new HashSet<>();
        if (death != null && death.isBefore(birth))
            throw new NegativeLifespanException(this);
    }

    public static Person fromCsvLine(String csvLine) throws NegativeLifespanException {
        String[] elements = csvLine.split(",", -1);
        String[] fullName = elements[0].split(" ");
        LocalDate birth = LocalDate.parse(elements[1], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.DAY_OF_MONTH, 2)
                .appendLiteral(".")
                .appendValue(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(".")
                .appendValue(ChronoField.YEAR, 4)
                .toFormatter();
        LocalDate death;
        try {
            death = LocalDate.parse(elements[2], formatter);
        } catch (DateTimeParseException e){
            death = null;
        }
        return new Person(fullName[0], fullName[1], birth, death);
    }

    public static List<Person> fromCsv(String csvFileName) {
        List<Person> personList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
            br.readLine();      // pozbywamy się nagłówka
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Person readPerson = fromCsvLine(line);  //przetwarzamy linię
                    personList.add(readPerson);
                } catch (NegativeLifespanException e) {
                    // po prostu ignorujemy linię i nie dodajemy do listy
                    // nie ma potrzeby przerywania wczytywania całego pliku
                    System.err.println(e.getMessage());
                }

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return personList;
    }

    public boolean adopt(Person child) {
        if (child == this)
            return false;
        return children.add(child);
    }

    public Person getYoungestChild() {
        if (children.isEmpty())
            return null;

//        return children.stream().max(Person::compareTo).get();
        return Collections.max(children);
//        Person youngest = null;
//        for (Person child: children) {
//            if (youngest == null || child.birth.isAfter(youngest.birth)) {
//                youngest = child;
//            }
//        }
//        return youngest;
    }

    public List<Person> getChildren() {
        return children.stream().sorted().toList();
    }

    public String getFullName() {
        return name + ' ' + surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.birth.compareTo(o.birth);
    }
}
