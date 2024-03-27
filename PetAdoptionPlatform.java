package com.mns;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class PetAdoptionPlatform {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/PetPals";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "AManasa9@SN"; 

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            displayPetListings(connection);
            recordDonation(connection, scanner);
            manageAdoptionEvent(connection, scanner);

        } catch (SQLException e) {
            System.out.println("Database connectivity error: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void displayPetListings(Connection connection) throws SQLException, FileNotFoundException {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Pets")) {

            System.out.println("Available Pets:");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String breed = resultSet.getString("breed");
                if (name == null || age == null) {
                    throw new NullPointerException("Pet information is missing.");
                }
                if (age < 0) {
                    throw new IllegalArgumentException("Invalid age for pet: " + name);
                }
                System.out.println("Name: " + name + ", Age: " + age + ", Breed: " + breed);
            }
        }
    }

    private static void recordDonation(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Record Cash Donation");
        System.out.print("Enter donor name: ");
        String donorName = scanner.nextLine();

        System.out.print("Enter donation amount: ");
        double donationAmount = Double.parseDouble(scanner.nextLine());

        if (donationAmount < 10.0) {
            throw new IllegalArgumentException("Donation amount must be at least $10.");
        }

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO donations (donorName, donationAmount) VALUES (?, ?)")) {
            statement.setString(1, donorName);
            statement.setDouble(2, donationAmount);
            statement.executeUpdate();
            System.out.println("Donation recorded successfully.");
        }
    }

    private static void manageAdoptionEvent(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Manage Adoption Event");
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM AdoptionEvents")) {

            System.out.println("Upcoming Adoption Events:");
            while (resultSet.next()) {
                int eventID = resultSet.getInt("eventID");
                String eventName = resultSet.getString("eventName");
                System.out.println("Event ID: " + eventID + ", Event Name: " + eventName);
            }

            System.out.print("Enter your name: ");
            String participantName = scanner.nextLine();

            System.out.print("Enter event ID to register: ");
            int eventId = Integer.parseInt(scanner.nextLine());

            try (PreparedStatement registerStatement = connection.prepareStatement("INSERT INTO participants (participantName, eventID) VALUES (?, ?)")) {
                registerStatement.setString(1, participantName);
                registerStatement.setInt(2, eventId);
                registerStatement.executeUpdate();
                System.out.println("Registration successful.");
            }
        }
    }
}
