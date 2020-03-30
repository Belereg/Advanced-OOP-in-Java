package packages;

import java.util.List;
import java.util.Vector;

public class Deposit {
    private List<Vehicles> vehicles;
    private Integer depositSize;

    public Deposit() {
        this.depositSize = 0;
        this.vehicles = new Vector<>(100);
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public void setDepositSize(Integer depositSize) {
        this.depositSize = depositSize;
    }

    public Deposit(List<Vehicles> vehicles, Integer depositSize) {
        this.vehicles = vehicles;
        this.depositSize = depositSize;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void increaseDepositSize() {
        this.depositSize++;
    }

    public void decreaseDepositSize() {
        this.depositSize--;
    }

    public Integer getDepositSize() {
        return depositSize;
    }

    public void modifyDepositSize() {
        this.depositSize--;
    }
}
