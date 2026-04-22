package lamba_vrazy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountriesStreaming {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        List<Country> countries = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Path.of(path));

            for(String line : lines){
                String[] parts = line.trim().split(";");
                countries.add(new Country(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
            }


            String[] continents = {"asia", "north america", "south america", "africa", "europe", "oceania"};

            for (String continent : continents){
                long countriesContinent = countries.stream()
                        .distinct()
                        .filter(country -> country.continent.equalsIgnoreCase(continent))
                        .count();
                System.out.println(continent +  ": " + countriesContinent);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Country{
    String name;
    String continent;
    int population;
    double avgLifeExpectancy;

    public Country(String name, String continent, int population, double avgLifeExpectancy) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgLifeExpectancy = avgLifeExpectancy;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getAvgLifeExpectancy() {
        return avgLifeExpectancy;
    }

    public void setAvgLifeExpectancy(double avgLifeExpectancy) {
        this.avgLifeExpectancy = avgLifeExpectancy;
    }
}
