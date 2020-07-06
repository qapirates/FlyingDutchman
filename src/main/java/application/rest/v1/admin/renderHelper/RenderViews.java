package application.rest.v1.admin.renderHelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class RenderViews {

	@GetMapping("/addNew")
	public static String getView() {
		return "deviceDetails";
	}
	
}
