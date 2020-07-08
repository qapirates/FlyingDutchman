package application.rest.v1.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.rest.v1.models.DeviceModel;
import application.rest.v1.models.Users;
import application.rest.v1.services.AdminOriginAddEntryService;

@RestController
@RequestMapping("/admin")
public class AdminOrigin {
	
	@PostMapping(value = "/addDeviceForUser")
	public ResponseEntity<DeviceModel>  addnewDevice(@RequestBody HashMap<String, Object> payload) {
		
		DeviceModel deviceModel = new DeviceModel();

		//System.err.println(payload);
		
		deviceModel.setStatus(payload.get("Status").toString());
		deviceModel.setCountry(payload.get("country").toString());
		deviceModel.setMac_id(payload.get("MAC_Id").toString());
		deviceModel.setArea(payload.get("area-city").toString());
		deviceModel.setDevice_Name(payload.get("Device_Id").toString());
		deviceModel.setLatitude(payload.get("latitude").toString());
		deviceModel.setGuid(payload.get("GUID").toString());
		deviceModel.setLongitude(payload.get("longtitude").toString());
		deviceModel.setState(payload.get("states").toString());
		deviceModel.setOwner(payload.get("owner").toString());
		
		Boolean flag = AdminOriginAddEntryService.contactInsertionApi(deviceModel.getGuid(), deviceModel.getMac_id(), deviceModel.getDevice_Name(), deviceModel.getStatus(), 
				deviceModel.getCountry(), deviceModel.getState(), deviceModel.getArea(), deviceModel.getLatitude(), deviceModel.getLongitude(), deviceModel.getOwner());
		
		return ResponseEntity.ok(deviceModel);
	}
	
	@PostMapping(value = "/updateDeviceForUser")
	public ResponseEntity<DeviceModel>  updateDevice(@RequestBody HashMap<String, Object> payload) {
		
		DeviceModel deviceModel = new DeviceModel();

		//System.err.println(payload);
		deviceModel.setId(Integer.parseInt(payload.get("Id").toString()));
		deviceModel.setStatus(payload.get("Status").toString());
		deviceModel.setCountry(payload.get("country").toString());
		deviceModel.setMac_id(payload.get("MAC_Id").toString());
		deviceModel.setArea(payload.get("area-city").toString());
		deviceModel.setDevice_Name(payload.get("Device_Id").toString());
		deviceModel.setLatitude(payload.get("latitude").toString());
		deviceModel.setGuid(payload.get("GUID").toString());
		deviceModel.setLongitude(payload.get("longtitude").toString());
		deviceModel.setState(payload.get("states").toString());
		deviceModel.setOwner(payload.get("owner").toString());
		
		AdminOriginAddEntryService.contactUpdateApi(deviceModel.getId(), deviceModel.getGuid(), deviceModel.getMac_id(), deviceModel.getDevice_Name(), deviceModel.getStatus(), 
				deviceModel.getCountry(), deviceModel.getState(), deviceModel.getArea(), deviceModel.getLatitude(), deviceModel.getLongitude(), deviceModel.getOwner());
		
		return ResponseEntity.ok(deviceModel);
	}
	
	@PostMapping(value = "/deleteDeviceForUser")
	public ResponseEntity<DeviceModel>  deleteDevice(@RequestBody HashMap<String, Object> payload) {
		
		DeviceModel deviceModel = new DeviceModel();

		//System.err.println(payload);
		deviceModel.setId(Integer.parseInt(payload.get("Id").toString()));
		
		AdminOriginAddEntryService.contactDeleteApi(deviceModel.getId());
		
		return ResponseEntity.ok(deviceModel);
	}
	
	@PostMapping(value = "/addAnUser")
	public ResponseEntity<Users>  addanUser(@RequestBody HashMap<String, Object> payload) {
		
		Users users = new Users();

		//System.err.println(payload);
		
		users.setRole_Id(Integer.parseInt(payload.get("role").toString()));
		users.setName(payload.get("username").toString());
		users.setPhoneNumber(payload.get("phonenumber").toString());
		users.setAlternativePhoneNumber(payload.get("altphonenumber").toString());
		users.setEmailAddress(payload.get("email").toString());
		users.setNotificationFrequency(payload.get("notification").toString());
		
		
		Boolean flag = AdminOriginAddEntryService.contactCreateUserApi(users.getRole_Id(), users.getName(), users.getPhoneNumber(), users.getAlternativePhoneNumber(), users.getEmailAddress(), users.getNotificationFrequency());
		
		return ResponseEntity.ok(users);
	}
	
}
