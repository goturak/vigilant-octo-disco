package State;

import Airline.Client;

import java.awt.*;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class inheritated from status, representing the lowest status.
 */
public class Silver extends Status {
    /**
     * Constructor of the silver status for the client passed as parameter
     * @param client the client which has the silver status
     */
    public Silver(Client client){
        super(client);
        milesRatio=0.1f;
        money=0;
        miles=0;
    }

    /**
     * Constructor taking an old status and update the client with a silver status.
     * @param oldStatus the old status we want to update
     */
    public Silver(Status oldStatus){
        super(oldStatus);
        milesRatio=0.1f;
    }

    /**
     * Method used to check if tht status has to change.
     */
    @Override
    public void statusChangeCheck() {
        if(miles>=1000){
            client.setStatus(new Gold(this));
        }
    }

    /**
     * Getter of the color
     * @return the color of the text.
     */
    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * Override of the toString method
     * @return "SILVER"
     */
    @Override
    public String toString() {
        return "SILVER";
    }
}
