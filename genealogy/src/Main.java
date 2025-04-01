import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = Person.fromCsv("family.csv");
        System.out.println("family.csv");
        for (Person p: personList){
            System.out.println(p);
        }
        // Na 4 punkty -- kolowkium I 2024 (3 kroki = 1 punkt)
        // czas do terminu I kolokwium 2025
    }
}