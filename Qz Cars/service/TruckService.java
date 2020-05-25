package com.company.service;


import com.company.model.Truck;
import com.company.repository.TruckRepository;

public class TruckService {

    private static TruckService instance;

    private final TruckRepository truckRepository = TruckRepository.getInstance();

    private TruckService() {
    }

    public static TruckService getInstance() {
        if (instance == null) {
            instance = new TruckService();
        }

        return instance;
    }

    public Truck saveTruck(String VIN, Boolean hasTrailer, Double price, String brand, Short fabricationYear, Integer mileage) {
        Truck truck = new Truck();
        truck.setVIN(VIN);
        truck.setHaveTrailer(hasTrailer);
        truck.setPrice(price);
        truck.setBrand(brand);
        truck.setFabricationYear(fabricationYear);
        truck.setMileage(mileage);
        return truckRepository.saveTruck(truck);
    }

    public Truck findTruck(String VIN) {
        return truckRepository.findTruck(VIN);
    }

    public Truck updateTruck(Truck truck) {
        return truckRepository.updateTruck(truck);
    }

    public boolean deleteTruck(Truck truck) {
        return truckRepository.deleteTruck(truck.getVIN());
    }

//    public Truck findNewestMember() {
//        return truckRepository.findNewestMember();
//    }
}
