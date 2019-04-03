import java.awt.*;

public class Gold extends Status {


    Gold(Status oldStatus){
        super(oldStatus);
        milesRatio=0.5f;
    }



    @Override
    void statusChangeCheck() {
        if(miles<1000){
            client.setStatus(new Silver(this));
        }else if(miles>=10000){
            client.setStatus(new Platinum(this));
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
