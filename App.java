import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        List<Animal> zoo = new ArrayList<>();
        Map<String, LinkedList<String>> allNames = new HashMap<>();
        allNames.put("hyena", new LinkedList<>());
        allNames.put("lion", new LinkedList<>());
        allNames.put("tiger", new LinkedList<>());
        allNames.put("bear", new LinkedList<>());

        try {
            Scanner nameScanner = new Scanner(new File("animalNames.txt"));
            String currentSpecies = "";
            while (nameScanner.hasNextLine()) {
                String line = nameScanner.nextLine().trim();
                if (line.isEmpty()) continue;
                if (line.contains("Names:")) {
                    currentSpecies = line.split(" ")[0].toLowerCase();
                } else if (!currentSpecies.isEmpty()) {
                    String[] names = line.split(", ");
                    for (String name : names) {
                        allNames.get(currentSpecies).add(name);
                    }
                }
            }
            nameScanner.close();

            Scanner sc = new Scanner(new File("arrivingAnimals.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isBlank()) continue;
                String[] parts = line.split(", ");
                String[] firstPart = parts[0].split(" ");
                int age = Integer.parseInt(firstPart[0]);
                String sex = firstPart[3];
                String species = firstPart[4].toLowerCase();

                Animal a;
                if (species.contains("hyena")) a = new Hyena();
                else if (species.contains("lion")) a = new Lion();
                else if (species.contains("tiger")) a = new Tiger();
                else if (species.contains("bear")) a = new Bear();
                else continue;

                a.setAge(age);
                a.setSex(sex);
                a.setBirthDate(Utilities.genBirthDay(age, parts[1]));
                a.setColor(parts[2]);
                a.setWeight(parts[3]);
                a.setOrigin(parts[4] + ", " + parts[5]);
                a.setArrivalDate(LocalDate.now().toString());

                if (allNames.containsKey(species) && !allNames.get(species).isEmpty()) {
                    a.setAnimalName(allNames.get(species).removeFirst());
                } else {
                    a.setAnimalName("Unknown");
                }

                if (a instanceof Hyena) ((Hyena) a).genUniqueID();
                else if (a instanceof Lion) ((Lion) a).genUniqueID();
                else if (a instanceof Tiger) ((Tiger) a).genUniqueID();
                else if (a instanceof Bear) ((Bear) a).genUniqueID();

                zoo.add(a);
            }
            sc.close();

            PrintWriter writer = new PrintWriter("zooPopulation.txt");
            String[] habitats = {"hyena", "lion", "tiger", "bear"};
            for (String h : habitats) {
                writer.println(h.substring(0, 1).toUpperCase() + h.substring(1) + " Habitat:");
                writer.println("----------------");
                for (Animal a : zoo) {
                    if (h.equalsIgnoreCase(a.getSpecies())) {
                        writer.println(a.getAnimalID() + "; " + a.getAnimalName() + "; birth date: " + a.getBirthDate() + "; " + a.getColor() + "; " + a.getSex() + "; " + a.getWeight() + "; " + a.getOrigin() + "; arrived " + a.getArrivalDate());
                    }
                }
                writer.println();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}