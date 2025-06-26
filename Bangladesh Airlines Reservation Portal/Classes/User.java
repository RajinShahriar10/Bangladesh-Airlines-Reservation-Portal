package Classes;

public class User {
    private String name;
    private Classes.Flight flight;

    public User(String name, Classes.Flight flight) {
        this.name = name;
        this.flight = flight;
    }

    public String getName() { return name; }
    public Classes.Flight getFlight() { return flight; }
}