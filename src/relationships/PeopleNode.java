package relationships;

import java.util.Set;
import java.util.HashSet;


public class PeopleNode {

	private String _acctID;
	private Set<String> _friends;
	
	
	public PeopleNode( String id ) {
		_acctID = id;
		_friends = new HashSet<String>();
	}

	
	public String getID() {
		return _acctID;
	}
	
	
	public void addFriend( String friendID ) {
		_friends.add( friendID );
	}
	
	public void removeFriend( String id ) {
		_friends.remove( id );
	}
	
	
	public Set<String> getFriends() {
		return _friends;
	}
	
	
}
