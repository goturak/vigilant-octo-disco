public class Flight {
    private String name;
    private int distance;
    private int price;

    public Flight(String name, int distance, int price){
        this.name = name;
        this.distance = distance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return name + " (" + distance + " miles)";
    }

}
