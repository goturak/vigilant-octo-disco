import java.awt.*;

public class SilverStatus extends Status {
    SilverStatus(Client client){
        super(client);
        milesRatio=0.1f;
        money=0;
        miles=0;
    }
    SilverStatus(Status oldStatus){
        super(oldStatus);
        milesRatio=0.1f;
    }



    @Override
    void statusChangeCheck() {
        if(miles>=1000){
            client.setStatus(new GoldStatus(this));
        }
    }

    @Override
    Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String toString() {
        return "SILVER";
    }
}
