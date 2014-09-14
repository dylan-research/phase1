package accounts;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;


public class AccountMgr {

	
	public static Map _accts;	// used to store accounts
	
	static {
		_accts = new HashMap< String, Account >();
	}
	
	
	
	public static int addAcct( Account acct ) {
		/**
		 * return 0: added without a problem
		 * return 1: account with same id already exists
		 * return 2: account with same email address already exists
		 * return -1: account has invalid id ("" or null)
		 */
		
		
		if (acct.getID() == null)
			return -1;
		if (acct.getID().equals(""))
			return -1;
		if (_accts.containsKey(acct.getID()))
			return 1; 	
		
		Iterator ita =  _accts.entrySet().iterator();
		while(ita.hasNext()){
			Entry  obj = (Entry) ita.next();
			if (((Account)obj.getValue()).getEmailAddr().equals(acct.getEmailAddr()))
				return 2;
		}
         
		
		_accts.put(acct.getID(), acct);
		return 0;
		
		
	}
	
	
	public static int removeAcct( String id ) {
		/**
		 * return 0: removed without a problem
		 * return 1: account does not exists
		 * return -1: invalid id ("" or null) 
		 */
		
		if (id == null)
			return -1;
		if (id.equals(""))
			return -1;
		if (!_accts.containsKey(id))
			return 1;
		
		_accts.remove(id);
		return 0;
		
	}
	
	public static Account getAcct( String id ) {
		/**
		 * return account for id
		 * return null: invalid id ("" or null)
		 * return null: account does not exists for id
		 */
		
		if (id == null)
			return null;
		if (id.equals(""))
			return null;
		if (!_accts.containsKey(id))
			return null;
		
		return  (Account) _accts.get(id);
	
	}

	
	// public static int changeEmailAddr( String acctID, String emailAddr ) {
	//		return 0;
	// } 
	
	
	// public static int changeLocation( String acctID, String locCode ) {
	//		return 0;
	// }
}
