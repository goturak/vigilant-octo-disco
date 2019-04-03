public class Client extends Observable implements Comparable{
    private String lastName;
    private String firstName;
    private int id;

    private int money;
    private int miles;
    private Status status;
    private State state;
    private String lastAction;

    private static int idGenerator = 0;

    private boolean locked = false;

    public String getLastAction(){
        return lastAction;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getMoney() {
        return money;
    }

    public int getMiles() {
        return miles;
    }

    public Status getStatus() {
        return status;
    }

    public int getID(){ return id; }


    public Client(String ln, String fn){
        lastName = ln;
        firstName = fn;
        this.id = idGenerator;
        idGenerator++;
        this.money = 0;
        this.miles = 0;
        this.status = Status.SILVER;
        state=new SilverStatus(this);
        this.lastAction = "";
    }
    public void setStatus(State newStatus){
        this.state=newStatus;
    }
    public void addMoney(int amount){
        if(amount >= 0){
           money += amount;
           checkLocked();
           notifyObservers();
        }
    }
    public void setLastAction(String la){
        this.lastAction=la;
    }
    public void buyTicketMoney(Ticket t){
        if(money >= t.getTicketPrice()){
            money -= t.getTicketPrice();
            lastAction = "Bought a ticket for the flight " + t.getFlight().getName() + " with money. (" + t + ")";
            miles += (int)(t.getFlight().getDistance() * t.getType().getMilesRate());

        } else {
            lastAction = "Error trying to buy a ticket, not enough money.";
        }
        checkStatusChange();
        checkLocked();
        notifyObservers();
    }

    public void buyTicketMiles(Ticket t){
        if(miles >= t.getTicketMiles()){
            miles -= t.getTicketMiles();
            lastAction = "Bought a ticket for the flight " + t.getFlight().getName() + " with miles. (" + t.getType() + " " + t.getTicketMiles() + " miles)";
        } else {
            lastAction = "Error trying to buy a ticket, not enough miles.";
        }
        checkStatusChange();
        notifyObservers();
    }

    private void checkStatusChange(){
        switch (status){
            case SILVER:
                if(miles >= 1000){
                    status = Status.GOLD;
                }
                break;

            case GOLD:
                if(miles < 1000){
                    status = Status.GOLD;
                }
                if(miles >= 10000){
                    status = Status.PLATINIUM;
                }
                break;

            case PLATINIUM:
                if(!locked){
                    if(miles < 10000){
                        status = Status.GOLD;
                    }
                }
                break;
        }
    }

    private void checkLocked(){
        if(status == Status.PLATINIUM && money >= 100000 && !locked){
            locked = true;
        }
    }

    @Override
    public String toString(){
        return lastName + " " + firstName;
    }

    @Override
    public int compareTo(Object o) {
        Client other = (Client)o;
        int result = lastName.compareTo(other.lastName);
        if(result == 0){
            result = firstName.compareTo(other.firstName);
        }
        return result;
    }
}
