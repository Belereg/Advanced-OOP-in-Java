package com.company.repository;

import com.company.connection.DatabaseConnection;
import com.company.model.Truck;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class TruckRepository {

    private static TruckRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO trucks (VIN, haveTrailer, price, brand, fabricationYear, mileage) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM trucks WHERE VIN = ?";
    private static final String UPDATE_STATEMENT = "UPDATE trucks SET brand = ? WHERE VIN = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM trucks WHERE VIN =?";

    private TruckRepository() {
    }

    public static TruckRepository getInstance() {
        if (instance == null) {
            instance = new TruckRepository();
        }

        return instance;
    }

    public Truck saveTruck(Truck truck) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, truck.getVIN());
            statement.setBoolean(2, truck.getHaveTrailer());
            statement.setDouble(3, truck.getPrice());
            statement.setString(4, truck.getBrand());
            statement.setShort(5, truck.getFabricationYear());
            statement.setInt(6, truck.getMileage());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new truck was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new truck: " + e.getMessage());
            return new Truck();
        }
        return truck;
    }

    public Truck findTruck(String VIN) {
        Truck truck = new Truck();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, VIN);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find truck: truck was not found!");
                    return truck;
                }

                System.out.println("Truck was found!");
                truck.setVIN(result.getString("VIN"));
                truck.setHaveTrailer(result.getBoolean("haveTrailer"));
                truck.setPrice(result.getDouble("price"));
                truck.setFabricationYear(result.getShort("fabricationYear"));
                truck.setMileage(result.getInt("mileage"));
            }
        } catch (SQLException  e) {
            System.out.println("Something went wrong when trying to find truck: " + e.getMessage());
        }
        return truck;
    }

    public Truck updateTruck(Truck truck) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, truck.getBrand());
            statement.setString(2, truck.getVIN());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Truck was updated successfully!");
                return truck;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update truck: " + e.getMessage());
            return new Truck();
        }

        System.out.println("Something went wrong when trying to update truck: truck was not found!");
        return new Truck();
    }

    public boolean deleteTruck(String VIN) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, VIN);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Truck was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete truck: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete truck: Truck was not found!");
        return false;
    }

//    public User findNewestMember() {
//        User user = new User();
//        try (Statement statement = DatabaseConnection.getInstance().getConnection().createStatement()) {
//
//            try (ResultSet result = statement.executeQuery(FIND_NEWEST_STATEMENT)) {
//                if (!result.next()) {
//                    System.out.println("Database might be empty!");
//                    return user;
//                }
//
//                System.out.println("Newest member was found!");
//                user.setEmail(result.getString("email"));
//                user.setName(result.getString("name"));
//                user.setRegisteredDateTime(DATE_FORMAT.parse(result.getString("registeredDateTime")));
//            }
//        } catch (SQLException | ParseException e) {
//            System.out.println("Something went wrong when trying to find the most newly registered user: " + e.getMessage());
//        }
//        return user;
//    }
}

