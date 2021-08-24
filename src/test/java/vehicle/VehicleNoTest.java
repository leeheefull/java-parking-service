package vehicle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleNoTest {
    @Test
    @DisplayName("차량 번호가 정상일 때")
    void right_no() {
        assertEquals("1234", new VehicleNo("1234").getNo());
        assertEquals("0001", new VehicleNo("0001").getNo());
    }

    @Test
    @DisplayName("차량 번호가 비정상일 때: 4자리가 아님")
    void wrong_no1() {
        Exception exception = assertThrows(RuntimeException.class, () -> new VehicleNo("123454"));
        assertEquals("차량 번호는 4자리인 숫자로 구성되어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("차량 번호가 비정상일 때: 숫자로 구성되지 않음")
    void wrong_no2() {
        Exception exception = assertThrows(RuntimeException.class, () -> new VehicleNo("or1q"));
        assertEquals("차량 번호는 4자리인 숫자로 구성되어야 합니다.", exception.getMessage());
    }
}
