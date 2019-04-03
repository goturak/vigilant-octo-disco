import java.awt.*;

public class GoldStatus extends Status {


    GoldStatus(Status oldStatus){
        super(oldStatus);
        milesRatio=0.5f;
    }



    @Override
    void statusChangeCheck() {
        if(miles<1000){
            client.setStatus(new SilverStatus(this));
        }else if(miles>=10000){
            client.setStatus(new PlatinumStatus(this));
        }
    }

    @Override
    Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public String toString() {
        return "GOLD";
    }
}
