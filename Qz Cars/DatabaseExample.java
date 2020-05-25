import com.company.model.Client;
import com.company.model.Car;
import com.company.model.Truck;
import com.company.service.ClientService;
import com.company.service.CarService;
import com.company.service.TruckService;
import com.company.model.Van;
import com.company.service.VanService;

import java.util.Date;

public class DatabaseExample {

    private static final ClientService clientService = ClientService.getInstance();
    private static final CarService carService = CarService.getInstance();
    private static final TruckService truckService = TruckService.getInstance();
    private static final VanService vanService = VanService.getInstance();

    public static void main(String[] args) throws InterruptedException {
        Client clientToSave1 = clientService.saveClient(173, (short) 21, "vancea roxanutza");
        Client clientToSave2 = clientService.saveClient(174, (short) 31, "avadanei antonia");
        Client clientToSave3 = clientService.saveClient(175, (short) 41, "tzanca uraganu");
        Client clientToSave4 = clientService.saveClient(176, (short) 51, "cacat pisat");
        Client clientToSave5 = clientService.saveClient(177, (short) 61, "puie monta");
        Client clientToSave6 = clientService.saveClient(178, (short) 71, "romanii au talent");
        Client clientToSave7 = clientService.saveClient(179, (short) 81, "alt+f4");
        Client clientToSave8 = clientService.saveClient(180, (short) 91, "sase sase");

        Car carToSave1 = carService.saveCar("12345678912345678", "combi", (double)12000, "bmw", (short)2008, 100000);
        Car carToSave2 = carService.saveCar("2HGES165X4H529256", "sedan", (double)13000, "volvo", (short)2011, 170000);
        Car carToSave3 = carService.saveCar("1FAFP42X24F120947", "sedan", (double)24000, "audi", (short)1968, 150000);
        Car carToSave4 = carService.saveCar("2HGES26822H550356", "hach", (double)122000, "bentley", (short)2018, 1020);
        Car carToSave5 = carService.saveCar("5555555557N155533", "hach", (double)122000, "bentley", (short)2018, 1020);


        Truck truckToSave1 = truckService.saveTruck("11111111111111111", true, (double)12345, "MANN", (short)2000, 102300);
        Truck truckToSave2 = truckService.saveTruck("JM1FE173650148968", false, (double)53421, "VOLVO", (short)1992, 1117000);
        Truck truckToSave3 = truckService.saveTruck("2FMDK3GC2DBB57297", false, (double)23232, "MERCEDES", (short)1983, 6150000);
        Truck truckToSave4 = truckService.saveTruck("1C3CCBCB1CN158744", true, (double)2222222, "filipine", (short)2001, 61020);
        Truck truckToSave5 = truckService.saveTruck("ABCDEFGHIJKLMNOPQ", true, (double)15669969, "rozmarin", (short)2013, 16020);

        Van vanToSave1 = vanService.saveVan("22222222222222222", 1111, (double) 2312, "vanbrand1", (short)2000, 102300);
        Van vanToSave2 = vanService.saveVan("33333333333333333", 2222, (double)53421, "vanbrand2", (short)1992, 1117000);
        Van vanToSave3 = vanService.saveVan("44444444444444444", 3333, (double)23232, "vanbrand3", (short)1983, 6150000);
        Van vanToSave4 = vanService.saveVan("55555555555555555", 4444, (double)2222222, "vanbrand4", (short)2001, 61020);
        Van vanToSave5 = vanService.saveVan("66666666666666666", 5555, (double)15669969, "vanbrand5", (short)2013, 16020);

        System.out.println(clientToSave1.getName());
        System.out.println(clientToSave2.getName());
        System.out.println(clientToSave3.getName());
        System.out.println(clientToSave4.getName());
        System.out.println(clientToSave5.getName());
        System.out.println(clientToSave6.getName());
        System.out.println(clientToSave7.getName());
        System.out.println(clientToSave8.getName());

        System.out.println(carToSave1.getBrand());
        System.out.println(carToSave2.getBrand());
        System.out.println(carToSave3.getBrand());
        System.out.println(carToSave4.getBrand());

        System.out.println(truckToSave1.getBrand());
        System.out.println(truckToSave2.getBrand());
        System.out.println(truckToSave3.getBrand());
        System.out.println(truckToSave4.getBrand());
        System.out.println(truckToSave5.getBrand());

        System.out.println(vanToSave1.getBrand());
        System.out.println(vanToSave2.getBrand());
        System.out.println(vanToSave3.getBrand());
        System.out.println(vanToSave4.getBrand());
        System.out.println(vanToSave5.getBrand());

        //CLIENTS
        Client clientToFind = clientService.findClient(173);
        System.out.println(clientToFind.getName());

        Client clientToUpdate = new Client(173, (short) 21, "vancea cacacioasa");
        clientToUpdate = clientService.updateClient(clientToUpdate);
        System.out.println(clientToUpdate.getName());

        Client clientToDelete = new Client(177, (short) 61, "puie monta");
        boolean resultClient = clientService.deleteClient(clientToDelete);
        System.out.println(resultClient);

        //CARS
        Car carToFind = carService.findCar("12345678912345678");
        System.out.println(carToFind.getBrand());

        Car carToUpdate = new Car("5555555557N155533", (double) 696969,"bentleyDalaTare",(short)2020,666,"sedan");
        carToUpdate = carService.updateCar(carToUpdate);
        System.out.println(carToUpdate.getBrand());

        Car carToDelete = new Car("2HGES165X4H529256", (double)122000, "bentleyDalaPuternic", (short)2020,1020 , "hatch");
        boolean resultCar = carService.deleteCar(carToDelete);
        System.out.println(resultCar);

        //TRUCKS
        Truck truckToFind = truckService.findTruck("11111111111111111");
        System.out.println(truckToFind.getBrand());

        Truck truckToUpdate = new Truck((double) 66666,"pinkmarin",(short) 1999,666666,true,"ABCDEFGHIJKLMNOPQ");
        truckToUpdate = truckService.updateTruck(truckToUpdate);
        System.out.println(truckToUpdate.getBrand());

        Truck truckToDelete = new Truck((double) 66666,"pinkmarin",(short) 1999,666666,true,"1C3CCBCB1CN158744");
        boolean resultTruck = truckService.deleteTruck(truckToDelete);
        System.out.println(resultTruck);

        //VANS
        Van vanToFind = vanService.findVan("11111111111111111");
        System.out.println(vanToFind.getBrand());

        Van vanToUpdate = new Van("33333333333333333", (double)122000, "vanbrand2REBRANDEDHAHAHAH", (short)2020,1020 , 2222);
        vanToUpdate = vanService.updateVan(vanToUpdate);
        System.out.println(vanToUpdate.getBrand());

        Van vanToDelete = new Van("55555555555555555", (double)122000, "vanbrand2REBRANDEDHAHAHAH", (short)2020,1020 , 4444);
        boolean resultVan = vanService.deleteVan(vanToDelete);
        System.out.println(resultVan);
    }
}

