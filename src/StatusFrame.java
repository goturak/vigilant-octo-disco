import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class StatusFrame extends Frame implements Observer {
    JPanel panel;
    LinkedList<Client> clients;
    HashMap<Integer, JLabel>  labels = new HashMap<>();

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
        getFrame().setContentPane(panel);
        getFrame().setTitle("Statuses");
        getFrame().setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        getFrame().pack();
        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

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

    @Override
    public void update(Observable observable) {
        Client c = (Client)observable;
        JLabel l = labels.get(c.getID());
        selectColor(l, c);
    }

    private void selectColor(JLabel label, Client client){
                label.setForeground(client.getStatus().getColor());
    }
}
