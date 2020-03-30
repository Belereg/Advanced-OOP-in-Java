package packages;

import java.text.DecimalFormat;

public class Car extends Vehicles {
    private String type; //sedan, combi, hatch

    public Car() {
        this.type = "not defined";
    }

    public Car(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(Double price, String brand, Short fabricationYear, Integer mileage, String type) {
        super(price, brand, fabricationYear, mileage);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public Double calculatePrice() {
        Double price = this.getPrice();
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.type.equals("1"))
            return Double.valueOf(df.format(Math.max(price / 3, price - this.getMileage() / 10d) + 500));

        if (this.type.equals("2"))
            return Double.valueOf(df.format(Math.max(price / 3, price - this.getMileage() / 10d) + 200));

        if (this.type.equals("3"))
            return Double.valueOf(df.format(Math.max(price / 3, price - this.getMileage() / 10d) + 300));

        return -1d;
    }
}
