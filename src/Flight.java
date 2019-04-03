/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class representing a flight.
 */
public class Flight {
    /**
     * Arguments of the flight, the name, the length and the price of the flight.
     */
    private String name;
    private int distance;
    private int price;

    /**
     * Constructor taking a name, a length and a price of a flight.
     * @param name the name of the flight.
     * @param distance the distance in miles
     * @param price the base price
     */
    public Flight(String name, int distance, int price){
        this.name = name;
        this.distance = distance;
        this.price = price;
    }

    /**
     * Getter of the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the distance
     * @return the distance.
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Getter of the price
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Override of the toString method
     * @return "name (distance miles)"
     */
    @Override
    public String toString(){
        return name + " (" + distance + " miles)";
    }

}
