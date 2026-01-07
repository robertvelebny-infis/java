package intrfejs;

import java.util.ArrayList;
import java.util.Comparator;

public class Comparing {
    public static void main(String[] args) {
        ArrayList<Track> songs = new ArrayList<>();
        songs.add(new Track("Slavici z madridu", 1967, 9.9, 187));
        songs.add(new Track("Jozin z Bazin", 1978, 7.0, 167));
        songs.add(new Track("Smula", 2008, 10.0, 240));
        //System.out.println(songs);

        final Comparator<Track> BY_DURATION = new Comparator<Track>() {
            @Override
            public int compare(Track o1, Track o2) {
                return Integer.compare(o1.durationSeconds, o2.durationSeconds);
            }
        };

        songs.sort(BY_DURATION);
        System.out.println(songs);
    }
}

class Track implements Comparable<Track>{
    String name;
    int year;
    double rating;
    int durationSeconds;

    final static Comparator<Track> BY_YEAR = new Comparator<Track>() {
        @Override
        public int compare(Track o1, Track o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };

    public Track(String name, int year, double rating, int durationSeconds) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public String toString() {
        return name + " (" + year + ")" + ", rated" + rating;
    }

    @Override
    public int compareTo(Track o) {
        //return this.year - o.year;
        return this.name.compareTo(o.name);
    }


}
