package packages;

import java.text.DecimalFormat;

public class Van extends Vehicles {
    private Integer maxStorage;

    public Van(Integer maxStorage) {
        this.maxStorage = maxStorage;
    }

    public Van(Double price, String brand, Short fabricationYear, Integer mileage, Integer maxStorage) {
        super(price, brand, fabricationYear, mileage);
        this.maxStorage = maxStorage;
    }

    public Van() {
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
