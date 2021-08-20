package parking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingFloorTest {
    @Test
    @DisplayName("층 번호가 정상일 때")
    void right_floor() {
        assertEquals(1, new ParkingFloor(1).getFloor());
        assertEquals(2, new ParkingFloor(2).getFloor());
        assertEquals(3, new ParkingFloor(3).getFloor());
        assertEquals(4, new ParkingFloor(4).getFloor());
        assertEquals(5, new ParkingFloor(5).getFloor());
    }

    @Test
    @DisplayName("층 번호가 비정상일 때")
    void wrong_floor() {
        Exception exception = assertThrows(RuntimeException.class, () -> new ParkingFloor(123).getFloor());
        assertEquals("주차할 수 없는 층입니다.", exception.getMessage());
    }
}
