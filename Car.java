public class Car {
    private int id;
    private String name;
    private String owner;
    private double pricePerDay;

    public Car(int id, String name, String owner, double pricePerDay) throws InvalidDataException {
        if (pricePerDay <= 0) throw new InvalidDataException("Price must be greater than zero!");
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.pricePerDay = pricePerDay;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getOwner() { return owner; }
    public double getPricePerDay() { return pricePerDay; }
}
