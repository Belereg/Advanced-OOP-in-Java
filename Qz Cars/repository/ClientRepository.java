package com.company.repository;

import com.company.connection.DatabaseConnection;
import com.company.model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientRepository {

    private static ClientRepository instance;

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String INSERT_STATEMENT = "INSERT INTO clients (id, age, name) VALUES (?, ?, ?)";
    private static final String SELECT_STATEMENT = "SELECT * FROM clients WHERE id = ?";
    private static final String UPDATE_STATEMENT = "UPDATE clients SET name = ? WHERE id = ?";
    private static final String DELETE_STATEMENT = "DELETE FROM clients WHERE id=?";

    //private static final String FIND_NEWEST_STATEMENT = "SELECT * FROM clients ORDER BY name DESC LIMIT 1";

    private ClientRepository() {
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }

        return instance;
    }

    public Client saveClient(Client client) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, client.getId());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getName());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new client was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new client: " + e.getMessage());
            return new Client();
        }
        return client;
    }

    public Client findClient(Integer id) {
        Client client = new Client();
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (!result.next()) {
                    System.out.println("Something went wrong when trying to find client: client was not found!");
                    return client;
                }

                System.out.println("Client was found!");
                client.setId(result.getInt("id"));
                client.setName(result.getString("name"));
                client.setAge(result.getShort("age"));
            }
        } catch (SQLException  e) {
            System.out.println("Something went wrong when trying to find client: " + e.getMessage());
        }
        return client;
    }

    public Client updateClient(Client client) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_STATEMENT)) {
            statement.setString(1, client.getName());
            statement.setInt(2, client.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Client was updated successfully!");
                return client;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to update client: " + e.getMessage());
            return new Client();
        }

        System.out.println("Something went wrong when trying to update client: client was not found!");
        return new Client();
    }

    public boolean deleteClient(Integer id) {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Client was deleted successfully!");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to delete client: " + e.getMessage());
            return false;
        }

        System.out.println("Something went wrong when trying to delete client: Client was not found!");
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

