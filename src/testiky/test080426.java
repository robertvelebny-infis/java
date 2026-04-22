package testiky;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test080426 {
    /**
 * 1. Načtěte soubor data/cars.csv
 *    - přeskočte 1. řádek souboru
 *    - všechny záznamy uložte do List<Car> cars
 * 2. Implementujte všechny metody
 */
    public static void main(String[] args) {
        String path = "data/cars.csv";
        List<Car> cars = loadCars(path);
        printStatistics(cars);
        System.out.println(filterByPrice(cars, 8000));
        System.out.println(getAverageTopSpeed(cars, "Porsche"));
        System.out.println(getCarsAbovePowerByBrand(cars, "Bugatti", 420));
        getBrandPercentage(cars, "Nissan");
        // Vypište průměrnou maximální rychlost aut značky Porsche -------------

        // Vypište všechny auta levnější než 8000 USD -----------------

        // Vypište statistiky o autech na základě jejich "Performance"----------------

        // Vypište všechny auta značky Bugatti nad 420 HP---------

        // Vypište, kolik procent aut je značky Nissan
    }

    /**
     * Vypíše základní statistiky o autech pomocí {@code summaryStatistics}
     * nad hodnotou {@code performance}.
     *
     * @param cars seznam aut
     */
    private static void printStatistics(List<Car> cars) {
        final Comparator<Car> BY_PERFORMANCE = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.performance, o2.performance);
            }
        };

        cars.stream()
                .distinct()
                .sorted(BY_PERFORMANCE)
                .forEach(car -> System.out.println(car.toString()));
    }

    /**
     * Vrátí nový vyfiltrovaný seznam aut.
     *
     * @param cars seznam aut
     * @param price maximální cena (včetně), kterou mohou mít auta v novém seznamu
     * @return nový vyfiltrovaný seznam aut
     */
    private static List<Car> filterByPrice(List<Car> cars, int price) {

        List<Car> filteredCars = new ArrayList<>();

        filteredCars = cars.stream()
                .distinct()
                .filter(car -> car.Price <= price)
                .toList();

        return filteredCars;

        //return null;
    }

    /**
     * Vrátí průměrnou maximální rychlost aut od značky {@code brand}.
     *
     * @param cars vstupní seznam aut
     * @param brand název značky auta (například Škoda)
     * @return průměrná maximální rychlost aut dané značky
     */
    private static double getAverageTopSpeed(List<Car> cars, String brand) {
        double avg = cars.stream()
                .distinct()
                .mapToInt(car -> car.getTotalSpeed())
                .sum();
        return avg;
    }

    /**
     * Načte všechny řádky souboru kromě prvního a vrátí je jako seznam aut.
     *
     * @param path cesta k souboru
     * @return seznam aut
     */
    public static List<Car> loadCars(String path){
        try{
            List<String> lines = Files.readAllLines(Path.of(path));
            List<Car> cars = new ArrayList<>();
            int counter = 0;
            for(String line : lines){
                String[] parts = line.trim().split(",");
                if(counter != 0) {
                    cars.add(new Car(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5])));
                }
                counter++;
            }
            return cars;
        } catch (IOException e) {
            System.out.println("An exception occured whilst attempting to load cars.csv. Too bad!");
        }
        return null;
    }

    /**
     * Vrátí seznam aut dané značky, jejichž výkon je větší než zadaná mez.
     *
     * @param cars vstupní seznam aut
     * @param brand název značky auta
     * @param threshold minimální výkon, který musí auto překročit
     * @return seznam aut dané značky s výkonem větším než {@code threshold}
     */
    public static List<Car> getCarsAbovePowerByBrand(List<Car> cars, String brand, int threshold) {
        List<Car> filteredCars = cars.stream()
                .distinct()
                .filter(car -> car.compName.equals(brand))
                .filter(car -> car.horsePower > threshold)
                .toList();
        return filteredCars;
    }

    /**
     * Vrátí procentuální zastoupení aut dané značky v seznamu.
     * Výsledek je vrácen v procentech, například {@code 24.5}, nikoli {@code 0.245}.
     *
     * @param cars vstupní seznam aut
     * @param brand název značky auta
     * @return procentuální zastoupení aut dané značky v seznamu
     */
    public static double getBrandPercentage(List<Car> cars, String brand) {
        int carCountr = (int)cars.stream()
                .distinct()
                .filter(car -> car.compName.equals(brand))
                .count();
        return carCountr / cars.size();
    }
}

class Car{
    // TODO: Implement
    String compName, carName;
    int horsePower, totalSpeed, Price;
    double performance;

    public Car(String compName, String carName, int horsePower, int totalSpeed, double performance, int price) {
        this.compName = compName;
        this.carName = carName;
        this.horsePower = horsePower;
        this.totalSpeed = totalSpeed;
        Price = price;
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Car{" +
                "compName='" + compName + '\'' +
                ", carName='" + carName + '\'' +
                ", horsePower=" + horsePower +
                ", totalSpeed=" + totalSpeed +
                ", Price=" + Price +
                ", performance=" + performance +
                '}';
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getTotalSpeed() {
        return totalSpeed;
    }

    public void setTotalSpeed(int totalSpeed) {
        this.totalSpeed = totalSpeed;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }
}