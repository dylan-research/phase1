package relationships;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class PeopleNetworkMgr {

	public static Map<String, PeopleNode> _network;
	
	static {
		_network = new HashMap<String, PeopleNode>();
	}
	
	
	public static int addPersonToNetwork( PeopleNode person ) {
		if ( person == null )
			return -1;
		
		if ( person.getID() == null || person.getID().length() == 0 )
			return -1;
		
		if ( _network.containsKey( person.getID() ))
			return 1;
		
		_network.put( person.getID(), person );
		
		return 0;
	}
	
	
	public static int removePersonFromNetwork( String acctID ) {
		if ( acctID == null || acctID.length() == 0 )
			return -1;
		
		if ( !_network.containsKey( acctID ) )
			return 1;
		
		_network.remove( acctID );
		
		return 0;
	}
	
	
	// acctID: account ID
	public static List<String> getFriendsOfFriends( String acctID ) {
		if ( acctID == null || acctID.length() == 0 )
			return null;
		
		// return a list of all the people in the network for the account ID
		// in other words, return all the friends of person represented by the account ID
		// as well, return all the friends of the friends of the person
		
		return new ArrayList<String>();
	}
}
