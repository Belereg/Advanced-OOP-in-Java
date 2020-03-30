package packages;

import java.text.DecimalFormat;

public class Truck extends Vehicles {
    private Boolean haveTrailer;

    public Truck() {
        this.haveTrailer = false;
    }

    public void setHaveTrailer(Boolean haveTrailer) {
        this.haveTrailer = haveTrailer;
    }

    public Truck(Boolean haveTrailer) {
        this.haveTrailer = haveTrailer;
    }

    public Truck(Double price, String brand, Short fabricationYear, Integer mileage, Boolean haveTrailer) {
        super(price, brand, fabricationYear, mileage);
        this.haveTrailer = haveTrailer;
    }

    public Boolean getHaveTrailer() {
        return haveTrailer;
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
