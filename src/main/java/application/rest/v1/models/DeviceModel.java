package application.rest.v1.models;

public class DeviceModel {

	private int id;
	private String guid;
	private String mac_Id;
	private String device_Name;
	private String country;
	private String state;
	private String area;
	private String latitude;
	private String longitude;
	private String status;
	private String lastupdatedby;
	private String lastupdatedon;
	
	
	
	public String getMac_Id() {
		return mac_Id;
	}

	public void setMac_Id(String mac_Id) {
		this.mac_Id = mac_Id;
	}

	public String getLastupdatedby() {
		return lastupdatedby;
	}

	public void setLastupdatedby(String lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public String getLastupdatedon() {
		return lastupdatedon;
	}

	public void setLastupdatedon(String lastupdatedon) {
		this.lastupdatedon = lastupdatedon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return lastupdatedby;
	}

	public void setOwner(String owner) {
		this.lastupdatedby = owner;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getMac_id() {
		return mac_Id;
	}

	public void setMac_id(String mac_id) {
		this.mac_Id = mac_id;
	}

	public String getDevice_Name() {
		return device_Name;
	}

	public void setDevice_Name(String device_name) {
		this.device_Name = device_name;
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
