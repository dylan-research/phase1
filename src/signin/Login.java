package signin;

public class Login {

	private String _acctID;
	private String _pwd;
	
	
	public Login( String acctID, String pwd ) {
		_acctID = acctID;
		_pwd = pwd;
	}
	
	
	public String getID() {
		return _acctID;
	}
	
	public String getPwd() {
		return _pwd;
	}
}
