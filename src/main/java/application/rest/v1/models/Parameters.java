package application.rest.v1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameters {

	private String name;
	private double lastValue;
	private String inputTime;
	private String color;
	private String action;
	private String correctiveAction;
	private String unit;
		
	
	public Parameters() {
		super();
	}
	
	public Parameters(String name, double lastValue, String inputTime, String color, String action,
			String correctiveAction) {
		this.name = name;
		this.lastValue = lastValue;
		this.inputTime = inputTime;
		this.color = color;
		this.action = action;
		this.correctiveAction = correctiveAction;
	}
	
	public Parameters(String name, double lastValue, String inputTime, String color, String action,
			String correctiveAction, String unit) {
		this.name = name;
		this.lastValue = lastValue;
		this.inputTime = inputTime;
		this.color = color;
		this.action = action;
		this.correctiveAction = correctiveAction;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLastValue() {
		return lastValue;
	}
	public void setLastValue(double lastValue) {
		this.lastValue = lastValue;
	}
	public String getInputTime() {
		return inputTime;
	}
	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCorrectiveAction() {
		return correctiveAction;
	}
	public void setCorrectiveAction(String correctiveAction) {
		this.correctiveAction = correctiveAction;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
	
}
