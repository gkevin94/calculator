package sample;

public enum Operand {

    DIVIDE("/"),
    MULTIPLY("*"),
    SUBTRACT("-"),
    ADD("+");

    private String operandValue;

    Operand(String operandValue) {
        this.operandValue = operandValue;
    }

    public String getOperandValue() {
        return operandValue;
    }
}
