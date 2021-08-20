package parking;

import java.util.Objects;

public class ParkingFloor {
    private final int floor;

    private static final int START_OF_FLOOR = 1;
    private static final int END_OF_FLOOR = 5;

    public ParkingFloor(int floor) {
        validate(floor);
        this.floor = floor;
    }

    public int getFloor() {
        return this.floor;
    }

    private void validate(int floor) {
        if (!isFloor(floor)) {
            throw new RuntimeException("주차할 수 없는 층입니다.");
        }
    }

    private boolean isFloor(int floor) {
        return START_OF_FLOOR <= floor && floor <= END_OF_FLOOR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingFloor that = (ParkingFloor) o;
        return floor == that.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor);
    }
}
