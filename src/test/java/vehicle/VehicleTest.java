package vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    @Test
    @DisplayName("자동차가 잘 저장 되는지")
    void save_vehicle() {
        // given, when
        Vehicle vehicle = new Vehicle("1234", 2);

        // then
        assertEquals("1234", vehicle.getNo().getNo());
        assertEquals(VehicleType.MIDSIZE, vehicle.getType());
    }
}
