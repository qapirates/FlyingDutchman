package application.rest.v1.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.rest.v1.models.DeviceModel;
import application.rest.v1.services.AdminOriginAddEntryService;

@RestController
@RequestMapping("/admin")
public class AdminOrigin {
	
	@PostMapping(value = "/addDeviceForUser")
	public ResponseEntity<DeviceModel>  addnewDevice(@RequestBody HashMap<String, Object> payload) {
		
		DeviceModel deviceModel = new DeviceModel();

		System.err.println(payload);
		
		deviceModel.setStatus(payload.get("Status").toString());
		deviceModel.setCountry(payload.get("country").toString());
		deviceModel.setMac_id(payload.get("MAC_Id").toString());
		deviceModel.setArea(payload.get("area-city").toString());
		deviceModel.setDevice_name(payload.get("Device_Id").toString());
		deviceModel.setLatitude(payload.get("latitude").toString());
		deviceModel.setGuid(payload.get("GUID").toString());
		deviceModel.setLongitude(payload.get("longtitude").toString());
		deviceModel.setState(payload.get("states").toString());
		
		AdminOriginAddEntryService.contactInsertionApi(deviceModel.getGuid(), deviceModel.getMac_id(), deviceModel.getDevice_name(), deviceModel.getStatus(), 
				deviceModel.getCountry(), deviceModel.getState(), deviceModel.getArea(), deviceModel.getLatitude(), deviceModel.getLongitude());
		
		return ResponseEntity.ok(deviceModel);
	}

}
