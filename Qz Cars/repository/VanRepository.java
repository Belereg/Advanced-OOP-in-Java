package com.company.repository;

import com.company.connection.DatabaseConnection;
import com.company.model.Van;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class VanRepository {

    private static VanRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO vans (VIN, maxStorage, price, brand, fabricationYear, mileage) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM vans WHERE VIN = ?";
    private static final String UPDATE_STATEMENT = "UPDATE vans SET brand = ? WHERE VIN = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM vans WHERE VIN =?";

    private VanRepository() {
    }

    public static VanRepository getInstance() {
        if (instance == null) {
            instance = new VanRepository();
        }

        return instance;
    }

    public Van saveVan(Van van) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, van.getVIN());
            statement.setInt(2, van.getMaxStorage());
            statement.setDouble(3, van.getPrice());
            statement.setString(4, van.getBrand());
            statement.setShort(5, van.getFabricationYear());
            statement.setInt(6, van.getMileage());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new van was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new van: " + e.getMessage());
            return new Van();
        }
        return van;
    }

    public Van findVan(String VIN) {
        Van van = new Van();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, VIN);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find van: van was not found!");
                    return van;
                }

                System.out.println("Van was found!");
                van.setVIN(result.getString("VIN"));
                van.setMaxStorage(result.getInt("maxStorage"));
                van.setBrand(result.getString("brand"));
                van.setPrice(result.getDouble("price"));
                van.setFabricationYear(result.getShort("fabricationYear"));
                van.setMileage(result.getInt("mileage"));
            }
        } catch (SQLException  e) {
            System.out.println("Something went wrong when trying to find van: " + e.getMessage());
        }
        return van;
    }

    public Van updateVan(Van van) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, van.getBrand());
            statement.setString(2, van.getVIN());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Van was updated successfully!");
                return van;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update van: " + e.getMessage());
            return new Van();
        }

        System.out.println("Something went wrong when trying to update van: van was not found!");
        return new Van();
    }

    public boolean deleteVan(String VIN) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, VIN);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Van was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete van: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete van: Van was not found!");
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

