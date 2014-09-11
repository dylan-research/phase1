package signin;

import java.util.Map;
import java.util.HashMap;


public class LoginMgr {

	private static Map _logins;
	
	static {
		_logins = new HashMap< String, String >(); 		// used to store logins
	}

	
	/**
	 * login: login to be added
	 */
	public static int addLogin( Login login ) {
		/**
		 * return 0: added without a problem
		 * return 1: id of login already exists
		 * return -1: login has invalid id ("" or null) or invalid pwd ("" or null)  
		 */
		if(login.getID()==""||login.getID()==null||login.getPwd()==""||login.getPwd()==null)
			return -1;
		else if(_logins.containsKey(login.getID()))
				return 1; 
		else{
			_logins.put(login.getID(), login.getPwd());
			return 0;
		}
	}
	
	
	/**
	 * id: login ID
	 */
	public static int removeLogin( String id ) {
		/**
		 * return 0: removed without a problem
		 * return 1: id of login does not exist
		 * return -1: invalid id  ("" or null)
		 */
		if(id==""||id==null)
			return -1;
		else if(!_logins.containsKey(id))
			return 1;
		else{
			_logins.remove(id);
			return 0;
		}
	}
	

	/**
	 * login: login to be checked 
	 */
	public static boolean checkLogin( Login login ) {
		/**
		 * return false: login has invalid id ("" or null) or invalid pwd ("" or null)
		 * return true: if login id and pwd matches one in the system
		 * return false: if login id and pwd does not match one in the system
		 */
		if(login.getID()==""||login.getID()==null||login.getPwd()==""||login.getPwd()==null)
			return false;
		if(_logins.containsKey(login.getID())){
			if(_logins.get(login.getID()).equals(login.getPwd()))
				return true;
			else
				return false;
		}
		else 
			return false;
		
	}
}
