/*
 * This project is a simulation of a flight queue using LinkedLists and Priority Queues.
 * It uses a CSV file to import data and sort through the data based on defined attributes in the Flight.java file. The ReadCSV.java file organizes and reads the CSV file in teh resources folder.
 * 
 * R Stone
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;

public class FlightOp {
    LinkedList<Flight> flights = new LinkedList<>();

    public static void main(String[] args) {
        FlightOp flightOp = new FlightOp();
        String filePath = "./ch06/Lab8/resources/Flights.csv";
        flightOp.doSimulation(filePath);
    }

    private void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }

    private void removeCancelledFlights() {
        Stack<Flight> removeStack = new Stack<>();

        for (Flight flight : flights) {
            if (flight.status == Flight.OpStatus.Crash || flight.status == Flight.OpStatus.DrunkPilot || flight.status == Flight.OpStatus.Maintenance || flight.status == Flight.OpStatus.PassengerDisturbance || flight.status == Flight.OpStatus.NavError || flight.status == Flight.OpStatus.NoPlane) {
                removeStack.push(flight);
            }
        }
        while (!removeStack.isEmpty()) {
            flights.remove(removeStack.pop());
        }
    }

    private void changeStatuses() {
        for (Flight flight : flights) {
            Flight.OpStatus status = (Flight.OpStatus) Flight.OpStatus.getRandomStatus();
            if (flight.flightType == Flight.FlightType.Arrival) {
                if (status == Flight.OpStatus.Crash || status == Flight.OpStatus.NavError || status == Flight.OpStatus.Scheduled || status == Flight.OpStatus.Queued) {
                    flight.setStatus(status);
                }

            } else if (flight.flightType == Flight.FlightType.Departure && status == Flight.OpStatus.NavError) {
                continue;
            } else {
                flight.setStatus(status);
            }
        }
    }

    private void moveQueuedFlights() {
        Stack<Flight> moveStack = new Stack<>();
        for (Flight flight : flights) {
            if (flight.status == Flight.OpStatus.Queued) {
                moveStack.push(flight);
            }
        }
        while (!moveStack.isEmpty()) {
            Flight flight = (Flight) moveStack.peek();
            flights.remove(moveStack.pop());

            flights.addLast(flight);
        }
    }

    private void jumpingTheQueue() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm");
        try {
            Date date1 = sdf.parse("10/15/20 07:30");
            Date date2 = sdf.parse("10/15/20 07:30");
            Date date3 = sdf.parse("10/15/20 07:30");

            Flight vipFlight1 = new Flight("Vip001", "AF-01", "CDG", date1, Flight.FlightType.Departure);
            Flight vipFlight2 = new Flight("Vip002", "AF-01", "CDG", date2, Flight.FlightType.Departure);
            Flight vipFlight3 = new Flight("Vip003", "AF-01", "CDG", date3, Flight.FlightType.Arrival);

            flights.addFirst(vipFlight1);
            flights.addFirst(vipFlight2);
            flights.addFirst(vipFlight3);

        } catch (ParseException e) {
            System.out.println("Date parse exception");
        }
    }

    public void doSimulation(String filePath) {
        flights = initFlightList(filePath);
        changeStatuses();
        System.out.println("\nChanged statuses");
        printFlights();
        System.out.println("\nRemoved cancelled flights");
        removeCancelledFlights();
        printFlights();
        jumpingTheQueue();
        System.out.println("\nCronies jumped queue");
        printFlights();
        moveQueuedFlights();
        System.out.println("\nMoved queued flights");
        printFlights();
    }

    public LinkedList<Flight> initFlightList(String filePath) {
        ReadCSV csvReader = new ReadCSV();
        return csvReader.getFlightListFromCSV(filePath);
    }
}
