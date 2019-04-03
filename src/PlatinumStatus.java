public class PlatinumStatus extends State {

    boolean locked;
    PlatinumStatus(State oldStatus){
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
}
