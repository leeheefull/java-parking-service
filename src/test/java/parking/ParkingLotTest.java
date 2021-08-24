package parking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vehicle.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {
    @Test
    @DisplayName("주차가 정상적으로 될 때")
    void right_park() {
        // given
        ParkingPosition parkingPosition = new ParkingPosition("1S3");
        Vehicle vehicle = new Vehicle("1234", 1);
        ParkingLot parkingLot = new ParkingLot();

        // when
        parkingLot.park(parkingPosition, vehicle);
        String VehicleNo = parkingLot.getVehicles().get(new ParkingPosition("1S3")).getNo().getNo();

        // then
        assertEquals("1234", VehicleNo);
    }

    @Test
    @DisplayName("경차의 특권")
    void right_small_park() {
        // given
        ParkingPosition parkingPosition = new ParkingPosition("1M3");
        Vehicle vehicle = new Vehicle("1234", 1);
        ParkingLot parkingLot = new ParkingLot();

        // when
        parkingLot.park(parkingPosition, vehicle);
        String VehicleNo = parkingLot.getVehicles().get(new ParkingPosition("1M3")).getNo().getNo();

        // then
        assertEquals("1234", VehicleNo);
    }

    @Test
    @DisplayName("출차가 정상적으로 될 때")
    void right_take_out() {
        // given
        ParkingPosition parkingPosition = new ParkingPosition("1S3");
        Vehicle vehicle = new Vehicle("1234", 1);
        ParkingLot parkingLot = new ParkingLot();

        // when
        parkingLot.park(parkingPosition, vehicle);
        parkingLot.takeOut(vehicle);

        // then
        assertEquals(0, parkingLot.getVehicles().size());
    }

    @Test
    @DisplayName("이미 같은 차량이 주차 되어있을 때")
    void wrong_park1() {
        // given
        ParkingPosition parkingPosition = new ParkingPosition("1S3");
        Vehicle vehicle = new Vehicle("1234", 1);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(parkingPosition, vehicle);

        // when, then
        Exception exception = assertThrows(RuntimeException.class, () -> parkingLot.park(
                new ParkingPosition("1S3"),
                vehicle
        ));
        assertEquals("해당 차량은 이미 주차되어있는 상태입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("차량 타입이 맞지 않은 주자 공간에 주차를 했을 때")
    void wrong_park2() {
        // given
        ParkingPosition parkingPosition = new ParkingPosition("1M3");
        Vehicle vehicle = new Vehicle("1234", 3);
        ParkingLot parkingLot = new ParkingLot();

        // when, then
        Exception exception = assertThrows(RuntimeException.class, () -> parkingLot.park(parkingPosition, vehicle));
        assertEquals("차량 타입에 맞지 않는 주차 지역입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("이미 다른 차량이 주차한 곳에 주차를 할 때")
    void wrong_park4() {
        // given
        ParkingLot parkingLot = new ParkingLot();

        ParkingPosition parkingPosition1 = new ParkingPosition("1L3");
        Vehicle vehicle1 = new Vehicle("1234", 3);
        parkingLot.park(parkingPosition1, vehicle1);

        ParkingPosition parkingPosition2 = new ParkingPosition("1L3");
        Vehicle vehicle2 = new Vehicle("4321", 3);

        // when, then
        Exception exception = assertThrows(RuntimeException.class, () -> parkingLot.park(parkingPosition2, vehicle2));
        assertEquals("해당 위치에는 이미 주차 되어있는 차량이 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("주차 되어있지 않은 차량을 출차하려고 할 때")
    void wrong_take_out() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Vehicle vehicle = new Vehicle("1234", 3);

        // when, then
        Exception exception = assertThrows(RuntimeException.class, () -> parkingLot.takeOut(vehicle));
        assertEquals("주차 되어있지 않은 차량입니다.", exception.getMessage());
    }
}
