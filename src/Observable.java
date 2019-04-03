import java.util.LinkedList;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class representing an object that can be observed.
 */
public abstract class Observable {
    /**
     * List of every observer that observe this object.
     */
    private LinkedList<Observer> observers = new LinkedList<>();

    /**
     * This method is used to add an observer to the list of observers.
     * @param o the observer we want to add to the list of observers.
     */
    public void addObserver(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        } else {
            if (!this.observers.contains(o)) {
                this.observers.add(o);
            }
        }
    }

    /**
     * Method used to notify every observers that the object has been subjected to changes.
     */
    public void notifyObservers() {
        Object[] os;
        os = this.observers.toArray();
        for(int i = 0; i < os.length; i++) {
            ((Observer)os[i]).update(this);
        }

    }

    /**
     * Method used to remove and observer from the list of observers.
     * @param o the observer we want to remove frome the list.
     */
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    /**
     * Method used to remove every observer in the list.
     */
    public void removeAllObservers() {
        this.observers.clear();
    }
}
