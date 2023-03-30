package main;

import db.DataSource;
import entity.Resident;
import entity.Vehicle;
import service.CarParkingService;

import java.util.Scanner;

public class CarParkingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataSource dataSource = new DataSource();
        Resident resident = new Resident();
        Vehicle vehicle = new Vehicle();
        CarParkingService carParkingLotService = new CarParkingService();

        carParkingLotService.residentDetails(scanner, resident);
        carParkingLotService.vehicleInfo(scanner, vehicle);

        dataSource.insertResidentDetailsAndVehicleInfo(dataSource.config(), resident, vehicle);

    }
}
