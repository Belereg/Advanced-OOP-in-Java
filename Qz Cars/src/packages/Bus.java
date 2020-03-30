package packages;

import java.text.DecimalFormat;

public class Bus extends Vehicles {
    private Boolean isElectric;
    private Integer seats;

    public void setElectric(Boolean electric) {
        isElectric = electric;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Bus() {
        this.isElectric = false;
        this.seats = 50;
    }

    public Bus(Boolean isElectric, Integer seats) {
        this.isElectric = isElectric;
        this.seats = seats;
    }

    public Bus(Double price, String brand, Short fabricationYear, Integer mileage, Boolean isElectric) {
        super(price, brand, fabricationYear, mileage);
        this.isElectric = isElectric;
    }

    public Boolean getElectric() {
        return isElectric;
    }

    public Integer getSeats() {
        return seats;
    }

    @Override
    public Double calculatePrice() {
        Double price = this.getPrice();
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.isElectric)
            return Double.valueOf(df.format(Math.max(price / 3, price - getMileage() / 20d - (1d / (2020 - getFabricationYear())) * price) + 1000));
        return Double.valueOf(df.format(Math.max(price / 3, price - getMileage() / 20d - (1d / (2020 - getFabricationYear())) * price)));
    }
}
