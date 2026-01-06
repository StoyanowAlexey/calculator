package org.example.calculator;


import org.example.calculator.Enums.OperationType;

import java.util.Objects;

public class Operations {
    private boolean status;
    private OperationType operationType;

    public boolean isStatus() {
        return status;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
