import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Person> personList = new LinkedList<>();
        List<Person> personList = new ArrayList<>();
        // dodawanie do listy
        personList.add(new Person(
                "Andrzej", "Kowalski",
                LocalDate.of(1980, 1, 1)
        ));
        // pobieranie elementu
        System.out.println(personList.get(0));
        personList.add(new Person(
                "Kuba", "Kowalski",
                LocalDate.of(2015, 10, 20)
        ));
        personList.add(new Person(
                "Ania", "Kowalska",
                LocalDate.of(2018, 3, 13)
        ));
        personList.add(new Person(
                "Adam", "Kowalski",
                LocalDate.of(2013, 10, 1)
        ));
        System.out.println(personList.get(0).adopt(personList.get(1)));
        System.out.println(personList.get(0).adopt(personList.get(1)));
        System.out.println(personList.get(0).adopt(personList.get(2)));
        System.out.println(personList.get(0).adopt(personList.get(0)));
        personList.get(0).adopt(personList.get(3));

        System.out.println("Rozmiar listy: "+personList.size());
        // wyświetalnie elementów listy
        for (Person p : personList) {
            System.out.println(p);
        }

        System.out.println(personList.get(2).getYoungestChild());
        System.out.println(personList.get(0).getYoungestChild());
        System.out.println(personList.get(0).getChildren());
        System.out.println();

        Family family = new Family();
        family.add(personList.get(0), personList.get(1));
        family.add(personList.get(3));
        family.add(new Person(
                "Kuba", "Kowalski",
                LocalDate.of(2013, 5, 5)
        ));
        System.out.println(family.get("Ania Kowalska"));
        System.out.println(family.get("Kuba Kowalski"));
        System.out.println(family.get("Kuba Kowalski"));
        System.out.println(family.get("Adam Kowalski"));

    }
}