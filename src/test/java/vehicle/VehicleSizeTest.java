package vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vehicle.VehicleSize;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleSizeTest {
    @Test
    @DisplayName("자동차의 크기가 정상일 때")
    void right_size() {
        assertEquals(1, new VehicleSize(1).getSize());
        assertEquals(2, new VehicleSize(2).getSize());
        assertEquals(3, new VehicleSize(3).getSize());
    }

    @Test
    @DisplayName("자동차의 크기가 비정상일 때")
    void wrong_size() {
        Exception exception = assertThrows(RuntimeException.class, () -> new VehicleSize(5));
        assertEquals("주차할 수 없는 크기입니다.", exception.getMessage());
    }
}
