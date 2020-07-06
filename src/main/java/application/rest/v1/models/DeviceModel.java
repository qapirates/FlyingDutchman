package application.rest.v1.models;

public class DeviceModel {

	private String guid;
	private String mac_id;
	private String device_name;
	private String country;
	private String state;
	private String area;
	private String latitude;
	private String longitude;
	private String status;
	
	public DeviceModel() {
		super();
	}

	public DeviceModel(String guid, String mac_id, String device_name, String country, String state, String area,
			String latitude, String longitude, String status) {
		super();
		this.guid = guid;
		this.mac_id = mac_id;
		this.device_name = device_name;
		this.country = country;
		this.state = state;
		this.area = area;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getMac_id() {
		return mac_id;
	}

	public void setMac_id(String mac_id) {
		this.mac_id = mac_id;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}