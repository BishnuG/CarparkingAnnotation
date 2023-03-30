package service;

import entity.Resident;
import entity.Vehicle;

import java.util.Scanner;

public class CarParkingService {

    public void residentDetails(Scanner scanner, Resident resident){

        System.out.println("Enter resident name");
        String residentName = scanner.next();
        resident.setResidentName(residentName);

        System.out.println("Enter resident email");
        String residentEmail = scanner.next();
        resident.setResidentEmail(residentEmail);

        System.out.println("Enter flat number");
        int flatNumber = scanner.nextInt();
        resident.setFlatNumber(flatNumber);

        boolean flag;
        do {
            System.out.println("Enter resident mobile name");
            long mobileNumber = scanner.nextLong();
            if(mobileNumberValidation(mobileNumber)){
                resident.setMobileNumber(mobileNumber);
                break;
            }else{
                System.out.println("Invalid mobile number, plz enter again");
                flag = false;
            }

        } while (flag == false);

    }

    public void vehicleInfo(Scanner scanner, Vehicle vehicle){

        System.out.println("Enter vehicle type like 4-wheeler or 2-wheeler");
        String type = scanner.next();
        vehicle.setType(type);

        boolean flag;
        do {
            System.out.println("Enter vehicle registration number");
            long registrationNumber = scanner.nextLong();
            if(registrationNumberValidation(registrationNumber)){
                vehicle.setRegistrationNumber(registrationNumber);
                break;
            }else{
                System.out.println("Please provide valid registration number");
                flag = false;
            }

        } while (flag == false);

    }

    public boolean mobileNumberValidation(long mobileNumber){
        String mobNumber = Long.toString(mobileNumber);
        if(mobNumber != "" && mobNumber.length() == 10 ){
            return true;
        }
        return false;
    }

    public boolean registrationNumberValidation(long registrationNumber){
        String regNum = Long.toString(registrationNumber);
        if(regNum != "" && regNum.length() <= 8 ){
            return true;
        }
        return false;
    }
}
