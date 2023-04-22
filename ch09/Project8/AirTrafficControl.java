/*
 * In this assignment, you will create a program that uses queues to simulate a busy airport with only one runway,
 * that shares aircraft take-off, and landings. Your program will function as an automated air-traffic controller
 * . Hopefully, you will do at least as well as some human-run airports that we have all experienced either
 * pleasantly, or not so much.
 *
 *
 * R Stone
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AirTrafficControl {

    static final double MIN_FLIGHT_SPACING = 20;
    int timeInterval = 0; // Sets the clock for 24 hours
    int divertedArrivals = 0; // Counts the number of arrival flights diverted
    int numberOfArrivals = 0;
    int numberOfDepartures = 0;
    int delayedDepartures = 0;
    int timeCounter = 0; // Counts the number of arrivals and departures during a specific time
    int flightCounter = 0; // Shows the flight number
    int flightSpacing = 0; // Handles departure flight times and when they can take off

    ArrayDeque<Flight> arrivalQ = new ArrayDeque<>();
    ArrayDeque<Flight> departureQ = new ArrayDeque<>();

    ArrayList<Integer> arrivalMinutes = new ArrayList<>();
    ArrayList<Integer> departureMinutes = new ArrayList<>();
    ArrayList<Flight> arrivalStats = new ArrayList<>();
    ArrayList<Flight> departureStats = new ArrayList<>();


    public static void main(String[] args) {
        double meanArrivalFreq = 0.0;
        double meanDepartureFreq = 0.0;

        AirTrafficControl sim = new AirTrafficControl();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter mean departure frequency (0.0 < df < 1.0): ");
        if (in.hasNextDouble()) {
            meanDepartureFreq = in.nextDouble();
        }

        System.out.print("Enter mean arrival frequency (0.0 < af < 1.0): ");
        if (in.hasNextDouble()) {
            meanArrivalFreq = in.nextDouble();
        }

        for (int i = 0; i < 720; i++) {
            sim.processArrival(meanArrivalFreq);
            sim.processDeparture(meanDepartureFreq);
        }
        sim.printStats();
        in.close();
    }

    public int getPoissonRandom(double mean) {
        Random r = new Random(System.nanoTime());
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }

    public void processArrival(double meanArrivalFreq) {
        int count;
        timeCounter++;
        timeInterval++;
        if ((count = getPoissonRandom(meanArrivalFreq)) > 0) {
            addToArrivalQ(count);
        }
        if (timeCounter >= 10) {
            if (arrivalQ.size() > 0) {
                removeFromArrivalQ();
                timeCounter = 0;
            }
        }
    }

    public void processDeparture(double meanDepartureFreq) {
        int count;
        flightSpacing++;
        timeInterval++;

        if ((count = getPoissonRandom(meanDepartureFreq)) > 0) {
            addToDepartureQ(count);
        }
        if (flightSpacing >= MIN_FLIGHT_SPACING) {
            if (departureQ.size() > 0 && arrivalQ.size() == 0) {
                removeFromDepartureQ();
                flightSpacing = 0;
            }
        }
    }

    public void addToArrivalQ(int count) {
        for (int i = 0; i < count; i++) {
            Flight arrivalFlight = new Flight("AA" + flightCounter++, Flight.FlightType.Arrival);

            if (arrivalQ.size() <= 5) {
                arrivalFlight.setMinuteInQueue(timeInterval);
                arrivalQ.add(arrivalFlight);
            } else {
                divertedArrivals++;
                System.out.println("Arrival queue full. Flight " + arrivalFlight + " rerouted at: " + timeInterval / 60
                        + ":" + String.format("%02d", timeInterval % 60) + " hours");
            }
        }
    }

    public void removeFromArrivalQ() {
        if (arrivalQ.size() > 0) {
            Flight arrivalFlight = arrivalQ.removeFirst();
            arrivalFlight.setMinuteOutQueue(timeInterval);
            arrivalStats.add(arrivalFlight);
            System.out.println("Flight " + arrivalFlight + " arrived at: " + timeInterval / 60 + ":" +
                    String.format("%02d", timeInterval % 60) + " hours");
            arrivalMinutes.add(arrivalFlight.timeInQ());
            numberOfArrivals++;
        }
    }

    public void addToDepartureQ(int count) {
        for (int i = 0; i < count; i++) {
            Flight departureFlight = new Flight("UA" + flightCounter++, Flight.FlightType.Departure);

            if (departureQ.size() <= 5) {
                departureFlight.setMinuteInQueue(timeInterval);
                departureQ.add(departureFlight);
            } else {
                delayedDepartures++;
                System.out.println("Departure queue full. Flight " + departureFlight + " delayed at: " + timeInterval / 60 + ":"
                        + String.format("%02d", timeInterval % 60) + " hours");
            }
        }
    }

    public void removeFromDepartureQ() {
        if (departureQ.size() > 0) {
            Flight departureFlight = departureQ.removeFirst();
            departureFlight.setMinuteOutQueue(timeInterval);
            departureStats.add(departureFlight);
            System.out.println("Flight " + departureFlight + " arrived at: " + timeInterval / 60 + ":" +
                    String.format("%02d", timeInterval % 60) + " hours");
            departureMinutes.add(departureFlight.timeInQ());
            numberOfDepartures++;
        }
    }

    public void printStats() {

        System.out.println("*****************");
        System.out.println("Automated Summary Stats");
        System.out.println("*****************");

        System.out.println("Time period simulated: " + (double) timeInterval / 60 + " hours");

        System.out.println("Number of arrivals: " + numberOfArrivals);
        System.out.println("Number of departures: " + numberOfDepartures);

        int totalFlights = numberOfArrivals + numberOfDepartures + delayedDepartures + divertedArrivals;

        System.out.println("Total number of flights: " + totalFlights);

        System.out.println("Average arrivals per hour: " + String.format("%.2f", (double) numberOfArrivals / 24));
        System.out.println("Average departures per hour: " + String.format("%.2f", (double) numberOfDepartures / 24));


        System.out.println("Departures remaining in queue: " + departureQ.size());
        System.out.println("Arrivals remaining in queue: " + arrivalQ.size());

        System.out.println("Number of diverted arrivals: " + divertedArrivals);
        System.out.println("Number of delayed departures: " + delayedDepartures);

        double departureSum = 0;
        for (int minutes : departureMinutes) {
            departureSum += minutes;
        }
        System.out.println("Average departure time in queue: " + String.format("%.2f",
                (departureSum / departureMinutes.size())) + " " +
                "minutes");

        double arrivalSum = 0;
        for (int minutes : arrivalMinutes) {
            arrivalSum += minutes;
        }
        System.out.println("Average arrival time in queue: " + String.format("%.2f",
                (arrivalSum / arrivalMinutes.size())) + " minutes");

        double totalMinutes = departureSum + arrivalSum;
        System.out.println("Percent time idle: " + String.format("%.2f", ((1440 / totalMinutes) * 100)) + "%");
    }
}
