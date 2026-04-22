package testiky;

import java.io.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;

public class test040226 {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        try{
            BufferedReader brPINS = new BufferedReader(new FileReader("data/pins/AllPINs.txt"));
            BufferedReader brPeople = new BufferedReader(new FileReader("data/pins/usernames.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("data/pins/validLogins.txt"));
            String PINread;
            while((PINread = brPINS.readLine()) != null){
                people.add(new Person(brPeople.readLine(), PINread));
            }
            ArrayList<String> paths = new ArrayList<>();
            int valid = 0;
            int invalid = 0;
            for (int i = 1; i < 6; i++) {
                BufferedReader br = new BufferedReader(new FileReader("data/pins/attempts_" + i + ".txt"));
                String line;
                while((line = br.readLine()) != null){
                    String[] lineParsed = line.split("=");
                    //System.out.println(people.get(Integer.parseInt(lineParsed[1]) -1).name + " " + lineParsed[0]);

                    if(people.get(Integer.parseInt(lineParsed[1])).name.equals(lineParsed[0])){
                        bw.write(people.get(Integer.parseInt(lineParsed[1])).name + "=" + lineParsed[1]);
                        valid++;
                    }
                    invalid++;
                }
                br.close();
            }

            System.out.println("amm valid: " + valid + " invalid: " + invalid);

            brPINS.close();
            brPeople.close();
        } catch (IOException e){
            System.out.println("erorr");
        }
    }
}

class Person{
    String name, pin;

    public Person(String name, String pin) {
        this.name = name;
        this.pin = pin;
    }

}
