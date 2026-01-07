package testiky;

import fileworks.DataImport;

import java.util.*;

public class moreGoddamnMovies {
    static public void printGenres(ArrayList<Movie> movieList, String genre){
        System.out.println(genre + ":");
        for (int i = 0; i < movieList.size(); i++) {
            if(movieList.get(i).getZanr().equals(genre)){
                System.out.println("|- " + movieList.get(i).toString());
            }
        }
    }
    public static void main(String[] args) {
        DataImport di = new DataImport("movieList.txt");
        ArrayList<Movie> movies = new ArrayList<>();
        HashSet<String> genres = new HashSet<>();
        while (di.hasNext()) {
            String line = di.readLine();
            String[] lineParsed = line.split(";");
            String nazev = lineParsed[0];
            int rokVydani = Integer.parseInt(lineParsed[1]);
            String zanr = lineParsed[2];
            double hodnoceni = Double.parseDouble(lineParsed[3]);
            Movie movie = new Movie(
                    nazev,
                    rokVydani,
                    zanr,
                    hodnoceni
            );
            genres.add(lineParsed[2]);
            movies.add(movie);
        }

        di.finishImport();
        final Comparator<Movie> BY_YEAR = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Integer.compare(o1.getRokVydani(), o2.getRokVydani());
            }
        };
        HashSet<Movie> moreMovies = new HashSet<>(movies);
        movies.clear();
        movies.addAll(moreMovies); // :-)
        movies.sort(BY_YEAR);
        System.out.println(movies);
        System.out.println(genres.size());
        printGenres(movies, "Horror");
    }
}

class Movie implements Comparable<Movie>{
    String nazev;
    int rokVydani;
    String zanr;
    double hodnoceni;


    final static Comparator<Movie> BY_YEAR = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Integer.compare(o1.rokVydani, o2.rokVydani);
        }
    };

    @Override
    public String toString() {
        return (nazev + " " + rokVydani + " " + zanr + " " + hodnoceni + "\n");
    }

    public Movie(String nazev, int rokVydani, String zanr, double hodnoceni) {
        this.nazev = nazev;
        this.rokVydani = rokVydani;
        this.zanr = zanr;
        this.hodnoceni = hodnoceni;
    }


    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        this.rokVydani = rokVydani;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public double getHodnoceni() {
        return hodnoceni;
    }

    public void setHodnoceni(double hodnoceni) {
        this.hodnoceni = hodnoceni;
    }

    @Override
    public int compareTo(Movie o) {
        return 0; //smolik pacholik
    }
    public int compare(Movie o1, Movie o2) {
        return Integer.compare(o1.getRokVydani(), o2.getRokVydani());
    }
}