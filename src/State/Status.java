package State;


import Airline.Client;
import Airline.Ticket;

import java.awt.*;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Abstract class representing the status of the account of the client.
 */
public abstract class Status {
    protected Client client;
    protected int miles;
    protected int money;

    protected float milesRatio;

    /**
     * Constructor of the status, taking a client as parameter.
     * @param client the client which owns the account.
     */
    protected Status(Client client) {
        this.client = client;
    }

    /**
     * Constructor of the status taking an old status as parameter.
     * @param oldStatus the oldStatus that will be replaced by this.
     */
    protected Status(Status oldStatus) {
        this.client = oldStatus.client;
        this.miles = oldStatus.miles;
        this.money= oldStatus.money;
    }

    /**
     * Method used to add money to the account
     * @param amount the amount we want to add to the account.
     */
    public void addMoney(int amount){
        money+=amount;
        statusChangeCheck();
    }

    /**
     * Method used to buy ticket with miles.
     * @param t the ticket we want to buy with miles.
     */
    public void buyTicketMiles(Ticket t){
        if(miles >= t.getTicketMiles()){
            miles -= t.getTicketMiles();
            client.setLastAction( "Bought a ticket for the flight " + t.getFlight().getName() + " with miles. (" + t.getType() + " " + t.getTicketMiles() + " miles)");
        } else {
            client.setLastAction("Error trying to buy a ticket, not enough miles.");
        }

        statusChangeCheck();
    }

    /**
     * Method used to buy ticket with money.
     * @param t the ticket we want to buy with money.
     */
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

    /**
     * Abstract method that is called when we want to check for a status change.
     */
    public abstract void statusChangeCheck();

    /**
     * Getter of the miles
     * @return the amount of miles in the account.
     */
    public int getMiles() {
        return miles;
    }

    /**
     * Getter of the money
     * @return the amount of money in the account.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Getter of the color of the status
     * @return the color of the displayed status.
     */
    public abstract Color getColor();
}
