package com.example.demo;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TextField text_recieve;
    private String op = "";
    private long number1;
    private long number2;

    public void Number (ActionEvent ae) {
        String no = ((Button)ae.getSource()).getText();
        text_recieve.setText(text_recieve.getText() + no);
    }

    public void Operation (ActionEvent ae) {
        String operation = ((Button)ae.getSource()).getText();
        if (!operation.equals("=")) {

            if (!op.equals("")) {
                return;
            }
            op = operation;
            number1 = Long.parseLong(text_recieve.getText());
            text_recieve.setText("");
        } else {

            if (op.equals("")) {
                return;
            }
            number2 = Long.parseLong(text_recieve.getText());
            calculate(number1, number2, op);
            op = "";
        }
    }

    public void calculate(long num1, long num2, String operation) {

        switch (operation) {
            case "+":
                text_recieve.setText(num1+ num2 + "");
                break;
            case "-":
                text_recieve.setText(num1 - num2 + "");
                break;
            case "*":
                text_recieve.setText(num1 * num2 + "");
                break;
            case "/":
                if (number2 == 0) {
                    text_recieve.setText("0");
                    break;
                }
                text_recieve.setText(num1 / num2 + "");
                break;
        }
    }
}