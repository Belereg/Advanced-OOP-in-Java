package packages;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SingletonRW readWrite = SingletonRW.getInstance();
        Dealership myDealership = new Dealership();
        readWrite.readObjectsFromFile(myDealership);
        Audit audit = Audit.getInstance();

        System.out.println("Hello there my fellow teacher. This is your newly bought dealership where you can sell your second-hand motorbikes,cars and others." +
                "\nDo whatever you want with it, but be careful, do not go bankrupt! haha!\n");

        System.out.println("What do you want to do with your dealership?\n" +
                "\t1) Add a vehicle\n" +
                "\t2) Add a client\n" +
                "\t3) Calculate the price and sell a vehicle\n" +
                "\t4) Display vehicles\n" +
                "\t5) Display clients\n" +
                "\t6) How many vehicles are in the deposit\n" +
                "\t7) Display all brands in sorted order \n" +
                "\t8) Display the total cost of the vehicles in the deposit\n" +
                "\t9) Display the most expensive vehicle\n" +
                "\t10) Display the least expensive vehicle\n" +
                "\t-1) Quit the application\n"
        );

        Scanner scan2 = new Scanner(System.in);
        Integer choice = null;
        Integer choiceNew = null;
        Scanner scan = new Scanner(System.in);
        do {
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("What type of vehicle would u like to add to the dealership?\n" +
                            "1) Motorbike\n" +
                            "2) Car\n" +
                            "3) Truck\n" +
                            "4) Bus\n" +
                            "5) Van\n"
                    );
                    choiceNew = scan2.nextInt();
                    Scanner anotherScan = new Scanner(System.in);
                    System.out.println("Initial price was: \n");
                    double price = scan.nextInt();
                    System.out.println("Brand is: ");
                    String brand = scan.next();
                    System.out.println("Fabrication year is: \n");
                    Short fabricationYear = scan.nextShort();
                    System.out.println("Mileage is: \n");
                    int mileage = scan.nextInt();

                    switch (choiceNew) {
                        case 1:
                            System.out.println("Does the motorbike have any equipment?\n" +
                                    "0) No\n" +
                                    "1) Yes");

                            short answer = scan.nextShort();
                            boolean hasEq;
                            hasEq = answer == 1;
                            Motorbike newMotorbike = new Motorbike();
                            newMotorbike.setBrand(brand);
                            newMotorbike.setFabricationYear(fabricationYear);
                            newMotorbike.setMileage(mileage);
                            newMotorbike.setHasEquipment(hasEq);
                            newMotorbike.setPrice(price);
                            Double newPriceMotorbike = newMotorbike.calculatePrice();
                            System.out.println("NEWPRICE = " + newPriceMotorbike);
                            newMotorbike.setPrice(newPriceMotorbike);
                            myDealership.addVehicle(newMotorbike);
                            break;
                        case 2:
                            System.out.println("Type of the car?\n" +
                                    "1) Sedan\n" +
                                    "2) Combi\n" +
                                    "3) Hatch\n");
                            String type = scan.next();
                            Car newCar = new Car();
                            newCar.setBrand(brand);
                            newCar.setFabricationYear(fabricationYear);
                            newCar.setMileage(mileage);
                            newCar.setType(type);
                            newCar.setPrice(price);
                            Double newPriceCar = newCar.calculatePrice();
                            System.out.println("NEWPRICE = " + newPriceCar);
                            newCar.setPrice(newPriceCar);
                            myDealership.addVehicle(newCar);
                            break;
                        case 3:
                            System.out.println("Does the truck have trailer?\n" +
                                    "0) No\n" +
                                    "1) Yes");

                            short answer2 = scan.nextShort();
                            boolean hasTr;
                            hasTr = answer2 == 1;
                            Truck newTruck = new Truck();
                            newTruck.setBrand(brand);
                            newTruck.setFabricationYear(fabricationYear);
                            newTruck.setMileage(mileage);
                            newTruck.setHaveTrailer(hasTr);
                            newTruck.setPrice(price);
                            Double newPriceTruck = newTruck.calculatePrice();
                            System.out.println("NEWPRICE = " + newPriceTruck);
                            newTruck.setPrice(newPriceTruck);
                            myDealership.addVehicle(newTruck);
                            break;
                        case 4:
                            System.out.println("Is the bus electric?\n" +
                                    "0) No\n" +
                                    "1) Yes");
                            Bus newBus = new Bus();
                            short answer4 = scan.nextShort();
                            boolean isElectric;
                            isElectric = answer4 == 1;
                            System.out.println("How many seats does the bus have?\n");
                            Integer seats = scan.nextInt();
                            newBus.setBrand(brand);
                            newBus.setFabricationYear(fabricationYear);
                            newBus.setMileage(mileage);
                            newBus.setElectric(isElectric);
                            newBus.setSeats(seats);
                            newBus.setPrice(price);
                            Double newPriceBus = newBus.calculatePrice();
                            System.out.println("NEWPRICE = " + newPriceBus);
                            newBus.setPrice(newPriceBus);
                            myDealership.addVehicle(newBus);
                            break;
                        case 5:
                            System.out.println("What is the van's maximum storage capacity?\n");
                            Van newVan = new Van();
                            Integer answer5 = scan.nextInt();
                            newVan.setMaxStorage(answer5);
                            newVan.setBrand(brand);
                            newVan.setFabricationYear(fabricationYear);
                            newVan.setMileage(mileage);
                            newVan.setPrice(price);
                            Double newPriceVan = newVan.calculatePrice();
                            System.out.println("NEWPRICE = " + newPriceVan);
                            newVan.setPrice(newPriceVan);
                            myDealership.addVehicle(newVan);
                            break;
                        default:
                            System.out.println("Wrong option");
                            break;
                    }
                    audit.writePersonsToFile("Add a vehicle");
                    System.out.println("You are back to main menu\n");
                    break;

                case 2:
                    String name;
                    Short age;
                    System.out.println("Client's name: ");
                    name = scan.next();
                    System.out.println("Client's age: ");
                    age = scan.nextShort();
                    Client newClient = new Client(age, name);
                    myDealership.addClient(newClient);
                    audit.writePersonsToFile("Add a client");
                    System.out.println("You are back to main menu\n");
                    break;
                case 3:
                    System.out.println("What does the client want to buy?\n" +
                            "1) Wants Motorbike\n" +
                            "2) Wants Car\n" +
                            "3) Wants Truck\n" +
                            "4) Wants Bus\n" +
                            "5) Wants Van\n"
                    );

                    choiceNew = scan.nextInt();
                    myDealership.sellVehicle(choiceNew);
                    audit.writePersonsToFile("Calculate the price and sell a vehicle");
                    System.out.println("You are back to main menu\n");
                    break;
                case 4:
                    System.out.println("Vehicles are: \n");
                    myDealership.displayVehicles();
                    audit.writePersonsToFile("Display vehicles");
                    System.out.println("You are back to main menu\n");
                    break;
                case 5:
                    System.out.println("Clients are: \n");
                    myDealership.displayClients();
                    audit.writePersonsToFile("Display clients");
                    System.out.println("You are back to main menu\n");
                    break;
                case 6:
                    myDealership.vehiclesLeft();
                    audit.writePersonsToFile("How many vehicles are in the deposit");
                    System.out.println("You are back to main menu\n");
                    break;
                case 7:
                    myDealership.displayBrandsOrdered();
                    audit.writePersonsToFile("Display all brands in sorted order");
                    System.out.println("You are back to main menu\n");
                    break;
                case 8:
                    myDealership.displayTotalCostDeposit();
                    audit.writePersonsToFile("Display the total cost of the vehicles in the deposit");
                    System.out.println("You are back to main menu\n");
                    break;
                case 9:
                    myDealership.displayMostExpensive();
                    audit.writePersonsToFile("Display the most expensive vehicle");
                    System.out.println("You are back to main menu\n");
                    break;
                case 10:
                    myDealership.displayLeastExpensive();
                    audit.writePersonsToFile("Display the least expensive vehicle");
                    System.out.println("Display the least expensive vehicle");
                    System.out.println("You are back to main menu\n");
                    break;
                case -1:
                    System.out.println("Application closed\n");
                    audit.writePersonsToFile("Quit the application");
                    break;
                default:
                    System.out.println("Wrong option!");
                    System.out.println("You are back to main menu\n");
                    break;
            }
        } while (!choice.equals(-1));

        readWrite.writeObjectsToFile(myDealership);
    }
}
