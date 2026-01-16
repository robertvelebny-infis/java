package suobry;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InvalidPropertiesFormatException;

public class Appendix {
    public static void main(String[] args) {
        //try with resources
        String path = "addded.txt";
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))){ //nemusim pak dat close (to je ten try with resources)

            for (int i = 0; i < 21; i++) {
                pw.write(Integer.toString((int)(Math.random()*100000)));
                pw.close();
            }

        } catch (IOException e){
            System.out.println("An error occured while attempting to read file: " + path);
        }
        try{
            PrintWriter secondPw = new PrintWriter(new BufferedWriter(new FileWriter(path, true))); //true na konci znamena "nevytvarej novej soubor ty debile"
            secondPw.append("test");
            secondPw.close();
        } catch (IOException e){
            System.out.println("An error occured while attempting to read file: " + path);
        }

    }
}
