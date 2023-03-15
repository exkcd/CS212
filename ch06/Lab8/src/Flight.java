import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Flight {
    String flightNumber;
    String aircraftNumber;
    String origin;
    Date schedule;
    FlightType flightType;
    OpStatus status = OpStatus.Scheduled;

    enum FlightType {Arrival, Departure}

    enum OpStatus {
        Scheduled, Crash, PassengerDisturbance, DrunkPilot, Maintenance, Queued, NavError, NoPlane;

        public static Object getRandomStatus() {
            Random random = new Random();
            return Flight.OpStatus.values()[random.nextInt(OpStatus.values().length)];
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return "FlightType: " + flightType + " |Flight #: " + flightNumber + " |Aircraft #: " + aircraftNumber + " |Schedule: " + formatter.format(schedule) + " |Status: " + status;
    }

    public Flight() {
    }

    public Flight(String flightNumber, String aircraftNumber, String origin, Date schedule, FlightType flightType) {
        this.flightNumber = flightNumber;
        this.aircraftNumber = aircraftNumber;
        this.origin = origin;
        this.schedule = schedule;
        this.flightType = flightType;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAircraftNumber(String aircraftNumber) {
        this.aircraftNumber = aircraftNumber;
    }

    public void setSchedule(String scheduleString) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy HH:mm");
        Date schedule = null;
        try {
            schedule = formatter.parse(scheduleString);
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + scheduleString);
        }
        this.schedule = schedule;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setFlightType(String type) {
        switch(type) {
            case "Arrival" -> flightType = FlightType.Arrival;
            case "Departure" -> flightType = FlightType.Departure;
        }
    }

    public void setStatus(OpStatus status) {
        this.status = status;
    }
}