package parking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingPositionTest {
    @Test
    @DisplayName("주차 위치가 정상일 때")
    void right_position() {
        assertEquals("1S3", new ParkingPosition("1S3").getPosition());
        assertEquals("2M1", new ParkingPosition("2M1").getPosition());
        assertEquals("3L4", new ParkingPosition("3L4").getPosition());
        assertEquals("4S2", new ParkingPosition("4S2").getPosition());
        assertEquals("5M5", new ParkingPosition("5M5").getPosition());
    }

    @Test
    @DisplayName("주차 위치가 비정상일 때")
    void wrong_position() {
        Exception exception = assertThrows(RuntimeException.class, () -> new ParkingPosition("2H3K").getPosition());
        assertEquals("주차 위치는 3글자 입니다.", exception.getMessage());
    }
}
