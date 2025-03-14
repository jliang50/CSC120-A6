import java.util.ArrayList;

/*
 * The car class represents a car that can carry passengers
 */
public class Car implements CarRequirements {

    // Attributes
    private ArrayList<Passenger> passengers;
    private int maxCapacity;

    /** Contructor for Car
     * Initializes the list of passengers and the specified maximum capacity
     * @param max The maximum capcities of passengers that the car can have
     */
    public Car(int max){
        this.maxCapacity = max;
        this.passengers = new ArrayList<>(maxCapacity);
    }
  
    /**
     * Returns the max capacity of the car
     * @return The maximum capcity of the car
     */
    public int getCapacity(){
        return maxCapacity;
    }

    /**
     * Calculates the number of remaining seats available in the car
     * @return The remainning seats that the car have
     */
    public int seatsRemaining(){
        return maxCapacity-passengers.size();
    }
  
    /**
     * Adds a passenger to the car. If the passenger can be added, which means the passenger is onboard or there are seats remaining, return true. Return false if there are no available seats.
     * @param p The passenger that is added to the car.
     * @return true if the passenger is already on the list or the passenger is added successfully, false if the passenger cannot be added.
     */
    public Boolean addPassenger(Passenger p){
        if(passengers.contains(p)){
            System.out.println("Passengers already onboard.");
            return true;
        } else{
            if(seatsRemaining()>0){
                passengers.add(p);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the passenger from the car if they are onboard
     * @param p The passenger that is removed from the car
     * @return true if the passenger is removed successfully, false if the passenger is not found in the list.
     */
    public Boolean removePassenger(Passenger p){
        if(passengers.contains(p)){
            passengers.remove(p);
            return true;
        }
        return false;
    }
  
    /**
     * Prints the current manifest of  passenger in the car
     * Prints "This car is EMPTY" if there is no one on board
     */
    public void printManifest() {
      if (passengers.size() == 0) {
          System.out.println("This car is EMPTY.");
      } else {
          for (Passenger p : passengers) {
              System.out.println(p.getName());
          }
      }
    }

    // This method aims to display the functionality of this class.
    public static void main(String[] args){
        Car car = new Car(5);

        Passenger passenger1 = new Passenger("Joyce");
        Passenger passenger2 = new Passenger("Liang");
        Passenger passenger3 = new Passenger("Xitong");

        car.addPassenger(passenger1);
        car.addPassenger(passenger2);

        System.out.println("Current manifest:");
        car.printManifest();

        car.removePassenger(passenger1);

        System.out.println("\nUpdated manifest:");
        car.printManifest();

        car.addPassenger(passenger3);

        System.out.println("\nFinal manifest:");
        car.printManifest();
    }


}