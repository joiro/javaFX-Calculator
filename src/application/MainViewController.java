package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainViewController {
	
	@FXML Label display;
	@FXML Button one, two, three, four, five, six, seven, eight, nine, zero, times, divided, plus, minus, percent, change, buttonDelete;
	
	private Boolean operatorClicked = false;
	private Boolean plusOperation = false;
	private Boolean minusOperation = false; 
	private Boolean timesOperation = false; 
	private Boolean dividedOperation = false;
	private int operatorCount = 0;
	
	private List<String> temporary = new ArrayList<String>();
	private List<Double> allNumbers = new ArrayList<Double>();
	
	private String actualText;
	private String tempNumber;
	
	private Main main;

	public void setMain(Main main) {
		this.main = main;
		display.setText("0");
	}
	
	@FXML
	public void handleClick(Event event){
		String number;
		//number = temporary.get(operatorCount);
		//System.out.println("number: "+number);
		actualText = display.getText();
		if (display.getText() == "0"){
			buttonDelete.setText("C");
			display.setText("");
			actualText = "";
		}
		Button btn = (Button) event.getSource();
		switch(btn.getId()) {
		case "zero" :
			display.setText(actualText+0);
			number = "0";
			temporary.add(number);
			break;
		case "one" :
			display.setText(actualText+1);
			number = "1";
			temporary.add(number);
			break;
		case "two" :
			display.setText(actualText+2);
			number = "2";
			temporary.add(number);
			break;
		case "three" :
			display.setText(actualText+3);
			number = "3";
			temporary.add(number);
			break;
		case "four" :
			display.setText(actualText+4);
			number = "4";
			temporary.add(number);
			break;
		case "five" :
			display.setText(actualText+5);
			number = "5";
			temporary.add(number);
			break;
		case "six" :
			display.setText(actualText+6);
			number = "6";
			temporary.add(number);
			break;
		case "seven" :
			display.setText(actualText+7);
			number = "7";
			temporary.add(number);
			break;
		case "eight" :
			display.setText(actualText+8);
			number = "8";
			temporary.add(number);
			break;
		case "nine" :
			display.setText(actualText+9);
			number = "9";
			temporary.add(number);
			break;
		}
	}
	
	@FXML public void delete(Event event) {
		buttonDelete.setText("AC");
		display.setText("0");
		temporary.clear();
		allNumbers.clear();
		operatorCount = 0;
		operatorClicked = false;
		plusOperation = false;
		minusOperation = false; 
		timesOperation = false; 
		dividedOperation = false;
	}
	
	@FXML public void storeTemporary(){
		tempNumber = "";
		for(String i : temporary) {
			tempNumber += i;
		}
		allNumbers.add(Double.parseDouble(tempNumber));
		tempNumber = "";
		temporary.clear();
	}
	
	@FXML public void operation(Event event) {
		storeTemporary();
		System.out.println("numbersEntered: "+temporary);
		operatorCount ++;
		System.out.println("operatorCount: "+operatorCount);
		if (display.getText() != ""){
			actualText = display.getText();
			operatorClicked = true;
			System.out.println("operatorClicked: "+operatorClicked);
		}
		Button btn = (Button) event.getSource();
		String operation = btn.getId();
		switch(operation) {
		case "plus":
			display.setText(actualText+"+");
			plusOperation = true;
			break;
		case "minus":
			display.setText(actualText+"-");
			minusOperation = true;
			break;
		case "times":
			display.setText(actualText+"╳");
			timesOperation = true;
			break;
		case "divided":
			display.setText(actualText+"÷");
			dividedOperation = true;
			break;
		}
	}
	
	@FXML public void changeSign() {
		double number = Double.parseDouble(display.getText());
		try {
			if (number != 0){
				number = number * (-1);
				display.setText(Double.toString(number));
				System.out.println(number);
			} else {
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	@FXML public void result(Event event) {
		storeTemporary();
		System.out.println("allNumbers: "+allNumbers);
		double result = 0;
		if (plusOperation == true){
			result = allNumbers.get(0) + allNumbers.get(1);
		} else if (minusOperation == true){
			result = allNumbers.get(0) - allNumbers.get(1);
		} else if (timesOperation == true){
			result = allNumbers.get(0) * allNumbers.get(1);
		} else if (dividedOperation == true){
			result = allNumbers.get(0) / allNumbers.get(1);
		}
		System.out.println("result: "+result);
		display.setText(Double.toString(result));
	}
}

