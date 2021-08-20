package vehicle;

public class VehicleNo {
    private final String no;

    private static final int VEHICLE_NUMBER_SIZE = 4;
    private static final String NUMBER_REGEX = "\\d{4}";

    public VehicleNo(String no) {
        validate(no);
        this.no = no;
    }

    public String getNo() {
        return this.no;
    }

    private void validate(String no) {
        if (!isSizeFour(no)) {
            throw new RuntimeException("차량 번호는 4자리만 가능합니다.");
        }
        if (!isNumber(no)) {
            throw new RuntimeException("차량 번호는 숫자로 구성되어야 합니다.");
        }
    }

    private boolean isSizeFour(String no) {
        return no.length() == VEHICLE_NUMBER_SIZE;
    }

    private boolean isNumber(String no) {
        return no.matches(NUMBER_REGEX);
    }
}
