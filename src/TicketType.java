public enum TicketType {
    ECONOMY("Economy", 1, 1, 0.1),
    BUSINESS("Business", 2, 5, 0.5),
    FIRST_CLASS("First Class", 5, 30, 1.0);

    private final String name;
    private final int priceMult;
    private final int milesMult;
    private final double milesRate;

    public double getMilesRate() {
        return milesRate;
    }

    public int getPriceMult() {
        return priceMult;
    }

    public int getMilesMult() {
        return milesMult;
    }

    TicketType(String name, int priceMult, int milesMult, double milesRate){
        this.name = name;
        this.priceMult = priceMult;
        this.milesMult = milesMult;
        this.milesRate = milesRate;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
