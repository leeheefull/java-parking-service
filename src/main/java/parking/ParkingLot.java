package parking;

import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<ParkingPosition, Vehicle> vehicles;

    private static final int PARKING_LOT_MAX_CNT = 75;

    public ParkingLot() {
        this.vehicles = new HashMap<>();
    }

    public Map<ParkingPosition, Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void park(ParkingPosition parkingPosition, Vehicle vehicle) {
        parkValidation(parkingPosition, vehicle);
        this.vehicles.put(parkingPosition, vehicle);
    }

    public void takeOut(Vehicle vehicle) {
        takeOutValidation(vehicle);
        this.vehicles.values().removeAll(Collections.singleton(vehicle));
    }

    private void parkValidation(ParkingPosition parkingPosition, Vehicle vehicle) {
        if (isContain(vehicle)) {
            throw new RuntimeException("해당 차량은 이미 주차되어있는 상태입니다.");
        }
        if (isOccupy(parkingPosition)) {
            throw new RuntimeException("해당 위치에는 이미 주차 되어있는 차량이 있습니다.");
        }
        if (isDifferentTypeExceptSmallVehicle(parkingPosition, vehicle)) {
            throw new RuntimeException("차량 타입에 맞지 않는 주차 지역입니다.");
        }
        if (isFull()) {
            throw new RuntimeException("현재 주차장이 꽉 찬 상태입니다.");
        }
    }

    private void takeOutValidation(Vehicle vehicle) {
        if (!isContain(vehicle)) {
            throw new RuntimeException("주차 되어있지 않은 차량입니다.");
        }
    }

    private boolean isContain(Vehicle vehicle) {
        return this.vehicles.containsValue(vehicle);
    }

    private boolean isOccupy(ParkingPosition parkingPosition) {
        return this.vehicles.containsKey(parkingPosition);
    }

    private boolean isDifferentTypeExceptSmallVehicle(ParkingPosition parkingPosition, Vehicle vehicle) {
        return parkingPosition.getType() != vehicle.getType() && vehicle.getType() != VehicleType.SMALL;
    }

    private boolean isFull() {
        return this.vehicles.size() == PARKING_LOT_MAX_CNT;
    }
}
