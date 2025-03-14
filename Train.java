import java.util.ArrayList;

/**
 * The Train class represents a train that consists of an engine and multiple cars.
 */
public class Train {
    // Attributes
    private Engine engine;
    private ArrayList<Car> cars;
    
    /** 
     * Constructor to initialize the Train with an Engine and a list of Cars.
     * @param fuelType The type of fuel used by the engine.
     * @param fuelCapacity The maximum fuel capacity of the engine.
     * @param nCars The number of cars in the train.
     * @param passengerCapacity The seating capacity per car.
    */
   public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
       this.engine = new Engine(fuelType, fuelCapacity, fuelCapacity);  // Engine starts at full fuel
       this.cars = new ArrayList<>(nCars);

       for (int i = 0; i < nCars; i++) {
           this.cars.add(new Car(passengerCapacity));
       }
   }

    
    /**
     * Returns the engine of the train.
     * @return The engine of the train.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Returns a specific car from the train based on its index
     * @param i The index of the car to return
     * @return The car at a specified index, or null if the index is out of the range
     */
    public Car getCar(int i) {
        if (i>=0 && i<cars.size()) {
            return cars.get(i);
        }
        return null;
    }
    
    /**
     * Calculates the maximum passenger capacity of the train
     * @return The number of maximum passengers capacity of the train
     */
    public int getMaxCapacity() {
        int maxCapacity = 0;
        for (Car car : cars) {
            maxCapacity += car.getCapacity();
        }
        return maxCapacity;
    }

    /**
     * Calculates the number of remaining seats in the train.
     * 
     * @return The number of available seats.
     */
    public int seatsRemaining() {
        int OccupiedSeats = 0;
        for (Car car : cars) {
            OccupiedSeats += car.getCapacity()-car.seatsRemaining();
        }
        return getMaxCapacity()-OccupiedSeats;
    }

    /**
     * @Encapsulation
     * Prints the manifest of the train, including details of all cars.
     */
    public void printManifest() {
        System.out.println("Train Manifest:");
        for (Car car : cars) {
            car.printManifest();
        }
    }

    // This method aims to display the functionality of this class.
    public static void main(String[] args) {
        Train train = new Train(FuelType.STEAM, 100.0, 3, 5);
        Passenger p1 = new Passenger("Joyce");
        Passenger p2 = new Passenger("Liang");
        Passenger p3 = new Passenger("Xitong");

        train.getCar(0).addPassenger(p1);
        train.getCar(1).addPassenger(p2);
        train.getCar(2).addPassenger(p3);

        System.out.println("Train Engine Details:");
        System.out.println(train.getEngine());
        System.out.println("Train Max Capacity: "+ train.getMaxCapacity());
        System.out.println("Available Seats: "+ train.seatsRemaining());
        train.printManifest();
    }
}
