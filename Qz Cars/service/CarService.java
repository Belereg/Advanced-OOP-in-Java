package com.company.service;


import com.company.model.Car;
import com.company.repository.CarRepository;

public class CarService {

    private static CarService instance;

    private final CarRepository carRepository = CarRepository.getInstance();

    private CarService() {
    }

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService();
        }

        return instance;
    }

    public Car saveCar(String VIN, String carType, Double price, String brand, Short fabricationYear, Integer mileage) {
        Car car = new Car();
        car.setVIN(VIN);
        car.setType(carType);
        car.setPrice(price);
        car.setBrand(brand);
        car.setFabricationYear(fabricationYear);
        car.setMileage(mileage);
        return carRepository.saveCar(car);
    }

    public Car findCar(String VIN) {
        return carRepository.findCar(VIN);
    }

    public Car updateCar(Car car) {
        return carRepository.updateCar(car);
    }

    public boolean deleteCar(Car car) {
        return carRepository.deleteCar(car.getVIN());
    }

//    public Car findNewestMember() {
//        return carRepository.findNewestMember();
//    }
}
