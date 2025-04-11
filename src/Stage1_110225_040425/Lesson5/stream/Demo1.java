package  Stage1_110225_040425.Lesson5.stream;



import  Stage1_110225_040425.Lesson5.stream.model.SeaCreature;
import  Stage1_110225_040425.Lesson5.stream.model.Species;

import java.util.*;

public class Demo1 {

    public void printSpecies(List<SeaCreature> seaCreatures) {
        Set<Species> speciesSet = new HashSet<>();
        for (SeaCreature sc : seaCreatures) {
            if (sc.getWeight() >= 10)
                speciesSet.add(sc.getSpecies());
        }
        List<Species> sortedSpecies = new ArrayList<>(speciesSet);
        Collections.sort(sortedSpecies, new Comparator<Species>() {
            public int compare (Species a, Species b) {
                return Integer.compare(a.getPopulation(), b.getPopulation());
            }
        });
        for (Species s : sortedSpecies)
            System.out.println(s.getName());
    }


    public void printSpeciesStream(List<SeaCreature> seaCreatures) {
        seaCreatures.stream()
                .filter(sc -> sc.getWeight() >= 10)
                .map(SeaCreature::getSpecies)
                .distinct()
                .sorted(Comparator.comparing(Species::getPopulation))
                .map(Species::getName)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {


    }
}
