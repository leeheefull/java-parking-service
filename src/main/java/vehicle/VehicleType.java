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
                .orElseThrow(() -> {
                    throw new RuntimeException("존재하지 않는 타입입니다.");
                });
    }

    public static VehicleType ofSize(int inputSize) {
        return Arrays.stream(values())
                .filter(vehicleType -> vehicleType.size == inputSize)
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("차량 타입에 맞지 않은 사이즈입니다.");
                });
    }
}
