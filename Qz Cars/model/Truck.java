package com.company.model;

import java.text.DecimalFormat;

public class Truck extends Vehicles {
    private String VIN;
    private Boolean haveTrailer;

    public Truck() {
        this.VIN = "0123456789abcdefg";
        this.haveTrailer = false;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getVIN() {
        return VIN;
    }

    public void setHaveTrailer(Boolean haveTrailer) {
        this.haveTrailer = haveTrailer;
    }

    public Boolean getHaveTrailer() {
        return haveTrailer;
    }

    public Truck(Boolean haveTrailer, String VIN) {
        this.VIN = VIN;
        this.haveTrailer = haveTrailer;
    }

    public Truck(Double price, String brand, Short fabricationYear, Integer mileage, Boolean haveTrailer, String VIN) {
        super(price, brand, fabricationYear, mileage);
        this.VIN = VIN;
        this.haveTrailer = haveTrailer;
    }

    @Override
    public Double calculatePrice() {
        Double price = this.getPrice();
        DecimalFormat df = new DecimalFormat("#.##");
        if (this.haveTrailer)
            return Double.valueOf(df.format(Math.max(price / 3, price - getMileage() / 30d - (1d / (2020 - getFabricationYear())) * price) + 0.2 * price));
        return Double.valueOf(df.format(Math.max(price / 3, price - getMileage() / 30d - (1d / (2020 - getFabricationYear())) * price)));
    }
}
