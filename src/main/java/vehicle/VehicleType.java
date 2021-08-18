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
        return Arrays.stream(values())
                .filter(vehicleType -> vehicleType.size == inputSize)
                .findFirst()
                .get();
    }
}
