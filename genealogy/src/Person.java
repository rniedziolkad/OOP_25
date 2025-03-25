import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
//import java.util.TreeSet;

public class Person {
    private final String name, surname;
    private final LocalDate birth;
    private final Set<Person> children; //= new TreeSet<>();

    public Person(String name, String surname, LocalDate birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.children = new HashSet<>();
    }

    public boolean adopt(Person child) {
        if (child == this)
            return false;
        return children.add(child);
    }

    public Person getYoungestChild() {
        if (children.isEmpty())
            return null;

        Person youngest = null;
        for (Person child: children) {
            if (youngest == null || child.birth.isAfter(youngest.birth)) {
                youngest = child;
            }
        }
        return youngest;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth=" + birth +
                ", children=" + children +
                '}';
    }
}
