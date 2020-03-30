package packages;

import java.text.DecimalFormat;
import java.util.*;

public class Dealership { //are rol de clasa Service, dar am numit-o "Dealership" pentru a avea mai multa logica
    private Deposit deposit;
    private List<Client> clients;
    private Set<String> brands;


    public Dealership() {
        this.deposit = new Deposit();
        this.clients = new Vector<>(100);
        this.brands = new HashSet<String>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public Dealership(Deposit deposit, List<Client> clients, Set<String> brands) {
        this.deposit = deposit;
        this.clients = clients;
        this.brands = brands;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setBrands(Set<String> brands) {
        this.brands = brands;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public Set<String> getBrands() {
        return brands;
    }

    public void addVehicle(Vehicles newVehicle) {
        this.deposit.increaseDepositSize();
        this.deposit.getVehicles().add(newVehicle);
    }

    public void addClient(Client newClient) {
        this.clients.add(newClient);
    }

    public void sellVehicle(Integer type) {
        if (type == 1)
            for (Vehicles vehicle : deposit.getVehicles())
                if (vehicle instanceof Motorbike) {
                    this.deposit.getVehicles().remove(vehicle);
                    this.brands.remove(vehicle.getBrand());
                    this.deposit.decreaseDepositSize();
                    break;
                }
        if (type == 2)
            for (Vehicles vehicle : deposit.getVehicles())
                if (vehicle instanceof Car) {
                    this.deposit.getVehicles().remove(vehicle);
                    this.brands.remove(vehicle.getBrand());
                    this.deposit.decreaseDepositSize();
                    break;
                }
        if (type == 3)
            for (Vehicles vehicle : deposit.getVehicles())
                if (vehicle instanceof Truck) {
                    this.deposit.getVehicles().remove(vehicle);
                    this.brands.remove(vehicle.getBrand());
                    this.deposit.decreaseDepositSize();
                    break;
                }
        if (type == 4)
            for (Vehicles vehicle : deposit.getVehicles())
                if (vehicle instanceof Bus) {
                    this.deposit.getVehicles().remove(vehicle);
                    this.brands.remove(vehicle.getBrand());
                    this.deposit.decreaseDepositSize();
                    break;
                }
        if (type == 5)
            for (Vehicles vehicle : deposit.getVehicles())
                if (vehicle instanceof Van) {
                    this.deposit.getVehicles().remove(vehicle);
                    this.brands.remove(vehicle.getBrand());
                    this.deposit.decreaseDepositSize();
                    break;
                }
    }

    public void displayVehicles() {
        for (Vehicles vehicle : deposit.getVehicles())
            System.out.println("Brand=" + vehicle.getBrand() + ", Fabrication Year= " + vehicle.getFabricationYear() + ", Mileage= " + vehicle.getMileage() + "km, Price= " + vehicle.getPrice() + "$");
        System.out.println();
    }

    public void displayClients() {
        for (Client client : clients)
            System.out.println(client.getName() + " - " + client.getAge() + " years old");
        System.out.println();
    }

    public void vehiclesLeft() {
        System.out.println("There are " + deposit.getDepositSize() + " vehicles in the deposit");
    }

    public void displayBrandsOrdered() {

        for (Vehicles vehicle : deposit.getVehicles())
            this.brands.add(vehicle.getBrand());
        Set<String> orderedBrands = new TreeSet<String>(this.brands);
        if (!orderedBrands.isEmpty())
            System.out.println(orderedBrands);
        else
            System.out.println("You don't have any vehicle in the deposit\n");
    }

    public void displayTotalCostDeposit() {
        Double totalCost = 0d;
        DecimalFormat df = new DecimalFormat("#.##");

        for (Vehicles vehicle : deposit.getVehicles())
            totalCost += vehicle.getPrice();
        System.out.println("Total cost of the deposit is " + Double.valueOf(df.format(totalCost)) + "$");
    }

    public void displayMostExpensive() {
        if (deposit.getVehicles().isEmpty()) {
            System.out.println("Your vehicle deposit is empty!\n");
            return;
        }
        Double mostExpensive = deposit.getVehicles().get(0).getPrice();
        String vehicleClass = deposit.getVehicles().get(0).getClass().getSimpleName();
        String vehicleName = deposit.getVehicles().get(0).getBrand();

        for (Vehicles vehicle : deposit.getVehicles())
            if (vehicle.getPrice() > mostExpensive) {
                mostExpensive = vehicle.getPrice();
                vehicleClass = vehicle.getClass().getSimpleName();
                vehicleName = vehicle.getBrand();
            }
        System.out.println("The most expensive vehicle is a " + vehicleClass + "(" + vehicleName + ") " + " that costs " + mostExpensive + "$");
    }

    public void displayLeastExpensive() {
        if (deposit.getVehicles().isEmpty()) {
            System.out.println("Your vehicle deposit is empty\n");
            return;
        }
        Double leastExpensive = deposit.getVehicles().get(0).getPrice();
        String vehicleClass = deposit.getVehicles().get(0).getClass().getSimpleName();
        String vehicleName = deposit.getVehicles().get(0).getBrand();

        for (Vehicles vehicle : deposit.getVehicles())
            if (vehicle.getPrice() < leastExpensive) {
                leastExpensive = vehicle.getPrice();
                vehicleClass = vehicle.getClass().getSimpleName();
                vehicleName = vehicle.getBrand();
            }
        System.out.println("The least expensive vehicle is a " + vehicleClass + "(" + vehicleName + ") " + " that costs " + leastExpensive + "$");
    }
}
