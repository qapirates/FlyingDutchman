package application.rest.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/v1")
public class Example {


    @GetMapping("/")
    public String getHome() {
    	return "home";
    }
//    public @ResponseBody ResponseEntity<String> example() {
//        List<String> list = new ArrayList<>();
//        //return a simple list of strings
//        list.add("Congratulations, your application is up and running");
//        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
//    }
    
    @RequestMapping("/error")
    public String showErrorPage() {
        return "error";
    }

}
// UJ2NyPH2WJCc1yaiVK8-