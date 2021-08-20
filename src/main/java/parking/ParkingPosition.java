package parking;

import vehicle.VehicleType;

import java.util.Objects;

public class ParkingPosition {
    private final ParkingFloor floor;
    private final VehicleType type;
    private final ParkingNo no;

    private static final int POSITION_LENGTH = 3;

    public ParkingPosition(String position) {
        validate(position);
        this.floor = new ParkingFloor(position.charAt(0) - '0');
        this.type = VehicleType.ofType(position.charAt(1) + "");
        this.no = new ParkingNo(position.charAt(2) - '0');
    }

    public String getPosition() {
        return this.floor.getFloor() + this.type.getType() + this.no.getNo();
    }

    public ParkingFloor getFloor() {
        return this.floor;
    }

    public VehicleType getType() {
        return this.type;
    }

    public ParkingNo getNo() {
        return this.no;
    }

    private void validate(String position) {
        if (!isPosition(position)) {
            throw new RuntimeException("주차 위치는 3글자 입니다.");
        }
    }

    private boolean isPosition(String position) {
        return position.length() == POSITION_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingPosition that = (ParkingPosition) o;
        return Objects.equals(floor, that.floor) && type == that.type && Objects.equals(no, that.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor, type, no);
    }
}
