package org.example.calculator.calculator_view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.calculator.Calculate;
import org.example.calculator.Enums.OperationType;
import org.example.calculator.Operations;

import java.util.Objects;

public class CalculatorView {
    @FXML
    private Label label;
    private final Operations operationNow = new Operations();
    private final Calculate calculate = new Calculate();
    private final StringBuilder number  = new StringBuilder();

    @FXML
    public void clear(){
        number.setLength(0);
        calculate.setNumber2(null);
        calculate.setNumber1(null);
        operationNow.setOperationType(null);
        operationNow.setStatus(false);
        label.setText("");
    }

    @FXML
    public void createNumber(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        String numberNow = button.getUserData().toString();
        label.setText(label.getText() + numberNow);
        number.append(numberNow);
    }

    @FXML
    public void buttons(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        String operation = button.getUserData().toString();
        String operationSymbol = button.getText();

        if (button.getUserData().toString().equals("SUBTRACT") && number.isEmpty() && !operationNow.isStatus()) {
            number.append("-");
            label.setText(label.getText() + "-");
            return;
        }

        if (!operationNow.isStatus() && !Objects.equals(operation, "EQUAL")) {
            operationNow.setOperationType(OperationType.valueOf(operation));
            operationNow.setStatus(true);
            if (Objects.equals(calculate.getNumber1(), null)) calculate.setNumber1(number.toString());
            System.out.println(calculate.getNumber1());
            number.setLength(0);
            label.setText(label.getText() + operationSymbol);
        }

        else {
            calculate.setNumber2(number.toString());
            System.out.println("number 1 - " + calculate.getNumber1() + ", number 2 - " + calculate.getNumber2());
            String result = String.valueOf(calculate.count(operationNow));
            label.setText(result);
            calculate.setNumber1(result);
            number.setLength(0);
            if (!Objects.equals("EQUAL", operation)) label.setText(label.getText() + operationSymbol);
            else operationNow.setStatus(false);
            System.out.println("number 1 - " + calculate.getNumber1() + ", number 2 - " + calculate.getNumber2());

        }
    }
    //1) пользователь вводит число  -> !!! еслі тікает на какой то знак(когда lable пуст) -> либо ничего не делать, либо шото написать
    //2) оно преобразуеться из стрінга в інт
    //3) дальше пользователь вводит знак
    //4) дальше второе число
    //5) а вот тут интересно потому шо не обязательно идет равно а может идти и просто operation и тогда оно должно автоматически сумироваться либо надо продумать логику


}
