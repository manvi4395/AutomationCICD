package manvisharmaanatomy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException 
	{
	
		//read Json to string
				String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//manvisharmaanatomy//data//PurchaseOrder.json"),StandardCharsets.UTF_8);
				
				//String to HashMap - Jackson Databind
				ObjectMapper mapper = new ObjectMapper();
				List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
				});
							
				return data;
		
	}

}
