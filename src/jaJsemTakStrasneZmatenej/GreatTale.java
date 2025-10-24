package jaJsemTakStrasneZmatenej;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Hlavni trida pro ukol, pouziva pomocne rozhrani a dve tridy umistene v souboru
 * Trida TextMSG je pro ukazku, funkcionalitu doplnujete zde (GreatTale) a do Tridy {@code Book}
 */
public class GreatTale {

    /**
     * Tato metoda by mela zvladnout praci s TextMsg i Book
     */
//    static int wordCount(){
//    }

    public static int wordCount(Readable object){
        String textButInAString = object.getText();
        System.out.println(textButInAString);
        int spaceCount = 0;
        for (int i = 0; i < textButInAString.length(); i++) {
            if( textButInAString.charAt(i) == ' '){
                spaceCount++;
            }
        }
        return spaceCount + 1;
    }

    public static void main(String[] args) {
        ArrayList<String> LOTR = new ArrayList<>();
        LOTR.add("One Ring to rule them all."); //stranka #1
        LOTR.add("Folk takes their peril with them into Lorien.");
        LOTR.add("Hinder me? Thou fool. No living man may hinder me!");
        LOTR.add("Don’t the great tales never end?"); //stranka #4

        TextMsg msg = new TextMsg("Johnny", "27-06-2003", "Oh, Hi Mark!");
        Book LordOTR = new Book("Lord of the rings", "J. R. R. Tolkien", "29-07-1968", 243, LOTR);
        Book LordOfTheRings = new Book("Lord of the rings", "John Ronald Reuel Tolkien", "29-07-1968", 243, LOTR);
        System.out.println(LordOTR.equals(LordOfTheRings));
        //....melo by vratit True, maji stejne knizni ID (IBM)
//
        System.out.println("Wordcount for LOTR: "  + wordCount(LordOTR));
        System.out.println("Wordcount for Msg: " + wordCount(msg));

        System.out.println("LOTR read:");
        LordOfTheRings.read();

        System.out.println("Message read:");
        msg.read();

//        final Comparator<Book> BY_WORDS = new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                int compare = Integer.compare(o1.pages.size() - o2.pages.size());
//                return compare;h
//            }
//        };

    }


}
interface Readable {
    void read();

    String getText();

}

/**
 * Zde je vas ukol pro implementaci dle zadani
 */
class Book implements Readable, Comparator{
    String name, author, date;
    /**
     * ID pro knihu
     */
    int IBM;
    ArrayList<String> pages;

    public Book(String name, String author, String date, int IBM, ArrayList<String> pages) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.IBM = IBM;
        this.pages = pages;
    }

    @Override
    public String getText(){
        StringBuilder wholeThing = new StringBuilder();
        for (int i = 0; i < this.pages.size(); i++) {
            wholeThing.append(this.pages.get(i));
            wholeThing.append(" ");
        }
        wholeThing.deleteCharAt(wholeThing.length() - 1);
        return wholeThing.toString();
    }


    @Override
    public void read(){
        for (int i = 0; i < this.pages.size(); i++) {
            System.out.println((i + 1) + "/" + (this.pages.size()));
            System.out.println(this.pages.get(i));
        }
    }

    public boolean equals(Book obj) {
        return this.IBM == obj.getIBM();
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public int getIBM() {
        return IBM;
    }

    public ArrayList<String> getPages() {
        return pages;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

class TextMsg  implements Readable, Comparable<TextMsg>{
    String sender;
    String date;
    String text;


    public TextMsg(String sender, String date, String text) {
        this.sender = sender;
        this.date = date;
        this.text = text;
    }

    @Override
    public int compareTo(TextMsg o) {
        String another = o.sender;
        return this.sender.compareTo(another);
    }

    @Override
    public void read() {
        System.out.println("Message received " + date);
        System.out.println(sender + " wrote: ");
        System.out.println(text);
    }

    @Override
    public String getText() {
        return text;
    }
}
