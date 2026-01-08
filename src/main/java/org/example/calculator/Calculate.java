package org.example.calculator;

import org.example.calculator.Enums.OperationType;

public class Calculate {
    private String number1;
    private String number2;

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public double count(final Operations operation){
        double result = 0;
        if (operation.isStatus()) {
            switch (operation.getOperationType()){
                case OperationType.ADD -> {
                    if (!number1.isEmpty() && !number2.isEmpty()) result = Double.parseDouble(number1) + Double.parseDouble(number2);
                }
                case OperationType.DIVIDE -> {
                    try {
                        if (!number1.isEmpty() && !number2.isEmpty())
                            result = Double.parseDouble(number1) / Double.parseDouble(number2);
                    }
                    catch (ArithmeticException arithmeticException){
                        System.out.println("Divided by zero operation cannot possible ");
                    }
                }
                case OperationType.SUBTRACT -> {
                    if (!number1.isEmpty() && !number2.isEmpty()) result = Double.parseDouble(number1) - Double.parseDouble(number2);
                }
                case OperationType.MULTIPLY -> {
                    if (!number1.isEmpty() && !number2.isEmpty()) result = Double.parseDouble(number1) * Double.parseDouble(number2);
                }
            }
        }
        this.number1 = "";
        this.number2 = "";
        return result;
    }
}
