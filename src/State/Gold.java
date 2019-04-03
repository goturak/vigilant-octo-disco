package State;

import java.awt.*;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class inheritated from status, representing the middle status.
 */
public class Gold extends Status {
    /**
     * Constructor of the gold status, taking the old status that has to be updated.
     * @param oldStatus the status we want to update.
     */
    public Gold(Status oldStatus){
        super(oldStatus);
        milesRatio=0.5f;
    }

    /**
     * Override of the status change check method
     */
    @Override
    public void statusChangeCheck() {
        if(miles<1000){
            client.setStatus(new Silver(this));
        }else if(miles>=10000){
            client.setStatus(new Platinum(this));
        }
    }

    /**
     * Getter of the color
     * @return the color of the text.
     */
    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    /**
     * Override of the toString method.
     * @return "GOLD"
     */
    @Override
    public String toString() {
        return "GOLD";
    }
}
