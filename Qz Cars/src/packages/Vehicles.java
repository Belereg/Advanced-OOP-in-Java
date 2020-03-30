package packages;

public abstract class Vehicles {
    private Double price;
    private String brand;
    private Short fabricationYear;
    private Integer mileage;

    public Vehicles() {
        System.out.println("Vehicles()\n");
        this.price = 0d;
        this.brand = "not defined";
        this.fabricationYear = -1;
        this.mileage = -1;
    }

    public Vehicles(Double price, String brand, Short fabricationYear, Integer mileage) {
        System.out.println("Vehicles(params)\n");
        this.price = price;
        this.brand = brand;
        this.fabricationYear = fabricationYear;
        this.mileage = mileage;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public Short getFabricationYear() {
        return fabricationYear;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setFabricationYear(Short fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public abstract Double calculatePrice();

}
