import javax.swing.*;
import java.awt.*;

public class ClientDetailsFrame extends Frame implements Observer {
    private Client client;
    private JPanel panel;
    private JLabel lastName;
    private JLabel firstName;
    private JLabel credits;
    private JLabel nbMiles;
    private JLabel status;
    private JLabel lastAction;

    public ClientDetailsFrame(Client client){
        this(client,  new Rectangle(0,0, 700,140));
    }

    public ClientDetailsFrame(Client client, Rectangle bound){
        super();

        this.panel = new JPanel();
        this.lastName = new JLabel("Last name: " + client.getLastName());
        this.firstName = new JLabel("First name: " + client.getFirstName());
        this.credits = new JLabel("Credits: " + client.getMoney());
        this.nbMiles = new JLabel("Nb miles: " + client.getMiles());
        this.status = new JLabel("Status: "+ client.getStatus());
        this.lastAction = new JLabel("Last action: " + client.getLastAction());

        this.client = client;
        client.addObserver(this);

        lastName.setBounds(10,10,700,20);
        firstName.setBounds(10,30,700,20);
        credits.setBounds(10,50,700,20);
        nbMiles.setBounds(10,70,700,20);
        status.setBounds(10,90,700,20);
        lastAction.setBounds(10,110,700,20);

        panel.add(lastName);
        panel.add(firstName);
        panel.add(credits);
        panel.add(nbMiles);
        panel.add(status);
        panel.add(lastAction);

        getFrame().setContentPane(panel);
        getFrame().setTitle("Details of client #" + client.getID());
        getFrame().setBounds(bound);
        getFrame().setLayout(null);
        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void update(Observable observable) {
        credits.setText("Credits: " + client.getMoney());
        nbMiles.setText("Nb miles: " + client.getMiles());
        status.setText("Status: " + client.getStatus());
        lastAction.setText("Last action: " + client.getLastAction());
    }
}
