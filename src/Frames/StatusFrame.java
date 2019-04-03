package Frames;

import Airline.Client;
import CustomObserver.Observable;
import CustomObserver.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Class representing a status frame that implements observer.
 */
public class StatusFrame extends Frame implements Observer {
    JPanel panel;
    LinkedList<Client> clients;
    HashMap<Integer, JLabel>  labels = new HashMap<>();

    /**
     * Constructor of the status frame, taking the list of every clients.
     * @param clients all the clients in the system, that will be sorted afterwards.
     */
    public StatusFrame(LinkedList<Client> clients){
        super();
        panel =  new JPanel();
        Collections.sort(clients);
        this.clients = clients;
        createLabels();
        for(Client c : clients){
            c.addObserver(this);
        }
        panel.setPreferredSize(new Dimension(200,200));

        WindowAdapter closeListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                for(Client c : clients) {
                    c.removeObserver(StatusFrame.this);
                }
            }
        };
        getFrame().addWindowListener(closeListener);

        getFrame().setContentPane(panel);
        getFrame().setTitle("Statuses");
        getFrame().setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        getFrame().pack();
        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Private method used to create a JLabel for every client.
     */
    private void createLabels(){
        int pos = 10;
        for(Client client : clients){
            JLabel clientLabel = new JLabel(client.toString());
            selectColor(clientLabel, client);
            clientLabel.setBounds(10, pos, 200,20);
            pos += 25;
            labels.put(client.getID(), clientLabel);
            panel.add(clientLabel);
        }
    }

    /**
     * Override of the observer method
     * @param observable the observable that may have changed.
     */
    @Override
    public void update(Observable observable) {
        Client c = (Client)observable;
        JLabel l = labels.get(c.getID());
        selectColor(l, c);
    }

    /**
     * Private method used to select the correct display color.
     * @param label the JLabel that may be subject to a color change.
     * @param client the client that has been subject to change.
     */
    private void selectColor(JLabel label, Client client){
                label.setForeground(client.getStatus().getColor());
    }
}
