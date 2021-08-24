package vehicle;

import java.util.Arrays;

public enum VehicleType {
    SMALL("S", 1),
    MIDSIZE("M", 2),
    LARGE("L", 3);

    private final String type;
    private final int size;

    VehicleType(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return this.type;
    }

    public int getSize() {
        return this.size;
    }

    public static VehicleType ofType(String inputType) {
        return Arrays.stream(values())
                .filter(vehicleType -> vehicleType.type.equals(inputType))
                .findFirst()
                .get();
    }

    public static VehicleType ofSize(int inputSize) {
        validate(inputSize);
        return Arrays.stream(values())
                .filter(vehicleType -> vehicleType.size == inputSize)
                .findFirst()
                .get();
    }

    private static void validate(int size) {
        if (!isVehicleSize(size)) {
            throw new RuntimeException("차량 타입에 맞지 않은 사이즈입니다.");
        }
    }

    private static boolean isVehicleSize(int size) {
        return VehicleType.SMALL.getSize() <= size && size <= VehicleType.LARGE.getSize();
    }
}
