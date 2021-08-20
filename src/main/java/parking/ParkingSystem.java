package parking;

import vehicle.Vehicle;

public class ParkingSystem {
    private final ParkingLot parkingLot;

    public ParkingSystem() {
        this.parkingLot = new ParkingLot();
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }

    public void enter(String parkingPosition, String vehicleNo, int vehicleSize) {
        this.parkingLot.park(
                new ParkingPosition(parkingPosition),
                new Vehicle(vehicleNo, vehicleSize)
        );
    }

    public void exit(String vehicleNo, int vehicleSize) {
        this.parkingLot.takeOut(new Vehicle(vehicleNo, vehicleSize));
    }
}
