package com.company.service;


import com.company.model.Van;
import com.company.repository.VanRepository;

public class VanService {

    private static VanService instance;

    private final VanRepository vanRepository = VanRepository.getInstance();

    private VanService() {
    }

    public static VanService getInstance() {
        if (instance == null) {
            instance = new VanService();
        }

        return instance;
    }

    public Van saveVan(String VIN, Integer maxStorage, Double price, String brand, Short fabricationYear, Integer mileage) {
        Van van = new Van();
        van.setVIN(VIN);
        van.setMaxStorage(maxStorage);
        van.setPrice(price);
        van.setBrand(brand);
        van.setFabricationYear(fabricationYear);
        van.setMileage(mileage);
        return vanRepository.saveVan(van);
    }

    public Van findVan(String VIN) {
        return vanRepository.findVan(VIN);
    }

    public Van updateVan(Van van) {
        return vanRepository.updateVan(van);
    }

    public boolean deleteVan(Van van) {
        return vanRepository.deleteVan(van.getVIN());
    }

//    public Van findNewestMember() {
//        return vanRepository.findNewestMember();
//    }
}
