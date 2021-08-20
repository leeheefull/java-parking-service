package vehicle;

public class VehicleSize {
    private final int size;

    public VehicleSize(int size) {
        validate(size);
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    private void validate(int size) {
        if (!isVehicleSize(size)) {
            throw new RuntimeException("주차할 수 없는 크기입니다.");
        }
    }

    private boolean isVehicleSize(int size) {
        return VehicleType.SMALL.getSize() <= size && size <= VehicleType.LARGE.getSize();
    }
}
