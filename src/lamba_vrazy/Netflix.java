package lamba_vrazy;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Netflix {
    public static ArrayList<Movie> parseMovies(String filePath){
        try{
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            ArrayList<Movie> movies = new ArrayList<>();
            String[] tokens;
            for (String line : lines){
                tokens = line.split(";");
                movies.add(new Movie(
                        tokens[0],
                        Integer.parseInt(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Integer.parseInt(tokens[3])
                ));
            }
            return movies;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ArrayList<Movie> movies = parseMovies("data/Movies.txt");
        System.out.println(movies);

        movies.stream()
                .filter(movie -> (movie.getYear() >= 2000))
                .forEach(System.out::println);
    }
}

class Movie{
    String name;
    int year;
    double rating;
    int duration;

    public Movie(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
