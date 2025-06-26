package FileIO;

import Classes.Flight;
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveBooking(String name, String passport, String flightClass, ArrayList<Flight> flights) {
        if (name == null || flights == null || flights.isEmpty()) {
            System.err.println("Invalid booking data. Booking not saved.");
            return;
        }

        File file = new File("Data/booking.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Passport ID: " + passport);
            writer.newLine();
            writer.write("Class: " + flightClass);
            writer.newLine();

            for (Flight f : flights) {
                writer.write("Flight: " + f.getFrom() + " → " + f.getTo() +
                        " | Time: " + f.getTime() +
                        " | Fare: " + (int) f.getFare() + " BDT");
                writer.newLine();
            }

            writer.write("----------------------------------");
            writer.newLine();

        } catch (IOException e) {
            System.err.println("Error saving booking: " + e.getMessage());
        }
    }
}
