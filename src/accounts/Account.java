package accounts;

public class Account {

	private String _id;
	private String _name;
	private String _emailAddr;
	private String _cityID;
	private String _countryID;
	
	
	public Account( String id ) {
		_id = id;
	}
	
	public String getID() {
		return _id;		
	}
	
	public String getName() {
		return _name;
	}
	
	public String getEmailAddr() {
		return _emailAddr;
	}
	
	public String getCityID() {
		return _cityID;
	}
	
	public String getCountryID() {
		return _countryID;
	}
}
