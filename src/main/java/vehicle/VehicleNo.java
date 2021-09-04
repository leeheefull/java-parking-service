package vehicle;

public class VehicleNo {
    private final String no;

    private static final String FOUR_DIGITS = "\\d{4}";

    public VehicleNo(String no) {
        validate(no);
        this.no = no;
    }

    public String getNo() {
        return this.no;
    }

    private void validate(String no) {
        if (!isFourDigits(no)) {
            throw new RuntimeException("차량 번호는 4자리인 숫자로 구성되어야 합니다.");
        }
    }

    private boolean isFourDigits(String no) {
        return no.matches(FOUR_DIGITS);
    }
}
