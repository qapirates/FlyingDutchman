package application.rest.v1.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminOrigin {
	
	@GetMapping("/addNew")
	public static String getView() {
		return "deviceDetails";
	}

}
