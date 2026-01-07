package suobry;

import fileworks.DataExport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingDemo {
    public static void main(String[] args) {
        String filename = "coords.txt";
        DataExport de = new DataExport(filename);
        for (int i = 0; i < 10000; i++) {
            de.writeLine(String.valueOf((Math.random()*20000-10000+1)));
        }
        try {
            FileWriter fw = new FileWriter(filename);
            for (int i = 0; i < 10000; i++) {
                fw.write(String.valueOf((int)(Math.random()*20000-10000+1)));
                fw.write(", ");
                fw.write(String.valueOf((int)(Math.random()*20000-10000+1)));
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e){
            System.out.println("chyba pri pracovani se souborem: " + e);
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < 10000; i++) {
                bw.write(String.valueOf((int) (Math.random() * 20000 - 10000 + 1)) + ", " + String.valueOf((int) (Math.random() * 20000 - 10000 + 1)));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
