package streams.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GenreMapping {
    public static void main(String[] args) throws IOException {
        List<Movie> movies = Files.lines(Paths.get("data/movieList.txt"))
                .map(lines -> lines.split(";"))
                .map(tokens -> new Movie(tokens[0], Integer.parseInt(tokens[1]), tokens[2], Double.parseDouble(tokens[3])))
                .toList();

        HashMap<String, List<Movie>> genreMap = new HashMap<>();

        for(Movie movie : movies){
            if (genreMap.containsKey(movie.getGenre())){
                genreMap.get(movie.getGenre()).add(movie);
            }
            else{
                genreMap.put(movie.getGenre(), new ArrayList<>());
                genreMap.get(movie.getGenre()).add(movie);
            }
        }


        for (String genre : genreMap.keySet()){
            System.out.println(genre);
            for (Movie m : genreMap.get(genre)){
                System.out.println("-- " + m.getName());
            }
        }
        //nebo, pokud nejsi kokot:

        Map<String, List<Movie>> alsoGenreMap = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        //

        Map<String, Double> countMap = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getRating)));
    }
}

class Movie{
    String name;
    int year;
    String genre;
    double rating;

    public Movie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


}
