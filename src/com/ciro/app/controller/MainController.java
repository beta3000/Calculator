package com.ciro.app.controller;

import com.ciro.app.Main;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DecimalFormat;

public class MainController {
    private Main main;

    //Views
    @FXML
    private Label display;
    @FXML
    private Button ac, conversion;
    public void setMain(Main main) {
        this.main = main;
    }

    private Boolean[] operator = {false,false,false,false};
    private double[] temporary = {0,0};
    private DecimalFormat decimalFormat = new DecimalFormat("###.######");

    public void operatorPressed(Event event){
        Button button = (Button) event.getSource();
        switch (button.getId()) {
            case "plus":
                useOperator(0);
                break;
            case "minus":
                useOperator(1);
                break;
            case "times":
                useOperator(2);
                break;
            case "divider":
                useOperator(3);
                break;
        }
        display.setText("");
    }

    public void buttonPressed(Event event){
        Button button = (Button) event.getSource();

        switch (button.getId()){
            case "one":
                addCharacter("1");
                System.out.println("one has been pressed");
                break;
            case "two":
                addCharacter("2");
                System.out.println("two has been pressed");
                break;
            case "three":
                addCharacter("3");
                System.out.println("three has been pressed");
                break;
            case "four":
                addCharacter("4");
                System.out.println("four has been pressed");
                break;
            case "five":
                addCharacter("5");
                System.out.println("five has been pressed");
                break;
            case "six":
                addCharacter("6");
                System.out.println("six has been pressed");
                break;
            case "seven":
                addCharacter("7");
                System.out.println("seven has been pressed");
                break;
            case "eight":
                addCharacter("8");
                System.out.println("eight has been pressed");
                break;
            case "nine":
                addCharacter("9");
                System.out.println("nine has been pressed");
                break;
            case "zero":
                addCharacter("0");
                System.out.println("zero has been pressed");
                break;
            case "comma":
                addCharacter(".");
                System.out.println("comma has been pressed");
                break;
        }
    }

    public void delete(){
        ac.setText("AC");
        display.setText("0");
        clearArrays();
    }

    public void result(){
        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        if (operator[0])
            result = temporary[0]+temporary[1];
        else if (operator[1])
            result = temporary[0]-temporary[1];
        else if (operator[2])
            result = temporary[0]*temporary[1];
        else if (operator[3])
            result = temporary[0]/temporary[1];

        display.setText(decimalFormat.format(result));
    }

    public void conversion(){
        if (!display.getText().equals("0")){
            Double value = Double.parseDouble(display.getText());
            value *= -1;
            display.setText(decimalFormat.format(value.toString()));
        }
    }

    public void percent(){
        Double value = Double.parseDouble(display.getText());
        value*=0.01;
        display.setText(decimalFormat.format(value.toString()));
    }

    private void addCharacter(String character){
        if (display.getText().equals("0")){
            ac.setText("C");
            display.setText("");
        }
        display.setText(display.getText()+character);
    }

    private void useOperator(int index){
        temporary[0] = Double.parseDouble(display.getText());
        for (int i = 0; i<operator.length; i++){
            if (i == index)
                operator[index] = true;
            else
                operator[i] = false;
        }
    }

    private void clearArrays(){
        for (int i = 0; i<operator.length; i++)
            operator[i] = false;
        for (int i = 0; i<temporary.length; i++)
            temporary[i] = 0;
    }
}
