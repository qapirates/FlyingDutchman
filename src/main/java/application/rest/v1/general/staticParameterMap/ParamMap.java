package application.rest.v1.general.staticParameterMap;

import java.util.HashMap;
import java.util.Map;

public class ParamMap {

	public static int  returnParameterMap(String key) {
		Map<String, Integer> hm = new HashMap<String, Integer>(); 
		hm.put("Temperature", 1); 
	    hm.put("PH Level", 2); 
	    hm.put("Total Dissolved Solid", 3); 
	    hm.put("Dissolved Oxygen", 4);
	    hm.put("Ammonia Level", 5); 
	    
	    int x = 0;
	    for (Map.Entry<String, Integer> me : hm.entrySet()) { 
	    	if (me.getKey().equals(key)) {
				x = me.getValue();
			}
        } 
	    
	    return x;
	}
	
}
