package application.rest.v1.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	private String color;

	private List<Parameters> parameterValues;


	public DeviceModel() {
		super();
	}

	public DeviceModel(int id, String device_Name, String country, String state, String area, String color, String lstUpdatedOn, List<Parameters> parameterValues) {
		super();
		this.id = id;
		this.device_Name = device_Name;
		this.country = country;
		this.state = state;
		this.area = area;
		this.color = color;
		this.lastupdatedon = lstUpdatedOn;
		this.parameterValues = parameterValues;
	}


	public DeviceModel(int id, String guid, String mac_Id, String device_Name, String country, String state,
			String area, String latitude, String longitude, String status, String lastupdatedby, String lastupdatedon,
			String color, List<Parameters> parameterValues) {
		super();
		this.id = id;
		this.guid = guid;
		this.mac_Id = mac_Id;
		this.device_Name = device_Name;
		this.country = country;
		this.state = state;
		this.area = area;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
		this.lastupdatedby = lastupdatedby;
		this.lastupdatedon = lastupdatedon;
		this.color = color;
		this.parameterValues = parameterValues;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	public List<Parameters> getParameterValues() {
		return parameterValues;
	}

	public void setParameterValues(List<Parameters> parameterValues) {
		this.parameterValues = parameterValues;
	}

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
