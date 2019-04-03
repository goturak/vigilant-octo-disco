/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class representing a frame.
 */

import javax.swing.*;

public abstract class Frame {
    private JFrame frame;

    /**
     * Constructor
     */
    public Frame(){
        this.frame = new JFrame();

    }

    /**
     * Getter of the frame.
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }


}
