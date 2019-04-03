/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class representing a client that extends observable and implements comparable.
 */
public class Client extends Observable implements Comparable{
    private String lastName;
    private String firstName;
    private int id;

    private Status status;

    private String lastAction;

    private static int idGenerator = 0;

    /**
     * Getter of the last action
     * @return last action
     */
    public String getLastAction(){
        return lastAction;
    }

    /**
     * Getter of the last name
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter of the first name
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter of the money
     * @return the money in the account of the client
     */
    public int getMoney() {
        return status.getMoney();
    }

    /**
     * Getter of the miles
     * @return the miles in the account of the client
     */
    public int getMiles() {
        return status.getMiles();
    }

    /**
     * Getter of the status
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Getter of the id.
     * @return the id.
     */
    public int getID(){ return id; }

    /**
     * Constructor of the client
     * @param ln the last name of the client
     * @param fn the first name of the client
     */
    public Client(String ln, String fn){
        lastName = ln;
        firstName = fn;
        this.id = idGenerator;
        idGenerator++;
        status =new Silver(this);
        this.lastAction = "";
    }

    /**
     * Setter of the status.
     * @param newStatus the new status we want to give to our client
     */
    public void setStatus(Status newStatus){
        this.status =newStatus;
    }

    /**
     * Methoud that adds an amount of money to the client
     * @param amount the amount of money we want to add to the account.
     */
    public void addMoney(int amount){
        if(amount >= 0){
            status.addMoney(amount);
           notifyObservers();
        }
    }

    /**
     * Setter of the last action
     * @param la the last action of the client
     */
    public void setLastAction(String la){
        this.lastAction=la;
    }

    /**
     * Method used to buy a ticket using money
     * @param t the ticket we want to buy.
     */
    public void buyTicketMoney(Ticket t){
        status.buyTicketMoney(t);

        notifyObservers();
    }

    /**
     * Method used to buy a ticket with miles.
     * @param t the ticket we want to buy with miles.
     */
    public void buyTicketMiles(Ticket t){
        status.buyTicketMiles(t);

        notifyObservers();
    }

    /**
     * Override of the toString method
     * @return the last and first name of the client.
     */
    @Override
    public String toString(){
        return lastName + " " + firstName;
    }

    /**
     * Method used to compare two clients.
     * @param o the other client.
     * @return 0  if both are the same, positive number if other is bigger, negative number otherwise
     */
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
