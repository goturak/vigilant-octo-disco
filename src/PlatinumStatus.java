import java.awt.*;

public class PlatinumStatus extends Status {

    boolean locked;
    PlatinumStatus(Status oldStatus){
        super(oldStatus);
        locked=false;
        statusChangeCheck();
        milesRatio=1f;
    }



    @Override
    void statusChangeCheck() {
        if(miles<10000&& !locked){
            client.setStatus(new GoldStatus(this));
        }

        if(money>=100000){
            locked=true;
        }
    }

    @Override
    Color getColor() {
        return Color.CYAN;
    }

    @Override
    public String toString() {
        return "PLATINUM";
    }
}
