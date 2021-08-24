package vehicle;

import java.util.Objects;

public class Vehicle {
    private final VehicleNo no;
    private final VehicleType type;

    public Vehicle(String no, int size) {
        this.no = new VehicleNo(no);
        this.type = VehicleType.ofSize(size);
    }

    public VehicleNo getNo() {
        return this.no;
    }

    public VehicleType getType() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(no, vehicle.no) && type == vehicle.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, type);
    }
}
