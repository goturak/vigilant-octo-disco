public class Client extends Observable implements Comparable{
    private String lastName;
    private String firstName;
    private int id;


    private Status status;

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
        return status.getMoney();
    }

    public int getMiles() {
        return status.getMiles();
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


        status =new SilverStatus(this);
        this.lastAction = "";
    }
    public void setStatus(Status newStatus){
        this.status =newStatus;
    }
    public void addMoney(int amount){
        if(amount >= 0){
            status.addMoney(amount);
           /*money += amount;
           checkLocked();*/
           notifyObservers();
        }
    }
    public void setLastAction(String la){
        this.lastAction=la;
    }

    public void buyTicketMoney(Ticket t){
        status.buyTicketMoney(t);

        notifyObservers();
    }

    public void buyTicketMiles(Ticket t){
        status.buyTicketMiles(t);

        notifyObservers();
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
