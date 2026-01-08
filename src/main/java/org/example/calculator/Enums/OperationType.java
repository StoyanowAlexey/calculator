package org.example.calculator.Enums;

public enum OperationType {
    ADD(true),
    SUBTRACT(true),
    MULTIPLY(true),
    DIVIDE(true);

    private final boolean operation;

    OperationType(boolean operation) {
        this.operation = operation;
    }

}
