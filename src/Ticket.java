public class Ticket {
    private Flight flight;
    private TicketType type;

    public Ticket(Flight flight, TicketType type){
        this.flight = flight;
        this.type = type;
    }

    public int getTicketPrice(){
        return flight.getPrice() * type.getPriceMult();
    }
    public int getTicketMiles(){
        return flight.getDistance() * type.getMilesMult();
    }
    public TicketType getType() {
        return this.type;
    }
    public Flight getFlight() { return flight; }

    @Override
    public String toString(){
        return type + " " + getTicketPrice() + "$";
    }
}
