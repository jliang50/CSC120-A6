/*
 * The passenger class helps a passenger get on or get off a car.
 */
public class Passenger implements PassengerRequirements {

    private String name;
    /**
     * Contructor for a Passenger with given name
     * @param name The name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }
    
    /**
     * If true, the passenger successfully boards. If false, the car might be full, so it prints a message.
     * @param c The car object to check
     */
    public void boardCar(Car c) {
        if (c.addPassenger(this)) {  
            System.out.println(this.name + "has boarded the car.");
        } else {
            System.out.println(this.name + "couldn't board; the car might be full.");
        }
    }

    /**
     * If true, the passenger successfully exits. If false, the passenger wasn't onboard.
     * @param c The car object to check
     */
    public void getOffCar(Car c) {
        if (c.removePassenger(this)) {  
            System.out.println(name + " has gotten off the car.");
        } else {
            System.out.println(name + " wasn't in the car.");
        }
    }

    /**
     * Retrieves the name of the passenger
     * @return The name of the passenger
     */
    public String getName() {
        return name;
    }

}
