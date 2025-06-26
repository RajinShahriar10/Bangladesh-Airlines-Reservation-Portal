package Classes;

public class Flight {
    private String from;
    private String to;
    private String time;
    private double fare;
    private String passengerName;
    private String passportID;
    private String classType;

    public Flight(String from, String to, String time, double fare){
        this.from = from;
        this.to = to;
        this.time = time;
        this.fare = fare;
    }

    public String getFrom(){ return from;}
    public String getTo(){ return to;}
    public String getTime(){ return time;}
    public double getFare(){ return fare;}
	
    public String getPassengerName(){return passengerName;}	
	public void setPassengerName(String passengerName){
        this.passengerName = passengerName;
    }
    public String getPassportID() {
        return passportID;
    }
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getClassType() {
        return classType;
    }
    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return from + " to " + to + " at " + time + " - BDT " + fare;
    }
}