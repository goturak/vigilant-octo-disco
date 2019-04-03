import java.awt.*;

public abstract class Status {
    protected Client client;
    protected int miles;
    protected int money;

    protected float milesRatio;

    protected Status(Client client) {
        this.client = client;
    }
    protected Status(Status oldStatus) {
        this.client = oldStatus.client;
        this.miles = oldStatus.miles;
        this.money= oldStatus.money;
    }


    void addMoney(int amount){
        money+=amount;
        statusChangeCheck();
    }
    public void buyTicketMiles(Ticket t){
        if(miles >= t.getTicketMiles()){
            miles -= t.getTicketMiles();
            client.setLastAction( "Bought a ticket for the flight " + t.getFlight().getName() + " with miles. (" + t.getType() + " " + t.getTicketMiles() + " miles)");
        } else {
            client.setLastAction("Error trying to buy a ticket, not enough miles.");
        }

        statusChangeCheck();
    }
    public void buyTicketMoney(Ticket t){
        if(money >= t.getTicketPrice()){
            money -= t.getTicketPrice();
            client.setLastAction("Bought a ticket for the flight " + t.getFlight().getName() + " with money. (" + t + ")");
            miles += (int)(t.getFlight().getDistance() * milesRatio);

        } else {
            client.setLastAction("Error trying to buy a ticket, not enough money.");
        }
        statusChangeCheck();
    }
    abstract void statusChangeCheck();

    public int getMiles() {
        return miles;
    }

    public int getMoney() {
        return money;
    }

    abstract Color getColor();
}
