package intrfejs;

public class playableShowcases {
    public static void main(String[] args) {
        Playable[] media = {new Video("pomoc.exe"),
        new Audio("sfnsfdsf.mp3")};
        media[0].play();
    }
}
class Video implements Playable{

    String filename;

    public Video(String filename) {
        this.filename = filename;
    }

    @Override
    public void play() {
        System.out.println("bůting mídyja plejr...");
        System.out.println("plejing videjou...");
    }

    @Override
    public void printFormat() {
        System.out.println("Format: " + this.filename.split("\\.")[ this.filename.split("\\.").length-1]);
    }
}

class Audio implements Playable{

    String filename;

    public Audio(String filename) {
        this.filename = filename;
    }


    @Override
    public void play() {
        System.out.println("gfdfhwkbetrmghfdbgrhdufjvdnbdjgbefrijdnebjldn");
    }

    @Override
    public void printFormat() {
        System.out.println("mp????: " + filename.endsWith(".mp3"));
    }
}