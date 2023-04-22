public class Flight {
    enum FlightType {Arrival, Departure}

    String flightNumber;
    FlightType flightType;
    int minuteInQueue;
    int minuteOutQueue;

    public Flight(String flightNumber, FlightType flightType) {
        this.flightNumber = flightNumber;
        this.flightType = flightType;
    }

    @Override
    public String toString() {
        return flightType + ": " + flightNumber;
    }

    public void setMinuteInQueue(int minute) {
        this.minuteInQueue = minute;
    }

    public void setMinuteOutQueue(int minute) {
        this.minuteOutQueue = minute;
    }

    public int timeInQ() {
        return minuteOutQueue - minuteInQueue;
    }

}
