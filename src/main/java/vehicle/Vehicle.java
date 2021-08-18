package vehicle;

public class Vehicle {
    private final VehicleNo no;
    private final VehicleType type;

    public Vehicle(String no, int size) {
        this.no = new VehicleNo(no);
        this.type = VehicleType.ofSize(new VehicleSize(size).getSize());
    }

    public VehicleNo getNo() {
        return this.no;
    }

    public VehicleType getType() {
        return this.type;
    }
}
