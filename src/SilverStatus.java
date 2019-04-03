public class SilverStatus extends State {
    SilverStatus(Client client){
        super(client);
        milesRatio=0.1f;
    }
    SilverStatus(State oldStatus){
        super(oldStatus);
        milesRatio=0.1f;
    }



    @Override
    void statusChangeCheck() {
        if(miles>=1000){
            client.setStatus(new GoldStatus(this));
        }
    }
}
