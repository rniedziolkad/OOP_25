import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PlantUMLRunner.setJarPath("/home/student/Pobrane/plantuml-1.2025.2.jar");
        String umlData = "Alice -> Bob : test";
        try {
            PlantUMLRunner.generateDiagram(umlData, "/home/student/Pobrane/", "diagram.png");
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
        }
        try {
            List<Person> personList = Person.fromCsv("family.csv");

            Person.toBinaryFile(personList, "family.bin");
            List<Person> family = Person.fromBinaryFile("family.bin");
            System.out.println(family.size());
            System.out.println("family.bin");
            for (Person p: family){
                System.out.println(p);
                for (Person child : p.getChildren()) {
                    System.out.println("\t"+child.getFullName());
                }
            }
        } catch (AmbiguousPersonException e) {
            System.err.println(e.getMessage());
        }

        // Na 4 punkty -- kolowkium I 2024 (3 kroki = 1 punkt)
        // czas do terminu I kolokwium 2025
    }
}