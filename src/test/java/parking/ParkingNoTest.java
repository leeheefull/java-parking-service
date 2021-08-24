package parking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingNoTest {
    @Test
    @DisplayName("주차 번호가 정상일 때")
    void right_no() {
        assertEquals(1, new ParkingNo(1).getNo());
        assertEquals(2, new ParkingNo(2).getNo());
        assertEquals(3, new ParkingNo(3).getNo());
        assertEquals(4, new ParkingNo(4).getNo());
        assertEquals(5, new ParkingNo(5).getNo());
    }

    @Test
    @DisplayName("주차 번호가 비정상일 때")
    void wrong_no() {
        Exception exception = assertThrows(RuntimeException.class, () -> new ParkingNo(123).getNo());
        assertEquals("주차할 수 없는 위치입니다.", exception.getMessage());
    }
}
