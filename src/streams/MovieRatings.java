package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRatings {

    public static void main(String[] args) throws IOException {
        List<Movie> movies = Files.lines(Paths.get("data/movies_db/input.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(tokens -> new Movie(Integer.parseInt(tokens[0]), tokens[1], tokens[2]))
                .toList();

        //movies.forEach(System.out::println);

        List<Rating> ratings = Files.lines(Paths.get("data/movies_db/ratings.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(tokens -> new Rating(Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2])))
                .toList();

        //pomoci tohohle, vis na jaky film ukazuje ID
        HashMap<Integer, Movie> referMap = new HashMap<>();
        for (Movie m : movies){
            referMap.put(m.getId(), m);
        }

        for(Rating r : ratings){
            if(referMap.get(r.movieID) == null) continue;
            referMap.get(r.movieID).ratings.add(r.getValue());
        }

        for (Movie m : movies){
            System.out.println(m.getRating());
            System.out.println(m.getInefficientRatings());
        }
    }
}
class Movie{
    int id;
    String name;
    String genre;
    List<Double> ratings;

    public Movie(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        ratings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return name + ", " + genre;
    }

    double getRating(){
        return ratings.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    double getInefficientRatings(){
        System.out.println(ratings);
        double ratingsSum = 0.0;
        for(Double r : ratings){
            ratingsSum += r;
        }
        return (ratingsSum / ratings.size());
    }
}
class Rating{
    int movieID;
    double value;

    public Rating(int movieID, double value) {
        this.movieID = movieID;
        this.value = value;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}