package application.rest.v1.models;

import java.time.LocalDateTime;

public class IndevidualDeviceHolder implements Comparable<IndevidualDeviceHolder>  {
	
	private LocalDateTime datetime;	
	String parameter;
	
	public IndevidualDeviceHolder() {
		super();
	}
	
	public IndevidualDeviceHolder(String datetime, String parameter) {
		super();
		LocalDateTime dateTimes = LocalDateTime.parse(datetime);
		this.datetime = dateTimes;
		this.parameter = parameter;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		LocalDateTime dateTimes = LocalDateTime.parse(datetime);
		this.datetime = dateTimes;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public int compareTo(IndevidualDeviceHolder o) {
		 int diff = this.datetime.compareTo(o.datetime);
		return diff > 0 ? 1 : diff < 0 ? -1 :0;
	}

	
	
	
	
	

}
