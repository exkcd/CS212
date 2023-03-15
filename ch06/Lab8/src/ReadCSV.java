import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadCSV {
    public LinkedList<Flight> getFlightListFromCSV(String filePath) {
        LinkedList<Flight> fltList = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line = null;
            Scanner scanner = null;
            int index = 0;

            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                Flight flight = new Flight();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                if (!firstLine) while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0) {
                        flight.setFlightNumber(data);
                    } else if (index == 1) {
                        flight.setAircraftNumber(data);
                    } else if (index == 2) {
                        flight.setOrigin(data);
                    } else if (index == 3) {
                        flight.setFlightType(data);
                    } else if (index == 4) {
                        flight.setSchedule(data);
                    } else if (index == 5) {
                        flight.setStatus(Flight.OpStatus.Scheduled);
                    }
                    else {
                        System.out.println("invalid data::" + data);
                    }
                    index++;
                }
                index = 0;
                if (!firstLine) fltList.add(flight);
                firstLine = false;
            }
            // close reader
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return fltList;
    }
}
