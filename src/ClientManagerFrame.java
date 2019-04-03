import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ClientManagerFrame extends Frame {
    private LinkedList<Client> clients;
    private LinkedList<Flight> flights;
    private Client currentClient;
    private Flight currentFlight;
    private Ticket currentTicket;
    private JPanel panel;
    private JComboBox cbTicket;

    public ClientManagerFrame(LinkedList<Client> clients, LinkedList<Flight> flights){
        super();
        this.clients = clients;
        this.flights = flights;
        this.currentClient = clients.get(0);
        this.currentFlight = flights.get(0);
        this.panel = new JPanel();
        JPanel firstElements = new JPanel();
        JPanel secondElements = new JPanel();
        JPanel thirdElements = new JPanel();
        JPanel fourthElements = new JPanel();
        firstElements.setLayout(new FlowLayout());
        secondElements.setLayout(new FlowLayout());
        thirdElements.setLayout(new FlowLayout());
        fourthElements.setLayout(new FlowLayout());

        Client[] c = clients.toArray(new Client[clients.size()]);
        Flight[] f = flights.toArray(new Flight[flights.size()]);

        /**
         * CLIENT TEXT
         */
        JLabel clientText = new JLabel("Client");
        clientText.setBounds(10,10, 50,40);
        firstElements.add(clientText);

        /**
         * COMBO BOX CLIENT
         */
        JComboBox cbClient = new JComboBox(c);
        ActionListener cbClientListener = e -> {
            JComboBox cb = (JComboBox)e.getSource();
            currentClient = (Client)cb.getSelectedItem();
        };
        cbClient.addActionListener(cbClientListener);
        cbClient.setBounds(60,10,200,40);
        firstElements.add(cbClient);

        /**
         * DETAILS BUTTON
         */
        JButton details = new JButton("Details");
        ActionListener detailsListener = e -> {
            new ClientDetailsFrame(currentClient);
        };
        details.addActionListener(detailsListener);
        details.setBounds(270,10, 100, 40);
        firstElements.add(details);

        /**
         * CREDIT TEXT
         */
        JLabel creditsText = new JLabel("Credits");
        creditsText.setBounds(10,60,100,40);
        secondElements.add(creditsText);

        /**
         * CREDIT FIELD
         */
        JTextField creditsField = new JTextField(10);
        creditsField.setBounds(70, 60, 100, 40);
        secondElements.add(creditsField);

        /**
         * ADD BUTTON
         */
        JButton add = new JButton("Add");
        ActionListener addListener = e -> {
            try{
                int amount = Integer.parseInt(creditsField.getText());
                currentClient.addMoney(amount);
                creditsField.setText("");
            } catch(NumberFormatException excep){
                creditsField.setText("");
            }
        };
        add.addActionListener(addListener);
        add.setBounds(180,60, 70, 40);
        secondElements.add(add);

        /**
         * FLIGHT LABEL
         */
        JLabel flightText = new JLabel("Flight");
        flightText.setBounds(10,110,100,40);
        thirdElements.add(flightText);

        /**
         * FLIGHT COMBO BOX
         */
        JComboBox cbFlight = new JComboBox(f);
        ActionListener cbFlightListener = e -> {
            JComboBox cb = (JComboBox)e.getSource();
            currentFlight = (Flight)cb.getSelectedItem();
            updateCurrentTickets();
        };
        cbFlight.addActionListener(cbFlightListener);
        cbFlight.setBounds(60,110,200,40);
        thirdElements.add(cbFlight);

        /**
         * TICKET COMBO BOX
         */
        cbTicket = new JComboBox();
        updateCurrentTickets();
        ActionListener cbTicketListener = e -> {
            JComboBox cb = (JComboBox)e.getSource();
            currentTicket = (Ticket)cb.getSelectedItem();
        };
        cbTicket.addActionListener(cbTicketListener);
        cbTicket.setBounds(270,110,200,40);
        thirdElements.add(cbTicket);

        /**
         * BOOK MONEY BUTTON
         */
        JButton bookMoney = new JButton("Book (cash)");
        ActionListener bookMoneyListener = e -> {
            currentClient.buyTicketMoney(currentTicket);
        };
        bookMoney.addActionListener(bookMoneyListener);
        bookMoney.setBounds(480,110, 150, 40);
        thirdElements.add(bookMoney);

        /**
         * BOOK MILES BUTTON
         */
        JButton bookMiles = new JButton("Book (miles)");
        ActionListener bookMilesListener = e -> {
            currentClient.buyTicketMiles(currentTicket);
        };
        bookMiles.addActionListener(bookMilesListener);
        bookMiles.setBounds(640,110, 150, 40);
        thirdElements.add(bookMiles);

        /**
         * STATUS FRAME BUTTON
         */
        JButton statuses = new JButton("Statuses");
        ActionListener statusesListener = e -> {
            new StatusFrame(this.clients);

        };
        statuses.addActionListener(statusesListener);
        statuses.setBounds(130,160, 100, 40);
        fourthElements.add(statuses);

        /**
         * QUIT BUTTON
         */
        JButton quit = new JButton("Quit");
        ActionListener quitListener = e -> {
            getFrame().dispose();
            System.exit(0);
        };
        quit.addActionListener(quitListener);
        quit.setBounds(240,160, 100, 40);
        fourthElements.add(quit);

        panel.add(firstElements);
        panel.add(secondElements);
        panel.add(thirdElements);
        panel.add(fourthElements);
        getFrame().setContentPane(panel);
        getFrame().setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        /**
         * FRAME SETTINGS
         */
        getFrame().setTitle("Clients manager");
        getFrame().setSize(800,250);
        getFrame().setVisible(true);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void updateCurrentTickets(){
        cbTicket.removeAllItems();
        currentTicket = new Ticket(currentFlight, TicketType.ECONOMY);
        cbTicket.addItem(currentTicket);
        cbTicket.addItem(new Ticket(currentFlight, TicketType.BUSINESS));
        cbTicket.addItem(new Ticket(currentFlight, TicketType.FIRST_CLASS));
    }
}
