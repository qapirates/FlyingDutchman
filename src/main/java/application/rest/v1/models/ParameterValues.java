package application.rest.v1.models;

public class ParameterValues {

	private String datetime;
	private int value;
	
	public ParameterValues() {
		
	}
	public ParameterValues(String datetime, int value) {
		this.datetime = datetime;
		this.value = value;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
