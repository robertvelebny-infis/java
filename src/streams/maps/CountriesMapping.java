package streams.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountriesMapping {
    public static void main(String[] args) throws IOException {

        List<Country> countries = Files.lines(Paths.get("data/countries.txt"))
                .map(lines -> lines.split(";"))
                .map(tokens -> new Country(tokens[0], tokens[1], Long.parseLong(tokens[2]), Double.parseDouble(tokens[3])))
                .toList();

        Map<String, List<Country>> byName = countries.stream()
                .collect(Collectors.groupingBy(Country::getName));

        //vypsat vsechny zeme
        //countries.forEach(System.out::println);

        Map<String, Long> byContinents = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.counting()));

        for(String contient : byContinents.keySet()){
            System.out.println(contient + " - " + byContinents.get(contient));
        }

        Map<String, Double> lifeSpan = countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.averagingDouble(Country::getLifeExpectancy)));

        HashMap<String, Double> yes = new HashMap<>();

        for(String span : lifeSpan.keySet()){
            System.out.println(span + " - " + lifeSpan.get(span));
            yes.put(span, lifeSpan.get(span));
        }
        double highestAvg = Double.MIN_VALUE;
        String saidCountry = "";
        for(String country : yes.keySet()){
            if((yes.get(country)) > highestAvg){
                highestAvg = yes.get(country);
                saidCountry = country;
            }
        }
        System.out.println("huighest average or smth: " + saidCountry + " " + highestAvg);
    }
}

class Country{
    String name, continent;
    long population;
    double lifeExpectancy;

    public Country(String name, String continent, long population, double lifeExpectancy) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }
}