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
        System.out.println(personList.get(0).adopt(personList.get(1)));
        System.out.println(personList.get(0).adopt(personList.get(1)));
        System.out.println(personList.get(0).adopt(personList.get(2)));
        System.out.println(personList.get(0).adopt(personList.get(0)));

        System.out.println("Rozmiar listy: "+personList.size());
        // wyświetalnie elementów listy
        for (Person p : personList) {
            System.out.println(p);
        }

        System.out.println(personList.get(2).getYoungestChild());
        System.out.println(personList.get(0).getYoungestChild());



    }
}