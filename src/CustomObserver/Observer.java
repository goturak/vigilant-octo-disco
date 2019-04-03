package CustomObserver;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Interface used to represent that every observers has to implement an update method that is called when
 * a subject is updated.
 */
public interface Observer{
    void update(Observable observable);
}
