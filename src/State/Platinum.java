package State;

import java.awt.*;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class inheritated from status, representing the highest status.
 */
public class Platinum extends Status {

    /**
     * Boolean that represent the "premium" platinum status.
     */
    private boolean locked;

    /**
     * Constructor taking the old status we want to update as param.
     * @param oldStatus the old status we want to update.
     */
    public Platinum(Status oldStatus){
        super(oldStatus);
        locked=false;
        statusChangeCheck();
        milesRatio=1f;
    }

    /**
     * Override of the status change check method.
     */
    @Override
    public void statusChangeCheck() {
        if(miles<10000&& !locked){
            client.setStatus(new Gold(this));
        }

        if(money>=100000){
            locked=true;
        }
    }

    /**
     * Getter of the color
     * @return the color.
     */
    @Override
    public Color getColor() {
        return Color.CYAN;
    }

    /**
     * Override of the toString method
     * @return "PLATINUM"
     */
    @Override
    public String toString() {
        return "PLATINUM";
    }
}
