/*
 * The engine class represents the locomotive engine that runs on a specific fueltype with a specific fuel level.
 */

public class Engine implements EngineRequirements {

    // Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /** constructor for Engine
     * @param f Engine's fuel type
     * @param currentFuelLevel Engine's current fuel level
     * @param maxFuelLevel Engine's maximum fuel level
    */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel) {
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;

    }
    // Obtain the fuel type of the engine
    public FuelType getFuelType() {
        return this.f;
    }

    // Obtain the maximum fuel level that the engine can hold
    public double getMaxFuel() {
        return maxFuelLevel;
    }

    // Obtain the current fuel level of the engine
    public double getCurrentFuel() {
        return currentFuelLevel;
    }

    // Refuels the engine to its maximum level
    public void refuel() {
        currentFuelLevel = maxFuelLevel;
    }
    
    /**
     * Checks if the engine has enough fuel to function. If there is, decreases the fuel level by one and return true, else return false.
     * 
     * @return true if the engine has enough fuel, else return flase if the engine if out of fuel.
     */
    public Boolean go() {
        if (currentFuelLevel>0) {
            System.out.println(currentFuelLevel);
            currentFuelLevel -= 1;;
            return true;
        }
        else {
            return false;
        }
    }
    
    // This method aims to display the functionality of this class.
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC,50.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }

}