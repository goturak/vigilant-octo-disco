import java.util.LinkedList;

public abstract class Observable {
    private LinkedList<Observer> observers = new LinkedList<>();

    public void addObserver(Observer o) {
        if (o == null) {
            throw new NullPointerException();
        } else {
            if (!this.observers.contains(o)) {
                this.observers.add(o);
            }
        }
    }

    public void notifyObservers() {
        Object[] os;
        os = this.observers.toArray();
        for(int i = 0; i < os.length; i++) {
            ((Observer)os[i]).update(this);
        }

    }

    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    public void removeAllObservers() {
        this.observers.clear();
    }
}
