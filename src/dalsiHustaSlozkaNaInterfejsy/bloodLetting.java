package dalsiHustaSlozkaNaInterfejsy;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class bloodLetting {
    public static int howManyOfWhat(Set<Donator> dumbasses, String bloodType){
        ArrayList<Donator> hhhhh = new ArrayList<>(dumbasses);
        //System.out.println(dumbasses.size());
        int yes = 0;
        for (int i = 0; i < dumbasses.size(); i++) {
            if(hhhhh.get(i).bloodType.equals(bloodType)){
                yes++;
            }
        }
        return yes;
    }
    public static void main(String[] args) {
        DataImport di = new DataImport("blood.txt");
        Set<Donator> suckers = new HashSet<>();
        while (di.hasNext()){
            String[] parts = di.readLine().trim().split(",");
            Donator d = new Donator(parts[0], parts[1], parts[2].equals("Male"), Integer.parseInt(parts[3]));
            suckers.add(d);
        }
        System.out.println(howManyOfWhat(suckers, "A+"));
        System.out.println(howManyOfWhat(suckers, "A-"));
        System.out.println(howManyOfWhat(suckers, "B+"));
        System.out.println(howManyOfWhat(suckers, "B-"));
        System.out.println(howManyOfWhat(suckers, "O+"));
        System.out.println(howManyOfWhat(suckers, "O-"));
        System.out.println(howManyOfWhat(suckers, "AB+"));
        System.out.println(howManyOfWhat(suckers, "AB-"));
        di.finishImport();
    }
}
class Donator{
    String name, bloodType;
    boolean hasRights;
    int age;

    public Donator(String name, String bloodType, boolean hasRights, int age) {
        this.name = name;
        this.bloodType = bloodType;
        this.hasRights = hasRights;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Donator donator = (Donator) o;
        return hasRights == donator.hasRights && age == donator.age && Objects.equals(name, donator.name) && Objects.equals(bloodType, donator.bloodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bloodType, hasRights, age);
    }

    @Override
    public String toString() {
        return "Donator{" +
                "name='" + name + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", hasRights=" + hasRights +
                ", age=" + age +
                '}';
    }
}
