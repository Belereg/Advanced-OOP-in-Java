package packages;

import java.text.DecimalFormat;

public class Motorbike extends Vehicles {
    private Boolean hasEquipment;

    public Motorbike() {
        this.hasEquipment = false;
    }

    public Motorbike(Boolean hasEquipment) {
        this.hasEquipment = hasEquipment;
    }

    public Motorbike(Double price, String brand, Short fabricationYear, Integer mileage, Boolean hasEquipment) {
        super(price, brand, fabricationYear, mileage);
        this.hasEquipment = hasEquipment;
    }

    public Boolean getHasEquipment() {
        return hasEquipment;
    }

    public void setHasEquipment(Boolean hasEquipment) {
        this.hasEquipment = hasEquipment;
    }

    @Override
    public Double calculatePrice() {
        Double price = this.getPrice();
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("MILEAGE = " + this.getMileage());
        System.out.println("YEAR = " + this.getFabricationYear());
        double x = 0;
        if (!this.hasEquipment)
            return Double.valueOf(df.format(Math.max(price / 3, price - this.getMileage() / 10d)));
        return Double.valueOf(df.format(Math.max(price / 3, price - this.getMileage() / 10d) + 300));
    }
}
