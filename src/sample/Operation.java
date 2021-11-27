package sample;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    MINUS("-"),
    PLUS("+"),
    DIVISION("÷"),
    MULTIPLY("*"),
    SQRT("sqrt"),
    POWER("power");

    private static final Map<String, Operation> operationsByCode = new HashMap<>();

    static {
        for (Operation value : values()) {
            operationsByCode.put(value.code, value);
        }
    }

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation byCode(String code) {
        return operationsByCode.get(code);
    }
}
