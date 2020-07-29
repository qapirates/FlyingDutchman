package application.rest.v1.models;

public class GraphValParameter {

	private String date;
	private int value;
	
	public GraphValParameter() {
		
	}
	public GraphValParameter(String date, int value) {
		super();
		this.date = date;
		this.value = value;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
