//package structures;

import java.util.*;

enum VehicleSize {
    COMPACT,
    REGULAR,
    TRUCK,
}

interface Lot {
    void assignSpot(Vehicle car);
    void deAssignSpot(Vehicle car);
    void totalSpots();
}

abstract class Vehicle {
    final VehicleSize type;
    int spotNumber;

    Vehicle(VehicleSize type){
        this.spotNumber = -1;
        this.type = type;
    }

    public boolean canLeave() {
        if (spotNumber >= 0) {
            return true;
        }
        System.out.println("You already left bruh");
        return false;
    }

    public void leave() {
        spotNumber = -1;
        System.out.println(type + " left.");
    }
}

abstract class ParkingSpot {
    final VehicleSize type;
    boolean filled;

    ParkingSpot(VehicleSize t){
        this.type = t;
        this.filled = false;
    }

    boolean canFit(Vehicle car){
        if (filled || type != car.type){
            return false;
        }
        return true;
    }

    void park(Vehicle car, int index){
        car.spotNumber = index;
        filled = true;
        System.out.println("the "+car.type+" car went to spot "+(index+1));
    }

    void becameEmpty() {
        filled = false;
    }
}

class CompactCar extends Vehicle {
    CompactCar(){
        super(VehicleSize.COMPACT);
    }
}

class RegularCar extends Vehicle {
    RegularCar(){
        super(VehicleSize.REGULAR);
    }
}

class Truck extends Vehicle {
    Truck(){
        super(VehicleSize.TRUCK);
    }
}
class CompactSpot extends ParkingSpot{
    CompactSpot(){
        super(VehicleSize.COMPACT);
    }
}

class RegularSpot extends ParkingSpot{
    RegularSpot(){
        super(VehicleSize.REGULAR);
    }
}

class ParkingLot implements Lot{
    ArrayList<ParkingSpot> spots = new ArrayList<>();

    ParkingLot(){
        this.spots = new ArrayList<>();
    }

    public void assignSpot(Vehicle car){
        int index = 0;
        for (ParkingSpot spot : spots) {
            if (spot.canFit(car)) {
                spot.park(car, index);
                return;
            }
            index++;
        }
        System.out.println("There are no available spots for "+car.type);
    };

    public void deAssignSpot(Vehicle car){
        if (car.canLeave()) {
            spots.get(car.spotNumber).becameEmpty();
            car.leave();
        }
    };

    public void totalSpots(){
        int rv = 0;
        for (ParkingSpot s : spots){
            if (!s.filled){
                rv++;
            }
        }
        System.out.println("There are "+rv+" spots available");
    };

    static void main() {
        ParkingLot myLot = new ParkingLot();
        RegularCar car1 = new RegularCar();
        CompactCar car2 = new CompactCar();

        CompactSpot cspot = new CompactSpot();
        CompactSpot cspot2 = new CompactSpot();

        RegularSpot rspot = new RegularSpot();
        RegularSpot rspot2 = new RegularSpot();

        myLot.spots.add(cspot);
        myLot.spots.add(rspot);
        myLot.spots.add(cspot2);

        myLot.totalSpots();

        myLot.assignSpot(car1);
        myLot.assignSpot(car2);
        myLot.totalSpots();

        myLot.deAssignSpot(car1);
        myLot.totalSpots();
        myLot.deAssignSpot(car2);

//        myLot.assignSpot(car1);
        myLot.totalSpots();

    }
}
