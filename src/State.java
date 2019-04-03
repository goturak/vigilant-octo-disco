public abstract class State {
    protected Client client;
    protected int miles;
    protected int money;

    protected float milesRatio;

    protected State(Client client) {
        this.client = client;
    }
    protected State(State oldState) {
        this.client = oldState.client;
        this.miles = oldState.miles;
    }

    void addMiles(int amount){
        miles+=amount;
        statusChangeCheck();
    }
    void addMoney(int amount){
        money+=amount;
        statusChangeCheck();
    }
    public void buyTicketMiles(Ticket t){
        if(miles >= t.getTicketMiles()){
            miles -= t.getTicketMiles();
            client.setLastAction( "Bought a ticket for the flight " + t.getFlight().getName() + " with miles. (" + t.getType() + " " + t.getTicketMiles() + " miles)");
        } else {
            client.setLastAction("Error trying to buy a ticket, not enough miles.");
        }

        statusChangeCheck();
    }
    public void buyTicketMoney(Ticket t){

    }
    abstract void statusChangeCheck();

}
