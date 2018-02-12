package project.maven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;


/**
 * @author Crunchify.com
 */
 
public class filterShops {
 
	
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
    	JSONParser parser = new JSONParser();
    	BufferedWriter writer = new BufferedWriter(new FileWriter(
                "/Users/lalithadwarapudi/Desktop/projects_masters/business_id_cb"));
    	try (BufferedReader br = new BufferedReader(new FileReader("/Users/lalithadwarapudi/Desktop/projects_masters/business.txt"))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	       // process the line.
    	    	
    	    			Object obj = parser.parse(line);
     
                JSONObject jsonObject = (JSONObject) obj;
                JSONArray categories = (JSONArray) jsonObject.get("categories");
                int length=categories.size();
                int i=0;
                while(i<length)
                {
	                if(((String) categories.get(i)).toLowerCase().contains("coffee") || ((String) categories.get(i)).toLowerCase().contains("cafes")) {
	                		String businessId = (String) jsonObject.get("business_id");
	                		System.out.println(businessId);
	                		writer.write(businessId);
	                		writer.newLine();
	                		break;
	                }
	                i++;
                }
                        		
    	    }
    	}catch (Exception e) {
            e.printStackTrace();
        }
    	writer.close();
    	System.out.println("done shops");
    		
    }
}