package application.rest.v1.general.renderhelper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dutchman")
public class GeneralViewRenderHelper {

	@GetMapping("/dashboard")
	public String renderDashboard() {
		return "userDashboard";
	}
	
}
