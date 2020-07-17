package application.rest.v1.models;

public class IndevidualDeviceParams {

	private String parameterName;
	private String value;
	private String color;
	
	public IndevidualDeviceParams(String parameterName, String value, String color) {
		
		this.parameterName = parameterName;
		this.value = value;
		this.color = color;
	}

	public IndevidualDeviceParams() {
		
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
