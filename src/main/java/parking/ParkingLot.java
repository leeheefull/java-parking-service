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
        validateDuplication(vehicle);
        validateExistence(parkingPosition);
        validateType(parkingPosition, vehicle);
        validateFull();
        this.vehicles.put(parkingPosition, vehicle);
    }

    public void takeOut(Vehicle vehicle) {
        validateEqualExistence(vehicle);
        this.vehicles.values().removeAll(Collections.singleton(vehicle));
    }

    private void validateDuplication(Vehicle vehicle) {
        if (isContainVehicle(vehicle)) {
            throw new RuntimeException("해당 차량은 이미 주차되어있는 상태입니다.");
        }
    }

    private void validateExistence(ParkingPosition parkingPosition) {
        if (isOccupy(parkingPosition)) {
            throw new RuntimeException("해당 위치에는 이미 주차 되어있는 차량이 있습니다.");
        }
    }

    private void validateType(ParkingPosition parkingPosition, Vehicle vehicle) {
        if (isEqualType(parkingPosition, vehicle)) {
            throw new RuntimeException("차량 타입에 맞지 않는 주차 지역입니다.");
        }
    }

    private void validateFull() {
        if (isFull()) {
            throw new RuntimeException("현재 주차장이 꽉찬 상태입니다.");
        }
    }

    private void validateEqualExistence(Vehicle vehicle) {
        if (!isContainVehicle(vehicle)) {
            throw new RuntimeException("주차 되어있지 않은 차량입니다.");
        }
    }

    private boolean isContainVehicle(Vehicle vehicle) {
        return this.vehicles.containsValue(vehicle);
    }

    private boolean isOccupy(ParkingPosition parkingPosition) {
        return this.vehicles.containsKey(parkingPosition);
    }

    private boolean isEqualType(ParkingPosition parkingPosition, Vehicle vehicle) {
        return parkingPosition.getType() != vehicle.getType() && vehicle.getType() != VehicleType.SMALL;
    }

    private boolean isFull() {
        return this.vehicles.size() == PARKING_LOT_MAX_CNT;
    }
}
