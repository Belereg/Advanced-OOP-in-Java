package com.company.repository;

import com.company.connection.DatabaseConnection;
import com.company.model.Car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CarRepository {

    private static CarRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO cars (VIN, carType, price, brand, fabricationYear, mileage) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM cars WHERE VIN = ?";
    private static final String UPDATE_STATEMENT = "UPDATE cars SET brand = ? WHERE VIN = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM cars WHERE VIN =?";

    private CarRepository() {
    }

    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }

        return instance;
    }

    public Car saveCar(Car car) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, car.getVIN());
            statement.setString(2, car.getType());
            statement.setDouble(3, car.getPrice());
            statement.setString(4, car.getBrand());
            statement.setShort(5, car.getFabricationYear());
            statement.setInt(6, car.getMileage());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new car was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new car: " + e.getMessage());
            return new Car();
        }
        return car;
    }

    public Car findCar(String VIN) {
        Car car = new Car();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, VIN);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find car: car was not found!");
                    return car;
                }

                System.out.println("Car was found!");
                car.setVIN(result.getString("VIN"));
                car.setType(result.getString("carType"));
                car.setBrand(result.getString("brand"));
                car.setPrice(result.getDouble("price"));
                car.setFabricationYear(result.getShort("fabricationYear"));
                car.setMileage(result.getInt("mileage"));
            }
        } catch (SQLException  e) {
            System.out.println("Something went wrong when trying to find car: " + e.getMessage());
        }
        return car;
    }

    public Car updateCar(Car car) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getVIN());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Car was updated successfully!");
                return car;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update car: " + e.getMessage());
            return new Car();
        }

        System.out.println("Something went wrong when trying to update car: car was not found!");
        return new Car();
    }

    public boolean deleteCar(String VIN) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setString(1, VIN);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Car was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete car: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete car: Car was not found!");
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

