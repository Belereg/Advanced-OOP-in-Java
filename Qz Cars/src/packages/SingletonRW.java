package packages;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonRW {

    private static SingletonRW single_instance = null;
    public String s;
    Audit audit = Audit.getInstance();
    private SingletonRW() {
        //System.out.println("SingletonRW");
    }

    public static SingletonRW getInstance() {
        if (single_instance == null)
            single_instance = new SingletonRW();

        return single_instance;
    }

    public void readObjectsFromFile(Dealership myDealership) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ObjectsCSV.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                switch (Integer.parseInt(dataFields[0])) {
                    case 1:
                        Motorbike newMotorbike = new Motorbike();
                        newMotorbike.setBrand(dataFields[1]);
                        newMotorbike.setFabricationYear(Short.parseShort(dataFields[2]));
                        newMotorbike.setMileage(Integer.parseInt(dataFields[3]));
                        newMotorbike.setPrice(Double.parseDouble(dataFields[4]));
                        //newMotorbike.setHasEquipment(Boolean.parseBoolean(dataFields[5]));
                        audit.writePersonsToFile("Add a vehicle from CSV");
                        myDealership.addVehicle(newMotorbike);
                        break;
                    case 2:
                        Car newCar = new Car();
                        newCar.setBrand(dataFields[1]);
                        newCar.setFabricationYear(Short.parseShort(dataFields[2]));
                        newCar.setMileage(Integer.parseInt(dataFields[3]));
                        newCar.setPrice(Double.parseDouble(dataFields[4]));
                        //newCar.setType(dataFields[5]);
                        audit.writePersonsToFile("Add a vehicle from CSV");
                        myDealership.addVehicle(newCar);
                        break;
                    case 3:
                        Truck newTruck = new Truck();
                        newTruck.setBrand(dataFields[1]);
                        newTruck.setFabricationYear(Short.parseShort(dataFields[2]));
                        newTruck.setMileage(Integer.parseInt(dataFields[3]));
                        newTruck.setPrice(Double.parseDouble(dataFields[4]));
                        //newTruck.setHaveTrailer(Boolean.parseBoolean(dataFields[5]));
                        audit.writePersonsToFile("Add a vehicle from CSV");
                        myDealership.addVehicle(newTruck);
                        break;
                    case 4:
                        Bus newBus = new Bus();
                        newBus.setBrand(dataFields[1]);
                        newBus.setFabricationYear(Short.parseShort(dataFields[2]));
                        newBus.setMileage(Integer.parseInt(dataFields[3]));
                        newBus.setPrice(Double.parseDouble(dataFields[4]));
                        //newBus.setElectric(Boolean.parseBoolean(dataFields[5]));
                        //newBus.setSeats(Integer.parseInt(dataFields[6]));
                        audit.writePersonsToFile("Add a vehicle from CSV");
                        myDealership.addVehicle(newBus);
                        break;
                    case 5:
                        Van newVan = new Van();
                        newVan.setBrand(dataFields[1]);
                        newVan.setFabricationYear(Short.parseShort(dataFields[2]));
                        newVan.setMileage(Integer.parseInt(dataFields[3]));
                        newVan.setPrice(Double.parseDouble(dataFields[4]));
                        //newVan.setMaxStorage(Integer.parseInt(dataFields[5]));
                        audit.writePersonsToFile("Add a vehicle from CSV");
                        myDealership.addVehicle(newVan);
                        break;
                    default:
                        System.out.println("Wrong option");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read vehicles from the CVS file\n");
    }

    public void writeObjectsToFile(Dealership myDealership) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ObjectsCSV.csv"))) {
            for (Vehicles vehicle : myDealership.getDeposit().getVehicles()) {
                bufferedWriter.write(vehicle.getBrand() + "," + vehicle.getFabricationYear() + "," + vehicle.getMileage() + "," +vehicle.getPrice());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully wrote vehicles!");
    }
}
