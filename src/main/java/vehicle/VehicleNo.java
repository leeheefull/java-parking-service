package vehicle;

public class VehicleNo {
    private final String no;

    private static final String NUMBER_REGEX = "\\d{4}";

    public VehicleNo(String no) {
        validate(no);
        this.no = no;
    }

    public String getNo() {
        return this.no;
    }

    private void validate(String no) {
        if (!isNumber(no)) {
            throw new RuntimeException("차량 번호는 4자리인 숫자로 구성되어야 합니다.");
        }
    }

    private boolean isNumber(String no) {
        return no.matches(NUMBER_REGEX);
    }
}
