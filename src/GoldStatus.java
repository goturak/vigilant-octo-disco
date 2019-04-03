public class GoldStatus extends State {


    GoldStatus(State oldStatus){
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
}
