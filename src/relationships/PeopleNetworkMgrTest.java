package relationships;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

import accounts.*;


public class PeopleNetworkMgrTest {

	private static int _nbrAccts = 8; 
	private static Account[] _accts;
	private static PeopleNode[] _people;
	
	
	@BeforeClass
	public static void oneTimeSetUp() {
		_accts = new Account[ _nbrAccts ];
		_people = new PeopleNode[ _nbrAccts ];
		
		for ( int i=0; i<_nbrAccts; i++ ) {
			_accts[i] = createTestAcct( i );
			_people[i] = new PeopleNode( _accts[i].getID() );
			PeopleNetworkMgr.addPersonToNetwork( _people[i] );
		}
		
		_people[1].addFriend( _people[2].getID() );		
		_people[1].addFriend( _people[3].getID() );
		_people[1].addFriend( _people[4].getID() );
		
		_people[2].addFriend( _people[1].getID() );		
		_people[2].addFriend( _people[3].getID() );
		_people[2].addFriend( _people[6].getID() );
		
		_people[3].addFriend( _people[1].getID() );		
		_people[3].addFriend( _people[2].getID() );
		
		_people[5].addFriend( _people[7].getID() );		
		_people[5].addFriend( _people[3].getID() );		
		
    }
	

	private static Account createTestAcct( int nbr ) {
		Account newAcct = new Account( "id" + nbr );
		newAcct.setName( "someone" + nbr );
		newAcct.setEmailAddr( newAcct.getName() + "@someplace.org" );
		
		return newAcct;
	}
	
	
	@Test
	public void testGetFriendsOfFriends1() {
		List<String> friends = PeopleNetworkMgr.getFriendsOfFriends( _accts[0].getID() );
		assertEquals( 0, friends.size() ); 
	}
	
	@Test
	public void testGetFriendsOfFriends2() {
		List<String> friends = PeopleNetworkMgr.getFriendsOfFriends( _accts[1].getID() );
		assertEquals( 4, friends.size() ); // should contain 2, 3, 4, 6
	}
	
	
	@Test
	public void testGetFriendsOfFriends3() {
		_people[1].addFriend( _people[2].getID() );		
		List<String> friends = PeopleNetworkMgr.getFriendsOfFriends( _accts[1].getID() );
		assertEquals( 4, friends.size() ); // should still contain 2, 3, 4, 6
	}
	

	@Test
	public void testGetFriendsOfFriends4() {
		_people[1].addFriend( _people[5].getID() );		
		List<String> friends = PeopleNetworkMgr.getFriendsOfFriends( _accts[1].getID() );
		assertEquals( 6, friends.size() ); // should still contain 2, 3, 4, 5, 6, 7
	}
	
	
}
