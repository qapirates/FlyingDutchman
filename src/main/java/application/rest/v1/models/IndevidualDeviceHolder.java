package application.rest.v1.models;

import java.util.Map;

public class IndevidualDeviceHolder {
	
	private String datetime;	
	String parameter;
	
	public IndevidualDeviceHolder() {
		super();
	}
	
	public IndevidualDeviceHolder(String datetime, String parameter) {
		super();
		this.datetime = datetime;
		this.parameter = parameter;
	}

	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	
	
	

}
