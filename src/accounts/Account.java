package accounts;

public class Account {

	private String _id;
	private String _name;
	private String _emailAddr;
	private String _locCode;
	
	
	public Account( String id ) {
		_id = id;
		_name = "";
		_emailAddr = "";
		_locCode = "";
	}

	
	public String getID() {
		return _id;		
	}
	
	public void setID( String id ) {
		
	}
	
	
	public String getName() {
		return _name;
	}
	
	public void setName( String name ) {
		_name = name;
	}
	
	
	public String getEmailAddr() {
		return _emailAddr;
	}
	
	public void setEmailAddr( String emailAddr ) {
		_emailAddr = emailAddr;
	}
	
	
	public String getLocationCode() {
		return _locCode;
	}
	
	public void setLocationCode( String code ) {
		_locCode = code;
	}
	
}
