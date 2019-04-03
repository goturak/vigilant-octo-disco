package Airline;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class representing a ticket.
 */
public class Ticket {
    /**
     * Arguments of the ticket: the flight and the type.
     */
    private Flight flight;
    private TicketType type;

    /**
     * Constructor of tickets.
     * @param flight the flight that we want to book a ticket for.
     * @param type the type of the ticket.
     */
    public Ticket(Flight flight, TicketType type){
        this.flight = flight;
        this.type = type;
    }

    /**
     * Getter of the price, computed as the base price of the flight times the price mult of the type.
     * @return the price in money
     */
    public int getTicketPrice(){
        return flight.getPrice() * type.getPriceMult();
    }

    /**
     * Getter of the price in miles, computed as the distance of the flight times the miles mult of the type.
     * @return the cost in miles.
     */
    public int getTicketMiles(){
        return flight.getDistance() * type.getMilesMult();
    }

    /**
     * Getter of the type of the ticket.
     * @return the type of the ticket.
     */
    public TicketType getType() {
        return this.type;
    }

    /**
     * Getter of the flight
     * @return the flight concerning the ticket.
     */
    public Flight getFlight() { return flight; }

    /**
     * Override of the toString method.
     * @return "type price$"
     */
    @Override
    public String toString(){
        return type + " " + getTicketPrice() + "$";
    }
}
