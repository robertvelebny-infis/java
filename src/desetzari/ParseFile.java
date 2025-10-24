package desetzari;

import fileworks.DataImport;

import java.util.ArrayList;

public class ParseFile {
    public static void main(String[] args) {
        //nacti soubor
        DataImport di = new DataImport("countries.txt");
        //di.printFile();
        System.out.println("prvni zeme:");
        //String countryData = di.readLine();

        //Country firstCountry = parseLine(countryData);
        ArrayList<Country> countries = new ArrayList<>();
        int i = 0;
        while(di.hasNext()){
            countries.add(parseLine(di.readLine()));
            //System.out.println(countries.get(i));
            i++;
        }

//        String[] dataPieces = countryData.split(";");
//        Country firstCountry = new Country(
//                dataPieces[0],
//                dataPieces[1],
//                Long.parseLong(dataPieces[2]),
//                Double.parseDouble(dataPieces[3])
//        );

//        System.out.println(firstCountry.getName());
//        System.out.println(firstCountry.getAge());
//        System.out.println(firstCountry);



        filteredByContinent(countries, "Europe");
        zjistitPocet(countries);
        prumernyVekDoziti(countries);

        di.finishImport();

    }

    static void filteredByContinent(ArrayList<Country> c, String filter){
        //filtrujem severni ameriku
        int kolikStatu = 0;
        for(Country prvek : c){
            if(prvek.getContinent().equalsIgnoreCase(filter)){
                System.out.println(prvek);
                kolikStatu++;
            }
        }
        System.out.println("pocet statu je: " + kolikStatu);

    }

    static void zjistitPocet(ArrayList<Country> c){
        Country nejmensiIndex = null;
        long nejmensiPocet = Long.MAX_VALUE;
        Country nejvetsiIndex = null;
        long nejvetsiPocet = 0;

        for(Country prvek:c){
            if (prvek.getSomething() < nejmensiPocet){
                nejmensiPocet = prvek.getSomething();
                nejmensiIndex = prvek;
            }
            if(prvek.getSomething() > nejvetsiPocet){
                nejvetsiPocet = prvek.getSomething();
                nejvetsiIndex = prvek;
            }
        }

        System.out.println(nejmensiIndex);
        System.out.println(nejvetsiIndex);

    }

    static void prumernyVekDoziti(ArrayList<Country> c){
        double veky = 0.0;
        int pocet = 0;

        for(Country prvek : c){
            veky += prvek.getAge();
            pocet++;
        }
        System.out.println(veky / pocet);
    }

    static Country parseLine(String line){
        String[] dataPieces = line.split(";");
        Country country = new Country(
                dataPieces[0],
                dataPieces[1],
                Long.parseLong(dataPieces[2]),
                Double.parseDouble(dataPieces[3])
        );
        return country;
    }

}

class Country {
    public String name, continent;
    public long something;
    public double age;

    public Country(String name, String continent, long something, double age) {
        this.name = name;
        this.continent = continent;
        this.something = something;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getSomething() {
        return something;
    }

    public void setSomething(long something) {
        this.something = something;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("nazev: %s | kontinent: %s | populace: %,d | doziti: %.2f", name, continent, something, age);
    }
}