/* This program generates a list of the top 10 electric cars to buy in 2023 by
* utilizing functions, ArrayLists, and classes.
*
* R Stone
*/

package ch02.Lab3a;

import java.util.ArrayList;

public class electricCarList {
    ArrayList<ElectricCar> carList = new ArrayList<>(); // initialized an empty ArrayList

    public static void main(String[] args) {
        electricCarList cars = new electricCarList();

        System.out.println(
                "Here are the top 9 luxury electric cars for 2022 and 2023 because there wasn't a list of just the top electric cars which was strange, but whatever.");

        cars.addCars();
        cars.printList();
    }

    // populates the ArrayList with electric cars.
    public void addCars() {
        carList.add(new ElectricCar("2022 Mercedes-Benz EQS Sedan", 147500, 99, 9.2, 1, "sedan"));
        carList.add(new ElectricCar("2022 Lucid Air", 169000, 122, 9.1, 2, "sedan"));
        carList.add(new ElectricCar("2023 BMW i7", 119300, 85, 8.9, 3, "sedan"));
        carList.add(new ElectricCar("2022 BMW i4", 65900, 108, 8.6, 4, "sedan"));
        carList.add(new ElectricCar("2023 Tesla Model 3", 53900, 126, 8.6, 4, "sedan"));
        carList.add(new ElectricCar("2022 Audi e-tron GT", 142400, 83, 8.5, 6, "sedan"));
        carList.add(new ElectricCar("2023 Polestar 2", 61600, 100, 8.3, 7, "sedan"));
        carList.add(new ElectricCar("2023 Porsche Taycan", 190000, 88, 8.2, 8, "sedan"));
        carList.add(new ElectricCar("2023 Tesla Model S", 135990, 115, 8.0, 9, "sedan"));
    }

    // prints the list by going from index to the end
    public void printList() {
        for (ElectricCar i : carList) {
            System.out.println(i);
        }
    }
}

class ElectricCar {
    // electric car object
    
    final String modelName;
    final double mfgPrice;
    final int maxRange;
    final double rating;
    final int rank;
    final String modelType;

    public String getModelName() {
        return modelName;
    }

    public double getMfgPrice() {
        return mfgPrice;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public double getRating() {
        return rating;
    }

    public int getRank() {
        return rank;
    }

    public String getModelType() {
        return modelType;
    }

    public ElectricCar(String modelName, double mfgPrice, int maxRange, double rating, int rank, String modelType) {
        this.modelName = modelName;
        this.mfgPrice = mfgPrice;
        this.maxRange = maxRange;
        this.rating = rating;
        this.rank = rank;
        this.modelType = modelType;
    }

    @Override
    public String toString() {
        System.out.println("--------------------------------------------");
        System.out.printf("| Model     | = %2s\n" +
                "| Top price | = $%.1f\n" +
                "| Range     | = %d mpg/hwy" +
                "\n| Rating    | = %.1f/10" +
                "\n| Rank      | = #%d" +
                "\n| Type      | = %2s" +
                "\n", modelName, mfgPrice, maxRange, rating, rank, modelType);
        return "--------------------------------------------";
    }
}
