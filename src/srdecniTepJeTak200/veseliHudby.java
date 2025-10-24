package srdecniTepJeTak200;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

public class veseliHudby {
    public static void main(String[] args) {
        DataImport di = new DataImport("tracks.txt");
        DataExport de = new DataExport("skladby.txt");
        DataExport de2 = new DataExport("Top_10.txt");
        ArrayList<Track> tracks = new ArrayList<>();
        int songCounter = 0;

        while (di.hasNext()) {
            String line = di.readLine();
            String[] lineParsed = line.split(";");

            String name = lineParsed[0];
            int yearOfRelease = Integer.parseInt(lineParsed[1]);
            double rating = Double.parseDouble(lineParsed[2]);
            int length = Integer.parseInt(lineParsed[3]);

            Track track = new Track(
                    name, yearOfRelease, length, rating
            );
            tracks.add(track);
            int minutes = length / 60;
            int seconds = length - (minutes * 60);
            de.writeLine(name + " - " + minutes + ":" + seconds);
            if(songCounter <= 10){
                if(rating >= 8.5){
                    de2.writeLine(track.toString());
                    songCounter++;
                }
            }
        }


        de.finishExport();
        de2.finishExport();
        di.finishImport();
    }
}

class Track{
    String name;
    int yearOfRelease, length;
    double rating;

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", length=" + length +
                ", rating=" + rating +
                '}';
    }

    public Track(String name, int yearOfRelease, int length, double rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.length = length;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
