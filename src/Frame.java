import javax.swing.*;

public abstract class Frame {
    private JFrame frame;

    public Frame(){
        this.frame = new JFrame();

    }

    public JFrame getFrame() {
        return frame;
    }


}
