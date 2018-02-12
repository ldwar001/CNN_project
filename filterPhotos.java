package project.maven;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class filterPhotos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	JSONParser parser = new JSONParser();
	Set<String> set = new HashSet<String>();
    	BufferedWriter writer = new BufferedWriter(new FileWriter(
                "/Users/lalithadwarapudi/Desktop/projects_masters/photos_cb"));
    	try (BufferedReader br = new BufferedReader(new FileReader("/Users/lalithadwarapudi/Desktop/projects_masters/business_id_coffee_partial"))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	       // process the line.
    	    		set.add(line);
    	    }
    	    System.out.println(set.size());
    	}catch (Exception e) {
            e.printStackTrace();
        }
    	
    	try (BufferedReader b = new BufferedReader(new FileReader("/Users/lalithadwarapudi/Desktop/projects_masters/yelp_photos/photos.json"))) {
    	    String line;
    	    while ((line = b.readLine()) != null) {
    	       // process the line.
    	    	
    	    			Object obj = parser.parse(line);
     
                JSONObject jsonObject = (JSONObject) obj;
                String business = (String) jsonObject.get("business_id");
                System.out.println(business);
                if(set.contains(business)) {
                		String photoId = (String) jsonObject.get("photo_id");
                		writer.write(photoId);
                		writer.newLine();  
                }                  		
    	    }
    	}catch (Exception e) {
            e.printStackTrace();
        }
    	writer.close();
    	System.out.println(set.size());
    	System.out.println("done photos");
	}
}
