package com.company.model;

import java.text.DecimalFormat;

public class Van extends Vehicles {
    private String VIN;
    private Integer maxStorage;

    public Van(Integer maxStorage, String VIN) {
        this.VIN = VIN;
        this.maxStorage = maxStorage;
    }

    public Van(String VIN, Double price, String brand, Short fabricationYear, Integer mileage, Integer maxStorage) {
        super(price, brand, fabricationYear, mileage);
        this.VIN = VIN;
        this.maxStorage = maxStorage;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getVIN() {
        return VIN;
    }

    public Van() {
        this.VIN = "0123456789abcdefg";
        this.maxStorage = 0;
    }

    public Integer getMaxStorage() {
        return maxStorage;
    }

    public void setMaxStorage(Integer maxStorage) {
        this.maxStorage = maxStorage;
    }

    @Override
    public Double calculatePrice() {
        Double price = this.getPrice();
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.maxStorage > 500)
            return Double.valueOf(df.format(Math.max(price / 3, price - getMileage() / 20d - (1d / (2020 - getFabricationYear())) * price) + 1000));
        return Double.valueOf(df.format(Math.max(price / 3, price - getMileage() / 20d - (1d / (2020 - getFabricationYear())) * price)));
    }
}
