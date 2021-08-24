package vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleTypeTest {
    @Test
    @DisplayName("차량 종류가 출력되는지")
    void show_type() {
        assertEquals("S", VehicleType.SMALL.getType());
        assertEquals("M", VehicleType.MIDSIZE.getType());
        assertEquals("L", VehicleType.LARGE.getType());
    }

    @Test
    @DisplayName("차량 크기가 출력되는지")
    void show_size() {
        assertEquals(1, VehicleType.SMALL.getSize());
        assertEquals(2, VehicleType.MIDSIZE.getSize());
        assertEquals(3, VehicleType.LARGE.getSize());
    }

    @Test
    @DisplayName("type 값으로 VehicleType을 잘 찾는지")
    void search_type() {
        assertEquals(VehicleType.SMALL, VehicleType.ofType("S"));
        assertEquals(VehicleType.MIDSIZE, VehicleType.ofType("M"));
        assertEquals(VehicleType.LARGE, VehicleType.ofType("L"));
    }

    @Test
    @DisplayName("size 값으로 VehicleSize을 잘 찾는지")
    void search_size() {
        assertEquals(VehicleType.SMALL, VehicleType.ofSize(1));
        assertEquals(VehicleType.MIDSIZE, VehicleType.ofSize(2));
        assertEquals(VehicleType.LARGE, VehicleType.ofSize(3));
    }

    @Test
    @DisplayName("차량 타입에 맞지 않은 사이즈가 입력될 때")
    void wrong_size() {
        Exception exception = assertThrows(RuntimeException.class, () -> VehicleType.ofSize(5));
        assertEquals("차량 타입에 맞지 않은 사이즈입니다.", exception.getMessage());
    }
}
