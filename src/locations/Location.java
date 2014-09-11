package locations;

import java.util.Map;
import java.util.HashMap;


public class Location {

	//public static int TYPE_COMMUNITY = 10000;
	//public static int TYPE_DISTRICT = 1000;
	//public static int TYPE_CITY = 100;
	//public static int TYPE_PROVINCE = - 10;
	//public static int TYPE_COUNTRY = 1;
	
	private String _code;
	private String _name;
	private Map<String, Location> _subLocs;
	
	
	public Location( String code, String name ) {
		_code = code;
		_name = name;
		_subLocs = new HashMap< String, Location >();
	}
	
	
	public String getCode() {
		return _code;
	}
	
	public void setCode( String code ) {
		_code = code;
	}
	
	
	public String getName() {
		return _name;
	}
	
	public void setName( String name ) {
		_name = name;
	}
		
	
	// loc: a location
	public int addSubLocation( Location loc ) {
		// return -1: if loc is null
		// return -1: if location's code is invalid ("" or null)
		// return 1: if a location with the same code has already been added
		
		return 0; // if the location was added successfully
	}
		
	
	// locCode: location code
	public int removeSubLocation( String locCode ) {
		// return -1: if locCode is invalid ("" or null)
		// return 1: if the location could not found
		
		return 0; // if the location was removed successfully
	}
	
	
	// get a list of the sublocations 
	public Location[] getSubLocations() {
		// return an array of the sublocations 
		// sort the array so that the names of the sublocations are ordered alphabetically

		return null; // if there are no sublocations
	}
}
