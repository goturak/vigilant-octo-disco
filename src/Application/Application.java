package Application;

import Airline.Client;
import Airline.Flight;
import Frames.ClientManagerFrame;

import java.util.LinkedList;

/**
 * @author Guillaume Vetter & Luca Reis de Carvalho
 * Main class that just create clients and flights and add them to a Airline.Client manager frame.
 */
public class Application {

    public static void main(String[] args){
        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Flight> flights = new LinkedList<>();
        clients.add(new Client("Jean", "Pierre"));
        clients.add(new Client("Bricot", "Judah"));
        clients.add(new Client("Nanasse", "Judah"));
        clients.add(new Client("Bombeur", "Jean"));
        flights.add(new Flight("AB2", 1200, 300));
        flights.add(new Flight("LX1", 1000, 400));
        flights.add(new Flight("XX5", 15000, 2));
        new ClientManagerFrame(clients, flights);

    }
}
