package application.rest.v1.models;

public class IndevidualDeviceMain {

	private String datetime;
	private IndevidualDeviceParams[] params;
	
	public IndevidualDeviceMain(String datetime, IndevidualDeviceParams[] params) {
		super();
		this.datetime = datetime;
		this.params = params;
	}

	public IndevidualDeviceMain() {
		
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public IndevidualDeviceParams[] getParams() {
		return params;
	}

	public void setParams(IndevidualDeviceParams[] params) {
		this.params = params;
	}	
	
}
