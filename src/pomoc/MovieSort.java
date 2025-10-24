package pomoc;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

public class MovieSort {
    static void sortAlphabetically(ArrayList<Movie> movies){
        movies.sort(Movie.BY_NAME);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    static void sortByYear(ArrayList<Movie> movies){
        movies.sort(Movie.BY_YOR.reversed());
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    static void sortByRating(ArrayList<Movie> movies){
        movies.sort(Movie.BY_RATING.reversed());
        for (int i = 0; i < 10; i++) {
            System.out.println(movies.get(i));
        }
    }


    public static void main(String[] args) {
        DataImport di = new DataImport("Movies.txt");
        ArrayList<Movie> movies = new ArrayList<>();

        while (di.hasNext()) {
            String line = di.readLine();
            String[] lineParsed = line.split(";");
            String name = lineParsed[0];
            int yearOR = Integer.parseInt(lineParsed[1]);
            double rating = Double.parseDouble(lineParsed[2]);
            int length = Integer.parseInt(lineParsed[3]);
            Movie movie = new Movie(
                    name,
                    yearOR,
                    rating,
                    length
            );
            movies.add(movie);
        }

        System.out.println("PODLE JMENA ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        sortAlphabetically(movies);
        System.out.println("PODLE ROKU VYDANI ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        sortByYear(movies);
        System.out.println("TOP 10 PODLE HODNOCENI --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        sortByRating(movies);

        di.finishImport();

    }

}

class Movie implements Comparable<Movie>{
    String name;
    int yearOfRelease, duration;
    double rating;

    public Movie(String name, int yearOfRelease, double rating, int duration) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.duration = duration;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    final static Comparator<Movie> BY_NAME = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };;

    final static Comparator<Movie> BY_YOR = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o1.yearOfRelease, o2.yearOfRelease);
        }
    };

    final static Comparator<Movie> BY_RATING = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };

    @Override
    public int compareTo(Movie o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", duration=" + duration +
                ", rating=" + rating +
                '}';
    }
}
