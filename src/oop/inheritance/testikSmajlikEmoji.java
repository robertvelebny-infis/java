package oop.inheritance;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.copyOf;

public class testikSmajlikEmoji {

    public static void main(String[] args) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        String minName = "";
        String maxName = "";
        DataImport di = new DataImport("hospitalData.txt");
        DataExport de = new DataExport("thisMakesMeWantToGoWatchHouseMD.txt");
        ArrayList<Doctor> doctors = new ArrayList<>();
        char ahoj = 'a';
        while (di.hasNext()) {
            String line = di.readLine();
            String[] lineParsed = line.split(";");
            String name = lineParsed[0];
            String field = lineParsed[1];
            ArrayList<String> jobs = new ArrayList<String>();
            for(int i = 2; i < lineParsed.length; i++) {
                jobs.add(lineParsed[i]);
            }
            if(field.equals("Doctor")){
                Doctor doctor = new Doctor(
                        name,
                        line
                );
                doctors.add(doctor);
            }
            if(field.equals("Surgeon")){
                Surgeon surgeon = new Surgeon(
                        name,
                        line
                );
                doctors.add(surgeon);
            }
            if(field.equals("CardiacSurgeon")){
                CardiacSurgeon cardiacSurgeon = new CardiacSurgeon(
                        name,
                        line
                );
                doctors.add(cardiacSurgeon);
            }
        }

        for (int i = 0; i < doctors.size(); i++) {
            de.writeLine(doctors.get(i).toString());
            if(doctors.get(i).getSalary() > maximum){
                maximum = doctors.get(i).getSalary();
                maxName = doctors.get(i).name;
            }
            if(doctors.get(i).getSalary() < minimum){
                minimum = doctors.get(i).getSalary();
                minName = doctors.get(i).name;
            }
        }
        System.out.println("worst doctor: " + minName + ": " + minimum);
        System.out.println("best doctor: " + maxName + ": " + maximum);


        di.finishImport();
        de.finishExport();
    }
}
//------------------------------------------------------------------------------------------
class Doctor {
    String name;
    int salary;

    void doFunnyStuff(String[] jobs){
        for (int i = 2; i < jobs.length; i++) {
            if (jobs[i].equals("D")) {
                diagnose();
            }
            if (jobs[i].equals("S")) {
                this.salary -= 50000;
            }
            if (jobs[i].equals("C")) {
                this.salary -= 50000;
            }
        }
    }

    public Doctor(String name, String jobs) {
        this.name = name;
        this.salary = 25000;
        String[] lineParsed = jobs.split(";");
        doFunnyStuff(lineParsed);
    }

    public Doctor(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    void diagnose(){
        System.out.println("Figuring out what's wrong...");
        this.salary += 10000;
    }

    @Override
    public String toString() {
        return name + ";" + salary;
    }

    public int getSalary() {
        return salary;
    }
}
//---------------------------------------------------------------------------------------------
class Surgeon extends Doctor {

    final static int SURGEON_BONUS = 30000;

    void doFunnyStuff(String[] jobs){
        for (int i = 2; i < jobs.length; i++) {
            if (jobs[i].equals("D")) {
                diagnose();
            }
            if (jobs[i].equals("S")) {
                surgery();
            }
            if (jobs[i].equals("C")) {
                this.salary -= 50000;
            }
        }
    }

    public Surgeon(String name, String jobs) {
        //omezeni: kdyz to, od ceho dedim, ma konstruktor
        //-> ja musim mit minimalne stejnej
        super(name, jobs);
        this.salary = 25000 + SURGEON_BONUS;
        String[] lineParsed = jobs.split(";");
        doFunnyStuff(lineParsed);
    }

    public Surgeon(String name, int salary) {
        //omezeni: kdyz to, od ceho dedim, ma konstruktor
        //-> ja musim mit minimalne stejnej
        super(name, salary);
        this.salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("Cutting open...");
        this.salary += 45000;
    }
}
//------------------------------------------------------------------------------
class CardiacSurgeon extends Surgeon {
    final static int CARDIO_BONUS = 50000;


    void doFunnyStuff(String[] jobs){
        for (int i = 2; i < jobs.length; i++) {
            if (jobs[i].equals("D")) {
                diagnose();
            }
            if (jobs[i].equals("S")) {
                surgery();
            }
            if (jobs[i].equals("C")) {
                cardiacSurgery();
            }
        }
    }

    public CardiacSurgeon(String name, String jobs) {
        super(name, jobs);
        this.salary = 25000 + CARDIO_BONUS;
        String[] lineParsed = jobs.split(";");
        doFunnyStuff(lineParsed);
    }


    public CardiacSurgeon(String name, int salary) {
        super(name, salary);
        this.salary += CARDIO_BONUS;
    }

    void cardiacSurgery(){
        System.out.println("Cut my heart into pieces...");
        this.salary += 95000;
    }
}
