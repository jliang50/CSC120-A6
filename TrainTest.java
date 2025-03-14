import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    /**
     * Tests if the Engine constructor initializes correctly with fuel type and levels.
     */
    @Test
    public void testEngineConstructor() {
        Engine engine = new Engine(FuelType.STEAM, 50.0, 100.0);
        assertEquals(FuelType.STEAM, engine.getFuelType());
        assertEquals(50.0, engine.getCurrentFuel(), 0.01);
        assertEquals(100.0, engine.getMaxFuel(), 0.01);
    }

    /**
     * Tests if the go() method reduces fuel correctly.
     */
    @Test
    public void testEngineGo() {
        Engine engine = new Engine(FuelType.ELECTRIC, 10.0, 100.0);
        engine.go();
        assertEquals(9.0, engine.getCurrentFuel(), 0.01);
    }

    // Car Tests
    /**
     * Tests if adding a passenger increases the count.
     */
    @Test
    public void testCarAddPassenger() {
        Car car = new Car(2);
        Passenger passenger = new Passenger("Luna");
        assertTrue(car.addPassenger(passenger));
        assertEquals(1, car.getCapacity() - car.seatsRemaining());
    }

    /**
     * Tests if removing a passenger decreases the count correctly.
     */
    @Test
    public void testCarRemovePassenger() {
        Car car = new Car(2);
        Passenger passenger = new Passenger("Luna");
        car.addPassenger(passenger);
        assertTrue(car.removePassenger(passenger));
        assertEquals(0, car.getCapacity() - car.seatsRemaining());
    }

    // Passenger Tests
    /**
     * Tests if a passenger successfully boards a car with available space.
     */
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car car = new Car(1);
        Passenger passenger = new Passenger("Joyce");
        passenger.boardCar(car);
        assertEquals(0, car.seatsRemaining());
    }

    /**
     * Tests if a passenger cannot board a full car.
     */
    @Test
    public void testPassengerBoardCarFull() {
        Car car = new Car(1);
        Passenger passenger1 = new Passenger("Joyce");
        Passenger passenger2 = new Passenger("Doris");
        car.addPassenger(passenger1);
        passenger2.boardCar(car);
        assertEquals(0, car.seatsRemaining());
    }

    // Train Tests
    /**
     * Tests if a train initializes correctly with a given number of cars.
     */
    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 3, 10);
        assertEquals(3, train.getMaxCapacity() / 10);
    }

    /**
     * Tests if the train updates its passenger count correctly.
     */
    @Test
    public void testTrainPassengerCount() {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 2, 5);
        Passenger p1 = new Passenger("Luna");
        Passenger p2 = new Passenger("Joyce");
        train.getCar(0).addPassenger(p1);
        train.getCar(1).addPassenger(p2);
        assertEquals(2, train.getMaxCapacity() - train.seatsRemaining());
    }

    /**
     * Tests if the getCar(int i) method returns the expected car.
     */
    @Test
    public void testTrainGetCar() {
        Train train = new Train(FuelType.STEAM, 100.0, 3, 10);
        assertNotNull(train.getCar(1));
        assertNull(train.getCar(3));
    }

    /**
     * Tests if printManifest() correctly iterates through the train’s cars.
     */
    @Test
    public void testTrainPrintManifest() {
        Train train = new Train(FuelType.ELECTRIC, 100.0, 2, 5);
        Passenger p1 = new Passenger("Luna");
        train.getCar(0).addPassenger(p1);
        train.printManifest();
    }
}


