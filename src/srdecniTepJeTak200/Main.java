package srdecniTepJeTak200;

import fileworks.DataImport;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataImport di = new DataImport("movieList.txt");
        ArrayList<Movie> movies = new ArrayList<>();

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
            movies.add(movie);
        }
        ratingReview(movies);
        kolikJeThrilleru(movies);
        nejstarsiFilm(movies);

        di.finishImport();
    }

    static void ratingReview(ArrayList<Movie> filmy) {
        ArrayList<Movie> dobryFilmy = new ArrayList<>();
        for (Movie prvek : filmy) {
            if (prvek.getHodnoceni() >= 9.9) {
                dobryFilmy.add(prvek);
                System.out.println(prvek);
            }
        }
    }

    static void kolikJeThrilleru(ArrayList<Movie> filmy) {
        int kolikThrilleru = 0;
        for (Movie prvek : filmy) {
            if (prvek.getZanr().equals("Thriller")) {
                kolikThrilleru++;
            }
        }
        System.out.println("thrilleru je: " + kolikThrilleru);
    }

    static void nejstarsiFilm(ArrayList<Movie> filmy) {
        Movie nejstarsiIndex = null;
        long nejstarsiHodnota = Long.MAX_VALUE;

        for (Movie prvek : filmy) {
            if (prvek.getRokVydani() < nejstarsiHodnota) {
                nejstarsiHodnota = prvek.getRokVydani();
                nejstarsiIndex = prvek;
            }
        }

        System.out.println(nejstarsiIndex);

    }

}

class Movie {
    String nazev;
    int rokVydani;
    String zanr;
    double hodnoceni;

    @Override
    public String toString() {
        return (nazev + " " + rokVydani + " " + zanr + " " + hodnoceni);
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
}
