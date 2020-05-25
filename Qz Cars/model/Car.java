package com.company.model;

import java.text.DecimalFormat;

public class Car extends Vehicles {
    private String VIN;
    private String type; //sedan(1), combi(2), hatch(3)

    public Car() {
        this.type = "not defined";
        this.VIN = "0123456789abcdefg";
    }

    public Car(String type, String VIN) {
        this.type = type;
        this.VIN = VIN;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getVIN() {
        return VIN;
    }

    public Car(String VIN, Double price, String brand, Short fabricationYear, Integer mileage, String type) {
        super(price, brand, fabricationYear, mileage);
        this.VIN = VIN;
        this.type = type;
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
